package com.eem.apps.enelmall.model;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;


public class MockOffers {
    protected static final String TAG = "[MockOffers]";

    public static Map<String, Integer> location = new HashMap<>();

    public static Store[] stores = {
            new Store(1, "LosGamers","Lunes a Viernes","9:00 AM - 5:00 PM", "https://pbs.twimg.com/profile_images/514534796198817793/p4WamN35.jpeg", "https://www.facebook.com/Losgamerspuntocom?_rdr", "www.losgamers.com/", "8295474118", "Somos una comunidad de Gamers, es decir, de personas que han hecho de los videojuegos un estilo de vida. Pero, atentos, aquí no excluimos a nadie: también son bienvenidos los jugadores ocasionales y los padres, quienes muchas veces son quienes compran y por supuesto quieren obtener más por el mismo presupuesto."),
            new Store(2, "06 Store","Lunes a Viernes","9:00 AM - 7:00 PM", "http://uepa.com/r/c26109/p/album/201008231515126.jpg", "https://www.facebook.com/LifeO6", "www.o6store.com/", "8095474075",
                    "Somos una cadena de tiendas orientada a ofrecer productos de alta calidad y tecnología para uso en la vida activa, deportiva y al aire libre, brindando conceptos modernos de retail que hacen posible una experiencia de compra gratificante para nuestros clientes.\n" +
                            " \n" +
                            "En O6 sTORE comercializamos productos de alta calidad que están diferenciados por su innovación y tecnología. Las marcas presentes en nuestro portafolio son líderes en cada una de las líneas de productos que ofertamos."),
            new Store(3, "Energy System","Lunes a Sabados\nDomingos y Feriados","10:00 AM - 9:00 PM\n12:00 PM - 8:00 PM", "http://cdn5.andro4all.com/wp-content/blogs.dir/28/files/2014/03/energy-sistem-smartphones.jpg",
                    "https://www.facebook.com/EnergySistemRd", "www.energysistem.com/", "8295474116", "Con sede en España, somos una empresa internacional presente en los cinco continentes y especia" +
                    "lizada en el desarrollo, diseño y comercialización de productos tecnológicos (smartphones, tablets, altavoces, reproductores de música, etc.), dirigidos a un público joven, urbano e " +
                    "interesado en todas las formas de ocio digital. Personas que integran la tecnología en su vida cotidiana y que buscan productos de calidad, a precios competitivos."),
            new Store(4, "Fiesta City","Lunes a Viernes","9:00 AM - 5:00 PM", "http://gotpicture.com.do/wp-content/gallery/fiesta-city/fG-2685.jpg", "https://www.facebook.com/pages/Fiesta-City/580733725397247?fref=ts", "www.fiestacity.com/", "8295474023", "Fiesta City es un colorido y alegre espacio en el que los clientes podrán encontrar llamativos artículos con los que podrán sorprender a los invitados a sus encuentros, y con los que harán de sus fiestas y festejo un encuentro de inolvidables detalles.\n" +
                    "\n" +
                    "Adeás de encontrar diferentes paquetes especiales para los días de San Valentín, en Fiesta City los clientes pueden encontrar divertidos disfraces, tanto para niños como para adultos, asi como un sin número de eementos perfectos para llenar sus horas locas y ágapes."),

    };

    static Offer[] offers = {
            new Offer(1, "¡MP3 para tu auto! Paga RD$375 en vez de RD$750 MP3 con pantalla digital ",
                    "¡MP3 para tu auto!\n" +
                            "- ¡Compra y/o regala esta oferta!\n" +
                            "- Oferta incluye: \n" +
                            "- MP3 con pantalla digital\n" +
                            "- Porta-memoria USB\n" +
                            "- Portamiento para memoria Micro SD\n" +
                            "- Control remoto \n" +
                            "- Por solo RD$375.\n" +
                            "- Impuestos incluidos.", Type.DESCUENTO, Category.Electronicos, "18/04/15",stores[0] , location, "http://daxueconsulting.com/wp-content/uploads/2012/07/womens-clothes2.jpg"),
            new Offer(1, "Oferta 2", "Detalles 2", Type.CONCURSO, Category.Belleza, "20/05/15", stores[1], location, "http://www.tenpin.org.au/uploads/RTEmagicC_House_Shoes_01.jpg.jpg"),
            new Offer(1, "Oferta 3", "Detalles 3", Type.TIEMPO_LIMITADO, Category.Caballeros, "15/04/15", stores[2], location, "http://machopicture.com/images/autumn-dresses/9301-fashion-clothes-for-women.jpg"),
            new Offer(1, "Oferta 4", "Detalles 4", Type.PAGUE1LLEVE2, Category.Entretenimiento, "30/06/15",  stores[3] , location, "https://s3.amazonaws.com/ODNUploads/5431308c0d073Cheese_Pizza_Pepperoni.jpsg")
    };

    public static Store[] getStores() {
        return stores;
    }

    public static String getOffers(int delay){
        Log.d(TAG, "getOffers()");
        String jsonOffers = "[";
        for (Offer o : offers) {
//            o.getLocation().put("longitude",1);
//            o.getLocation().put("latitude",2);
            jsonOffers+=o+",";
        }
        jsonOffers = jsonOffers.substring(0,jsonOffers.length()-1);
        jsonOffers+="]";
        return jsonOffers;
    }

    public static String getOffers2(int delay){
        Log.d(TAG, "getOffers()");
        try {
            Thread.sleep(delay);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        String jsonOffers = "[";

        Offer[] offers2 = {offers[0],offers[1]};

        for (Offer o : offers2) {
            jsonOffers+=o+",";
        }
        jsonOffers = jsonOffers.substring(0,jsonOffers.length()-1);
        jsonOffers+="]";
        return jsonOffers;
    }


    public static String getOffer(int index){
        Log.d(TAG, "getOffer()");
        return offers[index].toString();
    }
}