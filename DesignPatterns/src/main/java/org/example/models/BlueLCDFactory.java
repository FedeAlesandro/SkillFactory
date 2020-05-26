package org.example.models;

import org.example.enums.TvType;
import org.example.interfaces.IColor;
import org.example.interfaces.IColorTVFactory;
import org.example.interfaces.ITV;

public class BlueLCDFactory implements IColorTVFactory {

    @Override
    public ITV createTV() {
        return new LCD_TV();
    }

    @Override
    public IColor createColor() {
        return new Blue();
    }
}
