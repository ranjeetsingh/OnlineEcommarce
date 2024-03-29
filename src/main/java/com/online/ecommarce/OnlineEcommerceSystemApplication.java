package com.online.ecommarce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.online.ecommarce.apputil.AppConstant;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/** 
 * 
 * @author RanjeetSi
 *
 */
/**
 * The OnlineEcommerceSystemApplication class implements an application that
 * simply prints "Application start.." to standard output.
 * @author RanjeetSi
 */

@SpringBootApplication
@EnableSwagger2
public class OnlineEcommerceSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineEcommerceSystemApplication.class, args);
		System.out.println("Application start.....");

	}

	/** 
	 * Creating Docket bean
	 *@return Docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(AppConstant.DEFAULT_API_INFO)
				.produces(AppConstant.DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(AppConstant.DEFAULT_PRODUCES_AND_CONSUMES);
	}

}
