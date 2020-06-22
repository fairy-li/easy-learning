package com.shimmer.spring.dependency.injection;

import com.shimmer.spring.dependency.injection.domain.UserHolder;
import com.shimmer.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author aurora
 * @date 2020/6/21 15:22
 */
public class AnnotationDependencyConstructInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencySetterInjectionDemo.class);

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/autowiring-dependency-setter-injection.xml");

        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);
    }

    @Bean
    private static UserHolder createUserHolder(User user) {
        return new UserHolder(user);
    }
}
