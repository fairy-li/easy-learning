package com.shimmer.spring.ioc.container.overview.lookup;

import com.shimmer.spring.ioc.container.overview.annotation.Super;
import com.shimmer.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author aurora
 * @date 2020/6/18 21:38
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        //实时查找  根据类型
        lookUpByType(beanFactory);
//        //延迟查找
//        lookUpInLazy(beanFactory);
//        //根据name实时查找
//        lookupByName(beanFactory);

        lookupCollectionByType(beanFactory);

        lookupByAnnotationType(beanFactory);

    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, Object> beans = listableBeanFactory.getBeansWithAnnotation(Super.class);
        System.out.println("lookupByAnnotationType:" + beans);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
        System.out.println("lookupCollectionByType:" + beansOfType);
    }


    private static void lookupByName(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("lookup by name :   " + user);
    }

    private static void lookUpByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("lookUpByType:   " + user);
    }

    private static void lookUpInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("lazy lookup:   " + user);
    }
}
