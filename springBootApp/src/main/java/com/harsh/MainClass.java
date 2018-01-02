package com.harsh;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.harsh.domain.Employee;

@SpringBootApplication
@EntityScan(basePackages="com.harsh.domain")
@EnableJpaRepositories({"com.harsh.repository.springdatajpa"})
@EnableTransactionManagement
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class MainClass extends  SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MainClass.class, args);

	}
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		 	setRegisterErrorPageFilter(false);
	        return application.sources(MainClass.class);
	    }
	 
		@Bean
		public MessageDigestPasswordEncoder passwordEncoder() {
			return new MessageDigestPasswordEncoder("sha-256");
		}

		@Bean
		public AuditorAware<Employee> auditorAware() {
			return new AuditorAwareImpl();
		}
}
