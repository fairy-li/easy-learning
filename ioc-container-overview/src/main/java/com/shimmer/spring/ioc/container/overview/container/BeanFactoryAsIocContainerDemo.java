package com.shimmer.spring.ioc.container.overview.container;

import com.shimmer.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author aurora
 * @date 2020/6/20 17:30
 */
public class BeanFactoryAsIocContainerDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(beanFactory);
        //加载配置
        int beanDefinitionCount = definitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-injection-context.xml");
        System.out.println("beanDefinition count: " + beanDefinitionCount);

        Map<String, User> beanMap = beanFactory.getBeansOfType(User.class);
        System.out.println("beanFactory  查找的所有bean:" + beanMap);

    }
}
