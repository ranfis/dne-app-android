package com.eem.apps.enelmall;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


import com.eem.apps.enelmall.util.Helpers;

import java.util.ArrayList;
import java.util.List;


public class FilterActivity extends ActionBarActivity {
    protected static final String TAG = "[FilterActivity]";
    protected static final String STORE_SELECTION_CODE = "StoreSelectionFilterActivity";
    protected static final String CATEGORY1_SELECTION_CODE = "Category1SelectionFilterActivity";
    protected static final String CATEGORY2_SELECTION_CODE = "Category2SelectionFilterActivity";
    protected static final String CATEGORY3_SELECTION_CODE = "Category3SelectionFilterActivity";
    protected static final String TYPE_SELECTION_CODE = "TypeSelectionFilterActivity";



    private RadioGroup typeGroup;
    private RadioButton typeButton, typeButton1, typeButton2, typeButton3, typeButton4;
    private Spinner spinner;
    private Spinner cat1;
    private Spinner cat2;
    private Spinner cat3;

    public  String typeSelected = "todas";
    public  String categorySelected1 = "todas";
    public  String categorySelected2 = "todas";
    public  String categorySelected3 = "todas";
    public  String storeSelected = "todas";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        settingSpinnerForStore();
        settingTypeRadio();
        settingSpinnersForCategories();
    }

    private void settingTypeRadio() {
        typeGroup = (RadioGroup) findViewById(R.id.typeRadioGroup);

        typeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //Method that find which radio button is selected
                if(checkedId == R.id.typeButton) {
                } else if(checkedId == R.id.typeButton1) {
                } else if(checkedId == R.id.typeButton2) {
                } else if(checkedId == R.id.typeButton3) {
                } else if(checkedId == R.id.typeButton4) {
                }
            }

        });

        typeButton = (RadioButton) findViewById(R.id.typeButton);
        typeButton1 = (RadioButton) findViewById(R.id.typeButton1);
        typeButton2 = (RadioButton) findViewById(R.id.typeButton2);
        typeButton3 = (RadioButton) findViewById(R.id.typeButton3);
        typeButton4 = (RadioButton) findViewById(R.id.typeButton4);


    }

    private void settingSpinnersForCategories() {
        Log.d(TAG, "settingSpinnersForCategories()");

        cat1 = (Spinner) findViewById(R.id.categorySpinner);
        cat2 = (Spinner) findViewById(R.id.categorySpinner2);
        cat3 = (Spinner) findViewById(R.id.categorySpinner3);

        ArrayAdapter<String> categoryDataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getListCategories());
        categoryDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cat1.setAdapter(categoryDataAdapter);
        cat2.setAdapter(categoryDataAdapter);
        cat3.setAdapter(categoryDataAdapter);

        cat1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categorySelected1 = cat1.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cat2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categorySelected2 = cat2.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cat3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categorySelected3 = cat3.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void settingSpinnerForStore() {
        Log.d(TAG, "settingSpinner()");
        spinner = (Spinner) findViewById(R.id.spinnerStores);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getListStores());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setPrompt("Selección de tiendas");
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                storeSelected = spinner.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private List<String> getListCategories() {
        Log.d(TAG, "getListCategories()");
        //TODO Metodo para conseguir la listas de categorias del API
        List<String> listofCategoriesFromApi = new ArrayList<>();
        listofCategoriesFromApi.add("Belleza");
        listofCategoriesFromApi.add("Salud");
        listofCategoriesFromApi.add("Niños");
        listofCategoriesFromApi.add("Caballeros");
        listofCategoriesFromApi.add("Comida");
        listofCategoriesFromApi.add("Joyeria");

        java.util.Collections.sort(listofCategoriesFromApi);

        List<String> listOfCategories = new ArrayList<>();
        listOfCategories.add(getResources().getString(R.string.standarCategoriesFilter));
        listOfCategories.addAll(listofCategoriesFromApi);

        return listOfCategories;

    }

    private List<String> getListStores() {
        Log.d(TAG,"getListStores()");
        //TODO Method that allow to get all the Stores from the API
        List<String> listOfStoresFromApi = new ArrayList<>();
        listOfStoresFromApi.add("LosGamers.com");
        listOfStoresFromApi.add("EnergySystem");
        listOfStoresFromApi.add("Fiesta Party");
        listOfStoresFromApi.add("O6 Store");
        listOfStoresFromApi.add("Super Lama");

        java.util.Collections.sort(listOfStoresFromApi);

        List<String> listOfStores = new ArrayList<>();
        listOfStores.add(getResources().getString(R.string.standarStoreFilter));
        listOfStores.addAll(listOfStoresFromApi);



        return listOfStores;
    }

    public void buttonReset(View view) {
        spinner.setSelection(0);
        cat1.setSelection(0);
        cat2.setSelection(0);
        cat3.setSelection(0);
        typeGroup.clearCheck();
        typeButton.setChecked(true);
    }

    public void buttonReady(View view) {
        Log.d(TAG, "ButtonReady");
        Boolean result = false;

        /**
         * A partir de aqui categorias de ofertas
         */
        if (categorySelected1.toLowerCase().equalsIgnoreCase("todas")
                && categorySelected2.toLowerCase().equalsIgnoreCase("todas")
                && categorySelected3.toLowerCase().equalsIgnoreCase("todas")) {
            result = true;
        } else if (((categorySelected1.toLowerCase().equalsIgnoreCase(categorySelected2) && categorySelected1.toLowerCase().equalsIgnoreCase(categorySelected3))
                || (categorySelected2.toLowerCase().equalsIgnoreCase(categorySelected1) && categorySelected2.toLowerCase().equalsIgnoreCase(categorySelected3))
                || (categorySelected3.toLowerCase().equalsIgnoreCase(categorySelected1) && categorySelected1.toLowerCase().equalsIgnoreCase(categorySelected2)))
                ) {
            result = Helpers.createDialogError(this, "Error en categorías", "No se puede seleccionar la misma categoria más de una vez", "Esta bien");
        } else if ((categorySelected1.toLowerCase().equalsIgnoreCase(categorySelected2) && !(categorySelected1.toLowerCase().equalsIgnoreCase("todas") || categorySelected2.toLowerCase().equalsIgnoreCase("todas")))) {
            result = Helpers.createDialogError(this, "Error en categorías", "No se puede seleccionar la misma categoria más de una vez", "Esta bien");
        } else if ((categorySelected1.toLowerCase().equalsIgnoreCase(categorySelected3) && !(categorySelected1.toLowerCase().equalsIgnoreCase("todas") || categorySelected3.toLowerCase().equalsIgnoreCase("todas")))) {
            result = Helpers.createDialogError(this, "Error en categorías", "No se puede seleccionar la misma categoria más de una vez", "Esta bien");
        } else if (( categorySelected2.toLowerCase().equalsIgnoreCase(categorySelected3) && !(categorySelected2.toLowerCase().equalsIgnoreCase("todas") || categorySelected3.toLowerCase().equalsIgnoreCase("todas")) )) {
            result = Helpers.createDialogError(this, "Error en categorías", "No se puede seleccionar la misma categoria más de una vez", "Esta bien");
        } else {
            result = true;
        }

        /**
         * A partir de aqui para tipo de ofertas
         * TypeSelected es un String con el nombre del tipo, si se necesita int habria que adaptarlo pero el metodo para conseguir el id solamente
         * seria .getID()
         */
        int selectedId = typeGroup.getCheckedRadioButtonId();
        if (selectedId == typeButton.getId()) {
            typeSelected = typeButton.getText().toString();
        } else if (selectedId == typeButton1.getId()) {
            typeSelected = typeButton.getText().toString();
        } else if (selectedId == typeButton2.getId()) {
            typeSelected = typeButton.getText().toString();
        } else if (selectedId == typeButton3.getId()) {
            typeSelected = typeButton.getText().toString();
        } else if (selectedId == typeButton4.getId()) {
            typeSelected = typeButton.getText().toString();
        }


        if (result==true) {
            Log.d(TAG, "ActionFilter_"+result.toString());
            Intent rIntent = new Intent();
            rIntent.putExtra(STORE_SELECTION_CODE, storeSelected);
            rIntent.putExtra(CATEGORY1_SELECTION_CODE, categorySelected1);
            rIntent.putExtra(CATEGORY2_SELECTION_CODE, categorySelected2);
            rIntent.putExtra(CATEGORY3_SELECTION_CODE, categorySelected3);
            rIntent.putExtra(TYPE_SELECTION_CODE, typeSelected);
            setResult(RESULT_OK, rIntent);
            finish();
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_filter, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
