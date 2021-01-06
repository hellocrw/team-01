package my.study.demo.lock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LockTest {

    @GetMapping("/test")
    public void test() throws InterruptedException {
        synchronized (this){
            Thread.sleep(1000);
            System.out.println("test");
        }
    }
}
