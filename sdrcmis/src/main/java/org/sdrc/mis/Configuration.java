/**
 * 
 */
package org.sdrc.mis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
@SpringBootApplication
@EntityScan(basePackages="org.sdrc.mis.domain")
@EnableJpaRepositories({"org.sdrc.mis.repository.springdata"})
@EnableTransactionManagement
public class Configuration  extends  SpringBootServletInitializer{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Configuration.class, args);

	}
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Configuration.class);
	    }
	
	// will uncomment while implementing security
	 
/*	@Bean
	public MessageDigestPasswordEncoder passwordEncoder() {
		return new MessageDigestPasswordEncoder("sha-256");
	}*/

}
