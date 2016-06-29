/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nearme.model;

import com.nearme.util.Utility;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sundechi
 */
@XmlRootElement
public class Address {

    public String loc;
    public double dimensions[] = new double[2];

    public Address(String loc) {
        this.loc = loc;
        this.dimensions = Utility.getDimension(loc);
    }

    public Address() {
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public double[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(double[] dimensions) {
        this.dimensions = dimensions;
    }

}
