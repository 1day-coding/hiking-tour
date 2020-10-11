package com.coding.model;

public enum CurrencyType {
    EUR("EUR");

    private String value;

    CurrencyType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
