package com.shimmer.spring.dependency.injection;

import com.shimmer.spring.dependency.injection.domain.UserHolder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author aurora
 * @date 2020/6/21 15:28
 */
public class AutowiringDependencyInjectionDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/autowiring-dependency-setter-injection.xml");

        UserHolder userHolder2 = beanFactory.getBean("userHolder2", UserHolder.class);
        System.out.println("通过setter 自动注入的userHolder: "+userHolder2);

        UserHolder userHolder3 = beanFactory.getBean("userHolder3", UserHolder.class);
        System.out.println("通过construct 自动注入的userHolder: "+userHolder3);
    }
}
