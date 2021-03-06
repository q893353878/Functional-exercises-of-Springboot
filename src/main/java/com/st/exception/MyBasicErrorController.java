package com.st.exception;

import cn.hutool.core.text.StrFormatter;
import com.st.kit.Retkit;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MyBasicErrorController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/3 0003 下午 1:52
 * @Version 1.0
 **/
@RequestMapping("${server.error.path:${error.path:/error}}")
public class MyBasicErrorController extends AbstractErrorController {
    private final ErrorProperties errorProperties;
    private String getString(Object object){
        if (object==null){
            return "";
        }
        return object.toString();
    }
    private static String ERROR="error";
    private static String MESSAGE="message";
    @RequestMapping
    public ResponseEntity<Retkit> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = getStatus(request);
        StringBuilder stringBuilder = new StringBuilder();
        Object errorDetail = body.get(ERROR);
        Object messageDetail = body.get(MESSAGE);
        stringBuilder.append(StrFormatter.format("{}:{};",ERROR,getString(errorDetail)))
                .append(StrFormatter.format("{}:{}",MESSAGE,getString(messageDetail)));
        return new ResponseEntity(Retkit.fail().message(stringBuilder.toString()).code(status.value()), HttpStatus.OK);
    }


    /**
     * Create a new {@link org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController} instance.
     *
     * @param errorAttributes the error attributes
     * @param errorProperties configuration properties
     */
    public MyBasicErrorController(ErrorAttributes errorAttributes,
                                  ErrorProperties errorProperties) {
        this(errorAttributes, errorProperties, Collections.emptyList());
    }

    /**
     * Create a new {@link org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController} instance.
     *
     * @param errorAttributes    the error attributes
     * @param errorProperties    configuration properties
     * @param errorViewResolvers error view resolvers
     */
    public MyBasicErrorController(ErrorAttributes errorAttributes,
                                  ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorViewResolvers);
        Assert.notNull(errorProperties, "ErrorProperties must not be null");
        this.errorProperties = errorProperties;
    }

    @Override
    public String getErrorPath() {
        return this.errorProperties.getPath();
    }
    /**
     * Determine if the stacktrace attribute should be included.
     *
     * @param request  the source request
     * @param produces the media type produced (or {@code MediaType.ALL})
     * @return if the stacktrace attribute should be included
     */
    protected boolean isIncludeStackTrace(HttpServletRequest request,
                                          MediaType produces) {
        ErrorProperties.IncludeStacktrace include = getErrorProperties().getIncludeStacktrace();
        if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
            return true;
        }
        if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
            return getTraceParameter(request);
        }
        return false;
    }

    /**
     * Provide access to the error properties.
     *
     * @return the error properties
     */
    protected ErrorProperties getErrorProperties() {
        return this.errorProperties;
    }

}
