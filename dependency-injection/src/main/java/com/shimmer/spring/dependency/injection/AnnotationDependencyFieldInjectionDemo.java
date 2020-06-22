package com.shimmer.spring.dependency.injection;

import com.shimmer.spring.dependency.injection.domain.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;

/**
 * @author aurora
 * @date 2020/6/21 15:47
 */
public class AnnotationDependencyFieldInjectionDemo {

    @Autowired
//    private static UserHolder userHolder; @Autowired 会忽略掉静态属性
    private UserHolder userHolder;

    @Resource(name = "userHolder2")
    private UserHolder userHolder2;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencyFieldInjectionDemo.class);

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/autowiring-dependency-setter-injection.xml");

        applicationContext.refresh();

        AnnotationDependencyFieldInjectionDemo demo = applicationContext.getBean(AnnotationDependencyFieldInjectionDemo.class);
        System.out.println(demo.getUserHolder());
        System.out.println(demo.getUserHolder2());
    }

    public UserHolder getUserHolder() {
        return userHolder;
    }

    public UserHolder getUserHolder2() {
        return userHolder2;
    }
}
