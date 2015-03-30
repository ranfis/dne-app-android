package com.eem.apps.enelmall;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.eem.apps.enelmall.model.api.DataApiCall;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OffersActivity extends ActionBarActivity {

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private String mActivityTitle;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    //DEMO LISTVIEW
    ListView mListView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    ArrayAdapter mAdapter2;
    Handler handler = new Handler();

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

        mListView = (ListView) findViewById(R.id.offerslist);
        //mAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
        //        );

        //mListView.setAdapter(mAdapter2);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
            handler.post(refreshing);
            }
        });

        mSwipeRefreshLayout.setColorSchemeColors(R.color.eem_dark_blue,
                R.color.eem_pale_yellow, R.color.eem_dark_orange);

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                boolean enable = false;

                /**
                 * This enables us to force the layout to refresh only when the first item
                 * of the list is visible.
                 **/
                if(mListView != null && mListView.getChildCount() > 0){
                    // check if the first item of the list is visible
                    boolean firstItemVisible = mListView.getFirstVisiblePosition() == 0;
                    // check if the top of the first item is visible
                    boolean topOfFirstItemVisible = mListView.getChildAt(0).getTop() == 0;
                    // enabling or disabling the refresh layout
                    enable = firstItemVisible && topOfFirstItemVisible;
                }
                mSwipeRefreshLayout.setEnabled(enable);
            }
        });
    }

    private final Runnable refreshing = new Runnable() {
        public void run() {
            try {
                if (mSwipeRefreshLayout.isRefreshing()) {
                    handler.postDelayed(this, 1000);
                } else {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };


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
