package com.mycompany.secondtask;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder polynomial = new StringBuilder();
        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (i == 1) {
                polynomial.append(coeffs[i] < 0 ? coeffs[i] + "x" : "+" + coeffs[i] + 'x');
            } else if (i == 0) {
                polynomial.append(coeffs[i] < 0 ? coeffs[i] : "+" + coeffs[i]);
            } else {
                polynomial.append(coeffs[i] < 0 ? coeffs[i] + "x^" + i : "+" + coeffs[i] + "x^" + i);
            }
        }
        if (polynomial.indexOf("+") == 0) {
           return polynomial.substring(1);
        } else {
            return polynomial.toString();
        }
    }

    /**
     * Substitution of X value in polynomial.
     *
     * @param x value that is substituted
     * @return substitution result
     */
    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Addition of two polynomials.
     *
     * @param right polynomial which is added to the current.
     * @return The new polynomial that is the result of addition.
     */
    public MyPolynomial add(MyPolynomial right) {
        MyPolynomial additionResult;
        if (coeffs.length < right.coeffs.length) {
            additionResult = new MyPolynomial(new double[right.coeffs.length]);
            for (int i = 0; i < coeffs.length; i++) {
                additionResult.coeffs[i] = coeffs[i] + right.coeffs[i];
            }
            for (int i = coeffs.length; i < right.coeffs.length; i++) {
                additionResult.coeffs[i] = right.coeffs[i];
            }
        } else {
            additionResult = new MyPolynomial(new double[coeffs.length]);
            for (int i = 0; i < right.coeffs.length; i++) {
                additionResult.coeffs[i] = coeffs[i] + right.coeffs[i];
            }
            for (int i = right.coeffs.length; i < coeffs.length; i++) {
                additionResult.coeffs[i] = coeffs[i];
            }
        }
        return additionResult;
    }

    /**
     * Multiplication of two polynomials
     *
     * @param right polynomial by which the current polynomial is multiplied.
     * @return The new polynomial that is the result of multiplication.
     */
    public MyPolynomial multiply(MyPolynomial right) {
        MyPolynomial multiplicationResult = new MyPolynomial(new double[coeffs.length + right.coeffs.length - 1]);
        for (int i = 0; i < coeffs.length; i++)
            for (int j = 0; j < right.coeffs.length; j++) {
                multiplicationResult.coeffs[i + j] += coeffs[i] * right.coeffs[j];
            }
        return multiplicationResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coeffs);
    }
}
