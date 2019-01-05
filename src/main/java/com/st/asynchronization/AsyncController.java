package com.st.asynchronization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName AsyncController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/3 0003 下午 2:56
 * @Version 1.0
 **/
@RestController
public class AsyncController {
    @Autowired
    private MsgService msgService;
    @GetMapping(value = "/company/async/noret")
    public Map<String, Object> getAsyncNoRet() throws Exception{
        Map<String, Object> stringObjectMap = new HashMap<>(16);
        msgService.sendA();

        msgService.sendB();
        stringObjectMap.put("success",true);
        return stringObjectMap;
    }

    @GetMapping(value = "/company/async/ret")
    public Map<String, Object> getAsyncRet() throws Exception{
        Map<String, Object> ret = new HashMap<>(16);
        Future<String> sendC = msgService.sendC();
        Future<String> sendD = msgService.sendD();
        String sendCRet = sendC.get(5000,TimeUnit.MILLISECONDS);
        String sendDRet = sendD.get(5000,TimeUnit.MILLISECONDS);
        ret.put("success", true);
        ret.put("sendC", sendCRet);
        ret.put("sendD", sendDRet);
        return ret;
    }

}
