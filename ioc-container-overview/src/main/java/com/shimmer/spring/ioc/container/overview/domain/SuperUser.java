package com.shimmer.spring.ioc.container.overview.domain;

import com.shimmer.spring.ioc.container.overview.annotation.Super;

/**
 * @author aurora
 * @date 2020/6/20 15:59
 */
@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
