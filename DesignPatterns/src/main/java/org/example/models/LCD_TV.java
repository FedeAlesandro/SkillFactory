package org.example.models;

import org.example.enums.TvType;
import org.example.interfaces.ITV;

public class LCD_TV implements ITV {

    private TvType tvType;

    public LCD_TV() {
        this.tvType = TvType.lcd;
    }

    @Override
    public String toString() {
        return this.tvType.toString();
    }
}
