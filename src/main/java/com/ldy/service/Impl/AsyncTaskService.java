package com.ldy.service.Impl;

import com.ldy.service.IAsyncTaskService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@EnableAsync
@Service("asyncTaskService")
public class AsyncTaskService implements IAsyncTaskService {

    @Async
    @Override
    public Future<String> dealHaveReturnTask() {
        long currentTimeMills0 = System.currentTimeMillis();
        Thread myThread = new Thread(()->{
            System.out.println("--------进入异步任务--------");
            System.out.println(Thread.currentThread().getName()+"我是执行异步任务中的一个线程");
        });
        myThread.start();
        try {
            Thread.sleep(3000);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        long currentTimeMills1 = System.currentTimeMillis();
        System.out.println("异步任务执行时间"+ (currentTimeMills1 - currentTimeMills0) + "ms");
        return new AsyncResult<>("异步调用结束后的结果返回");

    }
}
