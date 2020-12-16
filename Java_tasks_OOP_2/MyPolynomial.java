package com.mycompany.secondtask;

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
        if (coeffs.length == 1) {
            polynomial.append(coeffs[0]);
        } else if (coeffs.length == 2) {
            polynomial.append(coeffs[1] + "x + " +coeffs[0]);
        } else {
            for (int i = coeffs.length - 1; i >= 0; i--) {
                if (coeffs[i] >= 0) {
                    if (i == 1) {
                        polynomial.append("+" + coeffs[i] + 'x');
                    } else if (i == 0) {
                        polynomial.append("+" + coeffs[i]);
                    } else if (i == coeffs.length - 1) {
                        polynomial.append(coeffs[i] + "x^" + i);
                    } else {
                        polynomial.append("+" + coeffs[i] + "x^" + i);
                    }
                } else {
                    if (i == 1) {
                        polynomial.append(coeffs[i] + "x");
                    } else if (i == 0) {
                        polynomial.append(coeffs[i]);
                    } else {
                        polynomial.append(coeffs[i] + "x^" + i);
                    }
                }
            }
        }
        return polynomial.toString();
    }

    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

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

    public MyPolynomial multiply(MyPolynomial right) {
        MyPolynomial multiplicationResult = new MyPolynomial(new double[coeffs.length + right.coeffs.length - 1]);
        for (int i = 0; i < coeffs.length; i++)
            for (int j = 0; j < right.coeffs.length; j++) {
                multiplicationResult.coeffs[i + j] += coeffs[i] * right.coeffs[j];
            }
        return multiplicationResult;
    }
}
