package com.online.ecommarce.apputil;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.online.ecommarce.controller.ivalidator.IServiceValidator;
import com.online.ecommarce.controller.ivalidator.IDataRequestValidator;
import com.online.ecommarce.controller.validatorimpl.DataRequestValidatorImp;
import com.online.ecommarce.controller.validatorimpl.ServiceValidatorImp;


/** 
 * Create AppConfig class
 * Creating other Bean
 * @author RanjeetSi
 *
 */
@Configuration
public class AppConfig {

	/** 
	 * Creating bean for data request validator
	 * @return DataRequestValidatorImp
	 *
	 */
	@Bean
	IDataRequestValidator findIValidator() {
		return new DataRequestValidatorImp();
	}
	
	/** 
	 * Creating bean for service validator
	 * @return ServiceValidatorImp
	 *
	 */
	@Bean
	IServiceValidator findIServiceValidator() {
		return new ServiceValidatorImp();
	}
}
