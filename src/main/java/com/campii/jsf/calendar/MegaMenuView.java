package com.campii.jsf.calendar;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="megamenuview")
public class MegaMenuView {
  
    private String orientation = "horizontal";
 
    public String getOrientation() {
        return orientation;
    }
 
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
}
