package org.example.models;

import org.example.interfaces.ITriangle;
import org.example.interfaces.ITriangleFactoryMethod;

public class TriangleCreator implements ITriangleFactoryMethod {

    @Override
    public ITriangle createTringle(Double side1, Double side2, Double side3) {
        if(side1.equals(side2) && side1.equals(side3))
            return new EquilateralTriangle(side1, side2, side3);
        else
            if((side1.equals(side2) && !side1.equals(side3)) || (side2.equals(side3) && !side2.equals(side1)) || (side3.equals(side1) && !side3.equals(side2)))
                return new IsoscelesTriangle(side1, side2, side3);
            else
                return new ScaleneTriangle(side1, side2, side3);
    }
}
