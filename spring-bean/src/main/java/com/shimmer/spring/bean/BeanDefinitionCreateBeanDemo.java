package com.shimmer.spring.bean;

import com.shimmer.spring.ioc.container.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author aurora
 * @date 2020/6/20 22:14
 */
public class BeanDefinitionCreateBeanDemo {

    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();

        beanDefinitionBuilder.addPropertyValue("id",1).addPropertyValue("name","菊花爆满山");

        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id",1).add("name","桃花朵朵开");

        genericBeanDefinition.setPropertyValues(propertyValues);

    }
}
