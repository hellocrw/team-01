package my.study.demo.thread.future;

import java.util.Observable;

public class RealData extends Observable implements Data {

    private String content;

    @Override
    public String getContent() {
        return content;
    }

    public void createRealData(int count, char c){
        System.out.println("making realData > " + c + "begin");
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("making realData > " + count + "> end");
            this.content = new String(buffer);
            // 真实数据已经准备好了
            setChanged(); // 必须先设置本对象的状态发生了变化，并通知所有观察者
            notifyObservers("finished");
        }
    }
}
