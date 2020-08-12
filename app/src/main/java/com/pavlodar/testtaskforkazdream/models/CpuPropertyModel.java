package com.pavlodar.testtaskforkazdream.models;

public class CpuPropertyModel {
    public static final String PROCESSOR = "Processor";
    public static final String CPU_ARCHITECTURE = "CPU architecture";
    public static final String HARDWARE = "Hardware";

    private String name;
    private String value;

    public CpuPropertyModel(String name, String value) {
        super();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
