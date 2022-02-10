package com.hyperleon.thinking.spring.java.beans.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * @author leon
 * @date 2022-02-10 23:08
 **/
public class Bar implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(String name,PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        pcs.firePropertyChange("name",this.name,name);
        this.name = name;
    }
}
