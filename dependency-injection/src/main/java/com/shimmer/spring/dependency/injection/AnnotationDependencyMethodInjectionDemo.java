package com.shimmer.spring.dependency.injection;

import com.shimmer.spring.dependency.injection.domain.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author aurora
 * @date 2020/6/21 15:47
 */
public class AnnotationDependencyMethodInjectionDemo {

    private UserHolder userHolder;

    private UserHolder userHolder2;

    private UserHolder userHolder3;

    private UserHolder userHolder4;

    @Autowired
    private void init(UserHolder userHolder) {
        this.userHolder = userHolder;
    }

    @Resource
    private void setUserHolder3(UserHolder userHolder) {
        this.userHolder2 = userHolder;
    }

    @Bean
    private UserHolder xxx(UserHolder userHolder) {
        this.userHolder3 = userHolder;
        return userHolder3;
    }

    private void setUserHolder4(UserHolder userHolder) {
        this.userHolder4 = userHolder;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencyMethodInjectionDemo.class);

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/autowiring-dependency-setter-injection.xml");

        applicationContext.refresh();

        AnnotationDependencyMethodInjectionDemo demo = applicationContext.getBean(AnnotationDependencyMethodInjectionDemo.class);
        System.out.println(demo.getUserHolder());
        System.out.println(demo.getUserHolder2());
        System.out.println(demo.getUserHolder3());
        System.out.println(demo.getUserHolder4());
    }

    public UserHolder getUserHolder() {
        return userHolder;
    }

    public UserHolder getUserHolder2() {
        return userHolder2;
    }

    public UserHolder getUserHolder3() {
        return userHolder3;
    }

    public UserHolder getUserHolder4() {
        return userHolder4;
    }
}
