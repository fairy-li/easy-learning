package com.shimmer.spring.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author aurora
 * @date 2020/6/20 23:09
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {


    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
