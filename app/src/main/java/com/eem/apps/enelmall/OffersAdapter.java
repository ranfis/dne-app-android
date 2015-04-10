package com.eem.apps.enelmall;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.eem.apps.enelmall.model.Offer;
import com.squareup.picasso.Picasso;
import pl.droidsonroids.gif.GifDrawable;

import java.util.ArrayList;

public class OffersAdapter extends ArrayAdapter<Offer> {
    protected static final String TAG = "[StartActivity]";

    private Activity context;
    private ArrayList<Offer> offers;

    public OffersAdapter(Activity context, ArrayList<Offer> offers) {
        super(context, R.layout.offers_list_items, offers);
        this.context = context;
        this.offers = offers;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.offers_list_items, null, true);
        ImageView imageOffer = (ImageView) item.findViewById(R.id.offer_image);
        GifDrawable gifFromResource = null;
        try {
            gifFromResource = new GifDrawable( OffersActivity.self.getResources(), R.drawable.ring );
        }
        catch (Exception ex){
            Log.d(TAG, "getView()/Error loading spinner");
        }

        Picasso.with(context)
                .load( (String) offers.get(position).getImage() )
                .placeholder(gifFromResource)
                .error(R.drawable.no_image)
                .into(imageOffer);

        TextView titleOffer = (TextView) item.findViewById(R.id.offer_title);
        titleOffer.setText(offers.get(position).getTitle());

        TextView storeOffer = (TextView) item.findViewById(R.id.offer_store);
        storeOffer.setText(offers.get(position).getStore().getName());

        ImageView typeOffer = (ImageView) item.findViewById(R.id.offer_type);
//        typeOffer.setImageResource(R.drawable.abc_cab_background_internal_bg);
//        switch (offers.get(position).getType().getId()) {
//            case 0:
//                typeOffer.setImageResource(R.drawable.limited_time);
//                break;
//
//            case 1:
//                typeOffer.setImageResource(R.drawable.limited_time);
//                break;
//
//            case 2:
//                typeOffer.setImageResource(R.drawable.limited_time);
//                break;
//        }

        return item;
    }
}
