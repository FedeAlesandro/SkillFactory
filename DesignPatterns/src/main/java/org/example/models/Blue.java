package org.example.models;

import org.example.enums.ColorName;
import org.example.interfaces.IColor;

public class Blue implements IColor {

    private ColorName color;

    public Blue() {
        this.color = ColorName.blue;
    }

    public ColorName getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.color.toString();
    }
}
