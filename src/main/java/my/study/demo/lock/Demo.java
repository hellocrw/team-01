package my.study.demo.lock;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                // TODO 真正的任务在这里执行，这里的返回值类型为String，可以为任意类型
                return "test";
            }
        });
        executorService.submit(futureTask);

        // TODO 在这里可以做别的任何事情
        try {
            String result = futureTask.get(5000, TimeUnit.MILLISECONDS);
            System.out.println(result);
        } catch (InterruptedException e) {
            futureTask.cancel(true);
        } catch (ExecutionException e) {
            futureTask.cancel(true);
        } catch (TimeoutException e) {
            futureTask.cancel(true);
        }finally {
            executorService.shutdown();
        }
    }
}
