package com.internship.repayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class RepaymentApplication extends WebMvcConfigurerAdapter {


	public static void main(String[] args) {
		SpringApplication.run(RepaymentApplication.class, args);
	}

}
