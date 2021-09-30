package com.example.client;

import java.util.Objects;

public class ABCResult {

    private int a;

    private int b;

    private int c;

    private float result;

    public ABCResult(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public ABCResult(int a, int b, int c, float result) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.result = result;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    public void setResult(float result) {
        this.result = result;
    }

    public float getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ABCResult abcResult = (ABCResult) o;
        return Float.compare(abcResult.a, a) == 0 && Float.compare(abcResult.b, b) == 0 && Float.compare(abcResult.c, c) == 0 && Float.compare(abcResult.result, result) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, result);
    }


    @Override
    public String toString() {
        return "ABCResult{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", result=" + result +
                '}';
    }
}
