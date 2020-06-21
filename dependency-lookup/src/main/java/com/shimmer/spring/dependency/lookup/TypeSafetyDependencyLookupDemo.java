package com.shimmer.spring.dependency.lookup;

import com.shimmer.spring.ioc.container.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author aurora
 * @date 2020/6/21 14:03
 */
public class TypeSafetyDependencyLookupDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TypeSafetyDependencyLookupDemo.class);

        applicationContext.refresh();

        ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);
        printBeansException("beanProvider", () -> beanProvider.forEach(System.out::println));

        printBeansException("beanProvider#getIfAvailable", () -> beanProvider.getIfAvailable());

        ListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        printBeansException("beanFactory#getBean", () -> beanFactory.getBean(User.class));
        printBeansException("beanFactory#getBeansOfType", () -> beanFactory.getBeansOfType(User.class));

        printBeansException("applicationContext", () -> applicationContext.getBeansOfType(User.class));

        ObjectFactory<User> objectFactory = applicationContext.getBeanProvider(User.class);
        printBeansException("objectFactory", () -> objectFactory.getObject());

        applicationContext.close();
    }

    private static void printBeansException(String source, Runnable runnable) {
        System.out.println("==========================================");
        System.out.println("Source from :" + source);
        try {
            runnable.run();
        } catch (BeansException exception) {
            exception.printStackTrace();
        }
    }
}
