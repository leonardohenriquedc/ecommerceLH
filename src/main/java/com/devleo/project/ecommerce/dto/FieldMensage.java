package com.devleo.project.ecommerce.dto;

import java.util.logging.Logger;

public class FieldMensage {

    private String fieldName;

    private String mensage;

    public FieldMensage(String fieldName, String mensage) {
        this.fieldName = fieldName;
        this.mensage = mensage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }
}
