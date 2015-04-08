package com.eem.apps.enelmall.model;


public enum Category {
    ZAPATOS(0),
    COMIDA(1),
    ROPA(2),
    MASCULINA(3),
    ROPA_FEMENINA(4),
    TECNOLOGIA(5),
    BELLEZA(6),
    SALUD(7);

    private int id;

    Category(int id){
        this.id = id;
    }

    public static Category getFromId(int id) {
        return values()[id];
    }
}