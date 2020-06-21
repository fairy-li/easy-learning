package com.shimmer.spring.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * beanProvider 单一查找demo
 *
 * @author aurora
 * @date 2020/6/21 13:03
 */
public class ObjectProviderDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ObjectProviderDemo.class);

        applicationContext.refresh();

        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        String object = beanProvider.getObject();
        System.out.println("beanProvider 查找:" + object);

        String ifAvailable = beanProvider.getIfAvailable();
        System.out.println("ifAvailable :" + ifAvailable);

//        Iterator<String> iterator = beanProvider.iterator();
//        while (iterator.hasNext()){
//            System.out.println( iterator.next());
//        }
        beanProvider.stream().forEach(System.out::println);
    }

    @Bean
    @Primary
    private String helloWorld() {
        return "hello-world";
    }

    @Bean
    private String message() {
        return "Message";
    }
}
