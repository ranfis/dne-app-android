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

    public int getId(){
        return id;
    }

    public static Category getFromId(int id) {
        return values()[id];
    }

    public String getNameFromID(int id) {
        String category = null;
        switch(id) {
            case 0:
                category = "zapatos";
                break;
            case 1:
                category = "comida";
                break;
            case 2:
                category = "ropa";
                break;
            case 3:
                category = "masculina";
                break;
            case 4:
                category = "ropa_femenina";
                break;
            case 5:
                category = "tecnologia";
                break;
            case 6:
                category = "belleza";
                break;
            case 7:
                category = "salud";
                break;
        }

        return category;
    }


}