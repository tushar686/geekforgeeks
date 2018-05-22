package jdk.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/**
 * Created by ts250370 on 5/7/18.
 */
public class CallableTask {

    class DirectExecutor implements Executor {

        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }

    class ThreadPerTaskExecutor implements Executor {

        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }

    void createCallable() {
        DirectExecutor directExecutor = new DirectExecutor();
        directExecutor.execute(()->{
            System.out.println("Executre Runnable task");
        });

        ThreadPerTaskExecutor threadPerTaskExecutor = new ThreadPerTaskExecutor();
        threadPerTaskExecutor.execute(()->{
            System.out.println("Executing thread per task");
        });

    }

    public static void main(String[] args) {
        CallableTask callableTask = new CallableTask();
        callableTask.createCallable();
    }
}
