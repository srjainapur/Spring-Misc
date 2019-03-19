package com.bean.scope.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.bean.scope.bean.PrototypeBean;
import com.bean.scope.bean.SingletonBean;

@Configuration
public class ApplicationConfig {
	
	@Bean(name="prototypeBean")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }
	
	@Bean(name="protoBean")
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode=ScopedProxyMode.TARGET_CLASS)
	public PrototypeBean protoBean() {
		return new PrototypeBean();
	}
	
	@Bean
	public SingletonBean singletonBean() {
		return new SingletonBean();
	}
}
