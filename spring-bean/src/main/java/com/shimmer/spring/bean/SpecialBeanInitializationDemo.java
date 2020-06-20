package com.shimmer.spring.bean;

import com.shimmer.spring.factory.DefaultUserFactory;
import com.shimmer.spring.factory.UserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

import static java.util.ServiceLoader.load;

/**
 * @author aurora
 * @date 2020/6/20 23:00
 */
public class SpecialBeanInitializationDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-initialization-context.xml");

        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        ServiceLoader serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);
        displayServiceLoader(serviceLoader);

//        demoServiceLoader();

        // 创建 UserFactory 对象，通过 AutowireCapableBeanFactory
        UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createUser());
    }

    private static void deServiceLoader() {
        ServiceLoader<UserFactory> loader = load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(loader);
    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }

}
