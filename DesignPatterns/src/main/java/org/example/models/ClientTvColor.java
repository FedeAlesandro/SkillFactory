package org.example.models;

import org.example.interfaces.IColor;
import org.example.interfaces.IColorTVFactory;
import org.example.interfaces.ITV;

public class ClientTvColor {

    private IColorTVFactory factory;
    private IColor color;
    private ITV tv;

    public ClientTvColor(IColorTVFactory factory) {
        this.factory = factory;
    }

    public ITV createTv(){
        tv = factory.createTV();
        return tv;
    }

    public IColor createColor(){
        color = factory.createColor();
        return color;
    }

    @Override
    public String toString() {
        return "ClientTvColor{" +
                "Color=" + color +
                ", tv=" + tv +
                '}';
    }
}
