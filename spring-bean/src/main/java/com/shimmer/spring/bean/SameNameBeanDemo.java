package com.shimmer.spring.bean;

import com.shimmer.spring.ioc.container.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author aurora
 * @date 2020/6/20 22:05
 */
public class SameNameBeanDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(SameNameBeanDemo.class);
        applicationContext.refresh();

        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    @Bean(name = "user")
    private User user2() {
        User user = new User();
        user.setId(3);
        user.setName("lishi");
        return user;
    }

    @Bean(name = "user")
    private User user1() {
        User user = new User();
        user.setId(2);
        user.setName("zhangsan");
        return user;
    }

}
