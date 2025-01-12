package com.devleo.project.ecommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

    private List<FieldMensage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMensage> getErrrors() {
        return errors;
    }

    public void setErrrors(List<FieldMensage> errrors) {
        this.errors = errrors;
    }

    public void addError(String fielName, String mensage){

        errors.add(new FieldMensage(fielName, mensage));
    }
}
