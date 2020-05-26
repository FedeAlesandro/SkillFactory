package org.example.models;

import org.example.enums.TvType;
import org.example.interfaces.IColor;
import org.example.interfaces.IColorTVFactory;
import org.example.interfaces.ITV;

public class YellowPlasmaFactory implements IColorTVFactory {

    @Override
    public ITV createTV() {
        return new PlasmaTV();
    }

    @Override
    public IColor createColor() {
        return new Yellow();
    }
}
