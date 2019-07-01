package com.qf.email_serviceimpl;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
@DubboComponentScan("com.qf")
public class EmailServiceimplApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceimplApplication.class, args);
	}

}
