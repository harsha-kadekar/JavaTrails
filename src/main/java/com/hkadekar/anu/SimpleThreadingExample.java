package com.hkadekar.anu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;


public class SimpleThreadingExample implements Runnable {
    private ScheduledExecutorService scheduledExecutorService;

    private static Logger LOGGER = LoggerFactory.getLogger(SimpleThreadingExample.class);

    public SimpleThreadingExample() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void trailFunc() {
        try{
            LOGGER.info("Going to sleep now");
            Thread.sleep(5000);
            LOGGER.info("Woke UP! Now done with my sleeping");
        } catch (Exception exp){
            LOGGER.error("ERROR: Recieved", exp);
        }

    }

    @Override
    public void run() {

        LOGGER.info("This is inside the run method");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        LOGGER.info("Before Calling");
        Future future = executorService.submit(() ->{
            trailFunc();
        });

        try{
            future.get(10, TimeUnit.SECONDS);
        }catch (Exception exp){
            LOGGER.error("ERROR IN RUN", exp);
        }finally {
            executorService.shutdown();
        }


    }

    public void start(){
        scheduledExecutorService.scheduleWithFixedDelay(this, 0, 10, TimeUnit.SECONDS);
    }

    public void shutdown(){
        scheduledExecutorService.shutdown();
    }
}
