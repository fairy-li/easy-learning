package com.shimmer.spring.bean;

import com.shimmer.spring.ioc.container.overview.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author aurora
 * @date 2020/6/20 22:00
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");

        User user = applicationContext.getBean("user", User.class);
        User juhua = applicationContext.getBean("juhua", User.class);
        System.out.println("user == juhua:" + (user == juhua));
    }
}
