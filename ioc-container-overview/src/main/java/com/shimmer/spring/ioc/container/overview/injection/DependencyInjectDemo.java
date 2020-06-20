package com.shimmer.spring.ioc.container.overview.injection;

import com.shimmer.spring.ioc.container.overview.repository.UserRepository;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author aurora
 * @date 2020/6/20 16:20
 */
public class DependencyInjectDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        //1.自定义bean
        UserRepository userRepository = (UserRepository) applicationContext.getBean("userRepository");
        System.out.println(userRepository.getUsers());

        ObjectFactory objectFactory = userRepository.getObjectFactory();

        System.out.println(objectFactory.getObject() == applicationContext);

        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean：" + environment);

    }
}
