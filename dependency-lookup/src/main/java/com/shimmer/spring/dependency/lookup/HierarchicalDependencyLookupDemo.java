package com.shimmer.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author aurora
 * @date 2020/6/21 13:25
 */
public class HierarchicalDependencyLookupDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);

        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();

        System.out.println("当前beanFactory的 parentBeanFactory: " + parentBeanFactory);

        HierarchicalBeanFactory parentBeanFactory2 = createParentBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory2);

        System.out.println("当前beanFactory的 parentBeanFactory: " + parentBeanFactory2);

        System.out.println("beanFactory是否包含LocalBean：user：" + beanFactory.containsLocalBean("user"));
        System.out.println("parentBeanFactory是否包含LocalBean：user：" + parentBeanFactory2.containsLocalBean("user"));

        System.out.println("beanFactory是否包含Bean：user：" + beanFactory.containsBean("user"));
        System.out.println("parentBeanFactory是否包含Bean：user：" + parentBeanFactory2.containsBean("user"));
    }

    private static ConfigurableListableBeanFactory createParentBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup-context.xml");

        return beanFactory;
    }
}
