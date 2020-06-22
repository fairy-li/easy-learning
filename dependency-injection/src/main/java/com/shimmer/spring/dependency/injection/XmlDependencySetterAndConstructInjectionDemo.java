package com.shimmer.spring.dependency.injection;

import com.shimmer.spring.dependency.injection.domain.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author aurora
 * @date 2020/6/21 15:10
 */
public class XmlDependencySetterAndConstructInjectionDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/autowiring-dependency-setter-injection.xml");

        UserHolder userHolder = beanFactory.getBean("userHolder",UserHolder.class);
        System.out.println(userHolder);

        UserHolder bean = beanFactory.getBean(UserHolder.class);
        System.out.println(bean);
    }

}
