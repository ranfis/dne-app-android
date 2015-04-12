package com.eem.apps.enelmall;

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


import java.util.ArrayList;
import java.util.List;


public class FilterActivity extends ActionBarActivity {
    protected static final String TAG = "[FilterActivity]";

    private RadioGroup typeGroup;
    private RadioButton typeButton, typeButton1, typeButton2, typeButton3, typeButton4;

    public static String typeSelected = "todos";
    public static String categorySelected1 = "todos";
    public static String categorySelected2 = "todos";
    public static String categorySelected3 = "todos";
    public static String storeSelected = "todos";


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
                // find which radio button is selected
                if(checkedId == R.id.typeButton) {
                    Toast.makeText(getApplicationContext(), "choice: 1",
                            Toast.LENGTH_SHORT).show();
                } else if(checkedId == R.id.typeButton1) {
                    Toast.makeText(getApplicationContext(), "choice: 2",
                            Toast.LENGTH_SHORT).show();
                } else if(checkedId == R.id.typeButton2) {
                    Toast.makeText(getApplicationContext(), "choice: 3",
                            Toast.LENGTH_SHORT).show();
                } else if(checkedId == R.id.typeButton3) {
                    Toast.makeText(getApplicationContext(), "choice: 4",
                            Toast.LENGTH_SHORT).show();
                } else if(checkedId == R.id.typeButton4) {
                    Toast.makeText(getApplicationContext(), "choice: 5",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });

        typeButton = (RadioButton) findViewById(R.id.typeButton);
        typeButton1 = (RadioButton) findViewById(R.id.typeButton1);
        typeButton2 = (RadioButton) findViewById(R.id.typeButton2);
        typeButton3 = (RadioButton) findViewById(R.id.typeButton3);
        typeButton4 = (RadioButton) findViewById(R.id.typeButton4);

        //TODO GETTING THE SELECTED WHEN THE FILTER BUTTON IS PRESSED
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
    }

    private void settingSpinnersForCategories() {
        Log.d(TAG, "settingSpinnersForCategories()");
        final Spinner cat1 = (Spinner) findViewById(R.id.categorySpinner);
        final Spinner cat2 = (Spinner) findViewById(R.id.categorySpinner2);
        final Spinner cat3 = (Spinner) findViewById(R.id.categorySpinner3);

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
                Toast.makeText(getApplicationContext(), categorySelected1,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cat2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categorySelected2 = cat2.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), categorySelected2,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cat3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categorySelected3 = cat3.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), categorySelected3,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void settingSpinnerForStore() {
        Log.d(TAG, "settingSpinner()");
        final Spinner spinner = (Spinner) findViewById(R.id.spinnerStores);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getListStores());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setPrompt("Selección de tiendas");
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                storeSelected = spinner.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), storeSelected,
                        Toast.LENGTH_LONG).show();
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
