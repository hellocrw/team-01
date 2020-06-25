package crw.bishe.team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
@ServletComponentScan
@EnableCaching
@EnableAspectJAutoProxy
@MapperScan("crw.bishe.team.mapper")
public class TeamApplication {

    public static void main(String[] args) {
//        AbstractQueuedSynchronizer aqs;
//        ReentrantLock reentrantLock;
        SpringApplication.run(TeamApplication.class, args);
    }

}
