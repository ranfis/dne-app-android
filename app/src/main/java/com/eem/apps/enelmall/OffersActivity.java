package com.eem.apps.enelmall;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.eem.apps.enelmall.model.Offer;
import com.eem.apps.enelmall.model.OffersAdapter;
import com.eem.apps.enelmall.model.api.OffersBatch;
import com.eem.apps.enelmall.util.BMFactory;

import java.util.ArrayList;


public class OffersActivity extends ActionBarActivity {

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private String mActivityTitle;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;


    private ArrayList<Offer> offers;
    private ListView mOfferList;
    private OffersAdapter oAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("OffersActivity", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);


        mDrawerList = (ListView)findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


//        Intent intent = getIntent();
//        String offersString = intent.getStringExtra(StartActivity.OFFERS);
//        Log.wtf("WTF",offersString);
//        JSONArray offers = (JSONArray)DataApiCall.parseJson(offersString);
//        try{
//            String desc = offers.getJSONObject(0).getString("desc");
//            Toast.makeText(this,desc,Toast.LENGTH_LONG).show();
//        }
//        catch (JSONException er){
//            Log.e("OffersActivity","Bad JSON");
//        }



        // Knowing ubication proceed to name the Mall in the activity
        settingMall();


//        offers = new ArrayList<Offer>();
//        offers.add(new Offer(1, "2x1 en Pizza los Viernes", "Esta es una descripcion", Type.DESCUENTO, Category.BELLEZA, "20/12/2015", new Store(1, "Pizzarelli"), null, (int) R.drawable.pizza_example));
//        offers.add(new Offer(2, "2x1 Pizza los Viernes", "Esta es una descripcion", Type.DESCUENTO, Category.BELLEZA, "20/12/2015", new Store(1, "Pizzarelli"), null, (int) R.drawable.pizza_example));
//        offers.add(new Offer(3, "2x1 Pizza los Viernes", "Esta es una descripcion", Type.DESCUENTO, Category.BELLEZA, "20/12/2015", new Store(1, "Pizzarelli"), null, (int) R.drawable.pizza_example));
        offers = OffersBatch.getAll();
        new BMFactory().execute( offers.toArray( new Offer[offers.size()] ) ); //TODO: hmmmm :/
        oAdapter = new OffersAdapter(OffersActivity.this, offers);
        mOfferList = (ListView) findViewById(R.id.offerslist);
        mOfferList.setAdapter(oAdapter);
        mOfferList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Posicion: " + position, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), DetailsActivity.class);
                i.putExtra("Offer", offers.get(position));
                startActivity(i);
            }
        });


    }




    private void settingMall() {
        TextView mallTitle = (TextView) findViewById(R.id.mall_text);
        mallTitle.setText("Agora Mall");
    }


    private void addDrawerItems() {
        // Para agregar titulos, trabajar con el string.xml y en el array agregar ITEMS
        String[] osArray = getResources().getStringArray(R.array.navDrawer);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(OffersActivity.this, "Posicion: " + position, Toast.LENGTH_SHORT ).show();

                switch(position) {
                    case 0: // Ofertas refresh
                        Intent i = getIntent();
                        finish();
                        i.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                        startActivity(i);
                        break;

                    case 1: // Tiendas
//                        Intent i2 = new Intent(getApplicationContext(), Tiendas.class);
//                        startActivity(i2);
                        break;

                    case 2:  // Mall
//                        Intent i2 = new Intent(getApplicationContext(), Mall.class);
//                        startActivity(i2);
                        break;

                    case 3: // Configuracion
//                        Intent i2 = new Intent(getApplicationContext(), Configuracion.class);
//                        startActivity(i2);
                        break;

                    case 4: // Acerca
//                        Intent i2 = new Intent(getApplicationContext(), Acerca.class);
//                        startActivity(i2);
                        break;

                }


            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,
                R.string.drawer_open,
                R.string.drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar();
                invalidateOptionsMenu();

            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu();
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_offers, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
