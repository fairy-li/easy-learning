package com.shimmer.spring.bean;

import com.shimmer.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author aurora
 * @date 2020/6/20 22:34
 */
@Import({AnnotationBeanDefinitionDemo.Config.class})
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", "123")
                .addPropertyValue("name", "lkq is cool");

        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        applicationContext.registerBeanDefinition("lkq-user", beanDefinition);
        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), applicationContext);

        applicationContext.refresh();

        // 按照类型依赖查找
        System.out.println("Config 类型的所有 Beans" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有 Beans" + applicationContext.getBeansOfType(User.class));

        applicationContext.close();

    }

    @Component
    public static class Config {

        @Bean(name = {"user", "juhua-user"})
        public User getUser() {
            User user = new User();
            user.setId(99);
            user.setName("哈哈哈哈哈哈哈");
            return user;
        }
    }
}
