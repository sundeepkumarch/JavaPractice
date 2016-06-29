/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nearme.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sundechi
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User  implements Serializable {

    @XmlElement
    private String mid;
    @XmlElement
    private Address address;

    public User() {
    }

    public User(String mid, String location) {
        this.mid = mid;
        this.address = new Address(location);

    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
