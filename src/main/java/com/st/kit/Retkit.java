package com.st.kit;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @ClassName Retkit
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/3 0003 上午 11:33
 * @Version 1.0
 **/
@Data
public class Retkit<T> implements Serializable {
    private static final long serialVersionUID = -2986502900753534575L;

    private  static  final Boolean TRUE = Boolean.TRUE;

    private  static  final Boolean FALSE = Boolean.FALSE;

    private static final Integer SUCCESS_CODE = HttpStatus.OK.value();

    /**
     * 请求是否成功
     */
    private  Boolean success;

    /**
     * 请求失败的状态码
     */
    private Integer code;

    /**
     * 错误的提示信息
     */
    private String message;


    /**
     * 放回数据统一存放在data内
     */
    private T data;

    public static <T> Retkit<T> ok(){
        Retkit<T> ret = new Retkit<>();
        ret.setSuccess(TRUE);
        ret.setCode(SUCCESS_CODE);
        return ret;
    }

    public static <T> Retkit<T> ok(T data){
        Retkit<T> ret = new Retkit<>();
        ret.setSuccess(true);
        ret.setCode(SUCCESS_CODE);
        ret.setData(data);
        return ret;
    }

    public Retkit<T> data(T data){
        this.setData(data);
        return this;
    }

    public static <T> Retkit<T> fail(){
        Retkit<T> ret = new Retkit<>();
        ret.setSuccess(FALSE);
        return ret;
    }

    public Retkit<T> code(Integer code){
        this.setCode(code);
        return this;
    }

    public Retkit message(String message){
        this.setMessage(message);
        return this;
    }
}
