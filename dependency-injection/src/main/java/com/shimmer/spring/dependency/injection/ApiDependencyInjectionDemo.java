package com.shimmer.spring.dependency.injection;

import com.shimmer.spring.dependency.injection.domain.UserHolder;
import com.shimmer.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author aurora
 * @date 2020/6/21 15:34
 */
public class ApiDependencyInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        beanDefinitionBuilder.addPropertyReference("user", "user");

        BeanDefinitionBuilder beanDefinitionBuilder2 = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        beanDefinitionBuilder2.addConstructorArgReference("superUser");

        applicationContext.registerBeanDefinition("userHolder", beanDefinitionBuilder.getBeanDefinition());
        applicationContext.registerBeanDefinition("userHolder2", beanDefinitionBuilder2.getBeanDefinition());

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        beanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup-context.xml");

        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean("userHolder", UserHolder.class);
        UserHolder userHolder2 = applicationContext.getBean("userHolder2", UserHolder.class);
        System.out.println(userHolder);
        System.out.println(userHolder2);

        applicationContext.close();
    }
}
