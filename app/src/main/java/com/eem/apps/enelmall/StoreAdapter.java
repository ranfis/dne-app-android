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
import com.eem.apps.enelmall.model.Store;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifDrawable;

public class StoreAdapter extends ArrayAdapter<Store> {
    protected static final String TAG = "[StoreAdapter]";

    private Activity context;
    private ArrayList<Store> store;

    public StoreAdapter(Activity context, ArrayList<Store> store) {
        super(context, R.layout.store_list_items, store);
        this.context = context;
        this.store = store;
    }

    @Override
    public void notifyDataSetChanged() // Create this function in your adapter class
    {
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.store_list_items, null, true);
        ImageView imageStore = (ImageView) item.findViewById(R.id.store_image);


        GifDrawable gifFromResource = null;
        try {
            gifFromResource = new GifDrawable( OffersActivity.self.getResources(), R.drawable.ring );
        }
        catch (Exception ex){
            Log.d(TAG, "getView()/Error loading spinner");
        }

        Picasso.with(context)
                .load((String) store.get(position).getImage())
                .placeholder(gifFromResource)
                .error(R.drawable.no_image)
                .into(imageStore);

        //imageStore.setImageResource(R.drawable.store_example);

        TextView storeTitle = (TextView) item.findViewById(R.id.store_title);
        storeTitle.setText(store.get(position).getName());



        return item;
    }
}
