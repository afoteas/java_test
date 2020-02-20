package com.test;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class CallableInterrupt extends TestFrame
{

    public CallableInterrupt(){

    } 
    class CallableTest implements Callable<String> {

   
        @Override
        public String call() throws Exception {
            String result = "sleeping";
            try{
                System.out.println( "goto bed");
                Thread.sleep(5000);
                result = "awake";
                return result;
            } catch( InterruptedException ex){
                result = "interrupted";
                System.out.println( "interrupted");
                return result;
            }

        }
    }

    @Override
    public void test(){
        System.out.println("Hello, World"); 
        ExecutorService executor = Executors.newCachedThreadPool();
        CallableTest task = new CallableTest();
        Future<String> future = executor.submit(task);
        try {
            System.out.println( future.get(4, TimeUnit.SECONDS));
        } catch (TimeoutException | ExecutionException | InterruptedException ex) {
            System.out.println( "timeout");
        } finally {
            future.cancel(true);
            executor.shutdown();
        }
    }

}