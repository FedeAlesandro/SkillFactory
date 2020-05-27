package org.example.models;

import org.example.enums.ColorName;
import org.example.interfaces.IColor;

public class Yellow implements IColor {

    private ColorName color;

    public Yellow() {
        this.color = ColorName.yellow;
    }

    @Override
    public String toString() {
        return this.color.toString();
    }
}
