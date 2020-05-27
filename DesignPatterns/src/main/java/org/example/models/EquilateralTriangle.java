package org.example.models;

import org.example.interfaces.ITriangle;

public class EquilateralTriangle implements ITriangle {

    private Double side1;
    private Double side2;
    private Double side3;

    public EquilateralTriangle(Double side1, Double side2, Double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public String toString() {
        return "EquilateralTriangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }
}
