package com.pavlodar.testtaskforkazdream.models;

public class PhonePropertyModel {
    String propertyName;
    String propertyDescription;

    public PhonePropertyModel(String propertyName, String propertyDescription) {
        this.propertyName = propertyName;
        this.propertyDescription = propertyDescription;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyDescription() {
        return propertyDescription;
    }

    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
    }
}
