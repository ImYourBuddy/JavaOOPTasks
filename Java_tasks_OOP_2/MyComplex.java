package com.mycompany.secondtask;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue (double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        if (imag < 0) {
            return "(" + real + imag + "i)";
        }
        else {
            return "(" + real + '+' + imag + "i)";
        }
    }

    public boolean isReal() {
        return Math.abs(real) < 0.000001;
    }

    public boolean isImaginary() {
        return Math.abs(imag) < 0.000001;
    }

    public boolean equals(double real, double imag) {
        return (Math.abs(this.real - real) < 0.000001) && (Math.abs(this.imag - imag) < 0.000001);
    }

    public boolean equals(MyComplex another) {
        return equals(another.real, another.imag);
    }

    /**
     * Calculate the magnitude of a complex number
     * @return The magnitude of a complex number
     */
    public double magnitude() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
    }

    /**
     * Calculate the argument of a complex number
     * @return The argument of a complex number
     */
    public double argument() {
        return Math.atan2(imag, real);
    }

    /**
     * Addition of two complex numbers. The result is stored in current object.
     * @param right second complex number that adding to this
     * @return current object (this)
     */
    public MyComplex add(MyComplex right) {
        real += right.real;
        imag += right.imag;
        return this;
    }

    /**
     * Addition of two complex numbers. The result is stored in new object.
     * @param right second complex number that adding to this
     * @return new object that is the result of addition
     */
    public MyComplex addNew(MyComplex right) {
        return new MyComplex(real + right.real, imag + right.imag);
    }

    /**
     * Subtraction of two complex numbers. The result is stored in current object.
     * @param right second complex number that subtracting to this
     * @return current object (this)
     */
    public MyComplex subtract(MyComplex right) {
        real -= right.real;
        imag -= right.imag;
        return this;
    }

    /**
     * Subtraction of two complex numbers. The result is stored in new object.
     * @param right second complex number that subtracting to this
     * @return new object that is the result of subtraction
     */
    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(real - right.real, imag - right.imag);
    }

    /**
     * Multiplication of 2 complex numbers. The result is stored in current object.
     * @param right second complex number that multiplies to this
     * @return  current object
     */
    public MyComplex multiply(MyComplex right) {
        double realPart = real * right.real - imag * right.imag;
        double imagPart = real * right.imag + imag * right.real;
        real = realPart;
        imag = imagPart;
        return this;
    }

    /**
     * Division of 2 complex numbers. The result is stored in current object.
     * @param right second complex number that is divisible to this
     * @return current object
     */
    public MyComplex divide(MyComplex right) {
        double realPart = (real * right.real + imag * right.imag) / (Math.pow(right.real, 2) + Math.pow(right.imag, 2));
        double imagPart = (imag * right.real - real * right.imag) / (Math.pow(right.real, 2) + Math.pow(right.imag, 2));
        real = realPart;
        imag = imagPart;
        return this;
    }

    /**
     * Finding the conjugate of a complex number
     * @return The conjugate of the current number (this)
     */
    public MyComplex conjugate() {
        return new MyComplex(real, -imag);
    }
}
