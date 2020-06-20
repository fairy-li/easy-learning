package com.shimmer.spring.factory;

import com.shimmer.spring.ioc.container.overview.domain.User;

/**
 * @author aurora
 * @date 2020/6/20 23:06
 */
public interface UserFactory {

    default User createUser(){
        return User.createUser();
    }
}
