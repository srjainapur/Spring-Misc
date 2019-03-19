package com.bean.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.scope.bean.PrototypeBean;
import com.bean.scope.bean.SingletonBean;
import com.bean.scope.config.ApplicationConfig;

public class BeanScopeTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		SingletonBean firstSingleton = context.getBean(SingletonBean.class);
		//PrototypeBean firstPrototype = context.getBean(PrototypeBean.class);
		PrototypeBean firstPrototype = (PrototypeBean)context.getBean("prototypeBean");
		
		// get singleton bean instance one more time
	    SingletonBean secondSingleton = context.getBean(SingletonBean.class);
	    PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();
	    PrototypeBean secondPrototypee = secondSingleton.getPrototypeBean();//context.getBean(PrototypeBean.class);
	    
	    System.out.println("Hashcode of firstPrototype  :- " + firstPrototype.hashCode());
	    System.out.println("HashCode of secondPrototypee :- " + secondPrototypee.hashCode());
	    System.out.println("HashCode of secondPrototype :- " + secondPrototype.hashCode());
	    
	    System.out.println("\n");
	    
	    if (firstPrototype.hashCode() == secondPrototype.hashCode()) {
	    	System.out.println("The same instance should be returned");
	    } else {
	    	System.out.println("Different instance of prototype bean");
	    }
	    
	    System.out.println("\n");	    
	    PrototypeBean protoBeanFirst = secondSingleton.getProtoBean();
	    PrototypeBean protoBeanSecond = secondSingleton.getProtoBean();
	    
	    System.out.println("protoBeanFirst :- " + protoBeanFirst.hashCode());
	    System.out.println("protoBeanSecond :- " + protoBeanSecond.hashCode());
	}
}
