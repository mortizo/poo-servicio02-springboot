/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ups.books.backend.controller.response;

import java.util.List;

/**
 *
 * @author UPS
 */
public class ResponseRest<T> {
    
    private List<T> data;
    private List<ErrorRest> errors;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<ErrorRest> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorRest> errors) {
        this.errors = errors;
    }
    
    
    
}
