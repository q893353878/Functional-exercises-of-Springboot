package com.st.asynchronization;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @ClassName MsgService
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/3 0003 下午 2:56
 * @Version 1.0
 **/
@Service
public class MsgService {
    @Async(value = "taskExecutor")
    public void sendA() throws Exception{
        System.out.println("send A");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        Long endTime = System.currentTimeMillis();
        System.out.println("Message A : 耗时:" + (endTime - startTime));
    }

    @Async(value = "taskExecutor")
    public void sendB() throws Exception{
        System.out.println("send B");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        Long endTime = System.currentTimeMillis();
        System.out.println("Message B : 耗时:" + (endTime - startTime));

    }

    @Async(value = "taskExecutor")
    public Future<String> sendC() throws Exception{
        System.out.println("send C");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        Long endTime = System.currentTimeMillis();
        System.out.println("Message C : 耗时：" + (endTime - startTime));
        return new AsyncResult<String>("sendC");
    }

    @Async(value = "taskExecutor")
    public Future<String> sendD() throws Exception{
        System.out.println("send D");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        Long endTime = System.currentTimeMillis();
        System.out.println("Message D : 耗时:" + (endTime - startTime));
        return new AsyncResult<String>("sendD");
    }

    @Async(value = "taskExecutor")
    public void taskA() throws Exception{
        System.out.println("进行A任务...A任务开始休眠");
        Thread.sleep(3000);
        System.out.println("A任务休眠结束，继续执行... 任务A完成");
    }
    @Async(value = "taskExecutor")
    public void taskB() throws Exception{
        System.out.println("进行B任务...任务B完成");
    }

    public void taskC() throws Exception{
        System.out.println("进行C任务...C任务开始休眠");
        Thread.sleep(3000);
        System.out.println("C任务休眠结束，继续执行... 任务C完成");
    }

    public void taskD() throws Exception{
        System.out.println("进行D任务...任务D完成");
    }

}
