package org.example.models;

import org.example.enums.TvType;
import org.example.interfaces.ITV;

public class PlasmaTV implements ITV {

    private TvType tvType;

    public PlasmaTV() {
        this.tvType = TvType.plasma;
    }

    @Override
    public String toString() {
        return this.tvType.toString();
    }
}
