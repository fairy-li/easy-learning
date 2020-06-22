package com.shimmer.spring.dependency.injection;

import com.shimmer.spring.dependency.injection.annotation.UserGroup;
import com.shimmer.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

/**
 * @author aurora
 * @date 2020/6/21 16:22
 */
@Configuration
public class QualifierAnnotationDependencyInjectionDemo {

    @Autowired
    public User user;

    @Autowired
    @Qualifier(value = "user")
    public User user2;

    @Autowired
    private Collection<User> allUser;

    @Autowired
    @Qualifier
    private Collection<User> qualifierUsers;

    @Autowired
    @UserGroup
    private Collection<User> groupUser;

//    @Bean(name = "user")
//    private User creteUser7() {
//        User user = new User();
//        user.setId(7);
//        user.setName("xiamage");
//        return user;
//    }
//
//    @Bean
//    @Primary
//    private SuperUser creteUser8() {
//        SuperUser user = new SuperUser();
//        user.setId(8);
//        user.setAddress("杭州");
//        user.setName("taohua duoduo kai");
//        return user;
//    }

    @Bean
    @Qualifier
    public static User creteUser() {
        User user = new User();
        user.setId(3);
        user.setName("zhangsan");
        return user;
    }

    @Bean
    @Qualifier
    public static User creteUser2() {
        User user = new User();
        user.setId(4);
        user.setName("lisi");
        return user;
    }

    @Bean
    @UserGroup
    public static User creteUser3() {
        User user = new User();
        user.setId(5);
        user.setName("wangqi");
        return user;
    }

    @Bean
    @UserGroup
    public static User creteUser4() {
        User user = new User();
        user.setId(6);
        user.setName("zhaoba");
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        beanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup-context.xml");

        applicationContext.refresh();

        QualifierAnnotationDependencyInjectionDemo demo = applicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);
        System.out.println("demo.user:" + demo.user);
        System.out.println("demo.user2:" + demo.user2);
        System.out.println("demo.allUser:" + demo.allUser);
        System.out.println("demo.qualifierUsers:" + demo.qualifierUsers);
        System.out.println("demo.groupUser:" + demo.groupUser);

        applicationContext.close();
    }
}
