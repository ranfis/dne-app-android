package com.eem.apps.enelmall.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.eem.apps.enelmall.R;

import java.util.ArrayList;

public class OffersAdapter extends ArrayAdapter<Offer> {

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
        imageOffer.setImageResource((int) offers.get(position).getImage());

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
