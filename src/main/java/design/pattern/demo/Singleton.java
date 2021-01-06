package design.pattern.demo;
/** 
* @Description: 单例模式 
* @Param: Singleton
* @return:  
* @Author: caorongwu
* @Date: 2020/12/1 
*/
public class Singleton {

    private static Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
    }
}
