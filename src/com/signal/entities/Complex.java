package com.signal.entities;

/**
 * Created by htim on 31.10.14.
 */
public class Complex {
    private Double real;
    private Double image;

    public Complex(Double real, Double image) {
        this.real = real;
        this.image = image;
    }

    public Double getReal() {
        return real;
    }

    public Double getImage() {
        return image;
    }
}
