package crw.bishe.team.controller.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
@RequestMapping("/api/mail")
public class MailController {

    @Autowired
    private JavaMailSenderImpl mailSender;

    //发送普通邮箱
    @RequestMapping("/qq")
    public void sendQQMail(){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setSubject("springboot邮件测试");
        mailMessage.setText("四月是你的谎言");
        mailMessage.setFrom("2388092655@qq.com");//发送者，本人邮箱
        mailMessage.setTo("1121754955@qq.com");//发送给他人邮箱
        mailSender.send(mailMessage);
    }

    //发送邮箱带附件
    @RequestMapping("/sendadvance")
    @Scheduled(cron = "0 0/1 * * * ? ")
    public void sendadvance() throws MessagingException {
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper helpers = new MimeMessageHelper(mimeMessage,true);
        helpers.setSubject("springboot mail 测试");
        helpers.setText("<p style='color:green'>四月是你的宫园薰</p>",true);
        helpers.addAttachment("说明.txt",new File("D:\\迅雷下载\\说明.txt"));//附件在本地位置
        helpers.setTo("1121754955@qq.com");//发送给他人邮箱
        helpers.setFrom("2388092655@qq.com");//发送者，本人邮箱
        mailSender.send(mimeMessage);
    }

}
