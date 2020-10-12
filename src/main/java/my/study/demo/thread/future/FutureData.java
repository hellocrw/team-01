package my.study.demo.thread.future;

import java.util.Observable;

public class FutureData {
    // 存放真实数据，并且标志真正的数据是否准备完毕
    // 被多线程享受
    // 如果realData == null ,表示数据还未准备好
    public volatile RealData realData = null;

    // 查看数据是否已经准备好
    public boolean isfinished(){
        return realData != null;
    }

    public String getContent(){
        synchronized (mutex){
            while (!isfinished()){ // 只要数据还未准备好，就阻塞调用线程
                try {
                    mutex.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return realData.getContent();
        }
    }

    public void update(Observable realData, Object event) throws IllegalAccessException {
        System.out.println("通知。。。"+ event);
        if (!(realData instanceof RealData)){
            throw new IllegalAccessException("主题的数据必须是RealData");
        }
        if(!(event instanceof String)){
            throw new IllegalAccessException("事件的数据必须是String");
        }
        synchronized (mutex){
            if (isfinished()){
                mutex.notifyAll();
                return;
            }
            if ("finished".equals(event)){
                realData = realData;  // 数据准备好了的时候，可以通知数据准备好了
                mutex.notifyAll();  // 唤醒阻塞的线程
            }
        }
    }

    public Object mutex = new Object();
}
