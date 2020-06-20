package com.shimmer.spring.bean;

import com.shimmer.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author aurora
 * @date 2020/6/20 23:00
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-initialization-context.xml");

        User constructUser = beanFactory.getBean("user-by-construct", User.class);
        System.out.println("构造器注入的user:" + constructUser);

        User staticUser = beanFactory.getBean("user-by-static-method", User.class);
        System.out.println("静态方法注入的user:" + staticUser);

        User instanceUser = beanFactory.getBean("user-by-instance-method", User.class);
        System.out.println("实例化方法注入的user:" + instanceUser);

        User factoryUser = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println("FactoryBean注入的user:" + factoryUser);

        System.out.println(staticUser == constructUser);
        System.out.println(staticUser == instanceUser);
        System.out.println(instanceUser == factoryUser);
    }
}
