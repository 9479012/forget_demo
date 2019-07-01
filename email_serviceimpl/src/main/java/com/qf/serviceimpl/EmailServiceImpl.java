package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author 王铭
 * @Date 2019/6/29
 */
@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void foundMima(String to) {
        //创建一封邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //创建一个Spring提供的邮件帮助对象
        MimeMessageHelper messageHelper = null;
        try {
            messageHelper = new MimeMessageHelper(mimeMessage, true);
            //设置发送方
            messageHelper.setFrom("verygoodwlk@sina.cn");
            //设置接收方
            messageHelper.addTo(to, "金牌会员");
            //设置标题
            messageHelper.setSubject("找回密码！");
            //设置内容 这个邮件中的地址得带上用户名和邮箱地址
            messageHelper.setText("请点击<a href='localhost:8080/user/found'>这里</a>找回密码~", true);
            //设置时间
            messageHelper.setSentDate(new Date());
            //发送邮件
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void yanZheng(String to,Integer number) {
        //创建一封邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //创建一个Spring提供的邮件帮助对象
        MimeMessageHelper messageHelper = null;
        try {
            messageHelper = new MimeMessageHelper(mimeMessage, true);
            //设置发送方
            messageHelper.setFrom("verygoodwlk@sina.cn");
            //设置接收方
            messageHelper.addTo(to, "金牌会员");
            //设置标题
            messageHelper.setSubject("你的验证码");
            //设置内容
            messageHelper.setText("'你的验证码是'+number", true);
            //设置时间
            messageHelper.setSentDate(new Date());
            //发送邮件
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
