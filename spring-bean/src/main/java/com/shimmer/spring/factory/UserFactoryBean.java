package com.shimmer.spring.factory;

import com.shimmer.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author aurora
 * @date 2020/6/20 23:08
 */
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
