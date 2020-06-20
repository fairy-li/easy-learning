package com.shimmer.spring.ioc.container.overview.container;

import com.shimmer.spring.ioc.container.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @author aurora
 * @date 2020/6/20 17:40
 */
public class AnnotationApplicationContextAsIocContainerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);

//        User beforeUser = applicationContext.getBean(User.class);// 没有启动容器之前获取会报错
//        System.out.println("before refresh user: " + beforeUser);

        //刷新启动容器
        applicationContext.refresh();

        Map<String, User> beansOfType = applicationContext.getBeansOfType(User.class);
        System.out.println("applicationContext 查找的所有的Bean:" + beansOfType);

        applicationContext.close();
    }

    @Bean
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("微光");
        return user;
    }
}
