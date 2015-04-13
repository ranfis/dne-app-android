package com.eem.apps.enelmall.model;


public enum Category {
    Electronicos(1),
    Postres(2),
    Hogar(3),
    Caballeros(4),
    Damas(5),
    Niños(6),
    Zapatos(7),
    Viajes(8),
    Entretenimiento(9),
    Opticas(10),
    Relojerias(11),
    Deportivo(12),
    Heladeria(13),
    Joyeria(14),
    Cosmeticos(15),
    Restaurants(16),
    Belleza(17),
    Servicios(18),
    Supermercado(19),
    Farmacias(20);



    private int id;

    Category(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public static Category getFromId(int id) {
        return values()[id-1];
    }

    public String getNameFromID(int id) {
        String category = null;
        switch(id) {
            case 1:
                category = "Electronicos";
                break;
            case 2:
                category = "Postres";
                break;
            case 3:
                category = "Hogar";
                break;
            case 4:
                category = "Caballeros";
                break;
            case 5:
                category = "Damas";
                break;
            case 6:
                category = "Niños";
                break;
            case 7:
                category = "Zapatos";
                break;
            case 8:
                category = "Viajes";
                break;
            case 9:
                category = "Entretenimiento";
                break;
            case 10:
                category = "Opticas";
                break;
            case 11:
                category = "Relojerias";
                break;
            case 12:
                category = "Deportivo";
                break;
            case 13:
                category = "Heladeria";
                break;
            case 14:
                category = "Joyeria";
                break;
            case 15:
                category = "Cosmeticos";
                break;
            case 16:
                category = "Restaurants";
                break;
            case 17:
                category = "Belleza";
                break;
            case 18:
                category = "Servicios";
                break;
            case 19:
                category = "Supermercado";
                break;
            case 20:
                category = "Farmacias";
                break;
        }
        return category;
    }


}