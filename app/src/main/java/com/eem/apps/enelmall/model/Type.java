package com.eem.apps.enelmall.model;

import android.os.Parcel;
import android.os.Parcelable;

public enum Type {
    PAGUE1LLEVE2(1),
    TIEMPO_LIMITADO(2),
    DESCUENTO(3),
    CONCURSO(4);

    private int id;

    Type(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public static Type getFromId(int id) {
        return values()[id];
    }


}