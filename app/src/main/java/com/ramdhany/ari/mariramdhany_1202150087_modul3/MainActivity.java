package com.ramdhany.ari.mariramdhany_1202150087_modul3;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Menu> mMineralData;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the RecyclerView
        mRecyclerView = findViewById(R.id.recyclerView);

        //Menyeting Layout
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Initialize the ArrayLIst that will contain the data
        mMineralData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        adapter = new ListAdapter(this, mMineralData);
        mRecyclerView.setAdapter(adapter);

        //kondisi ketika orientasi menjadi landscape
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            //maka akan menampilkan 2 grid
            mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
            //jika orientasi menjadi portrait
        }else {
            //maka akan menampilkan satu grid saja
            mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
        }

        //Mendapatkan Data
        initializeData();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation== Configuration.ORIENTATION_LANDSCAPE){
            mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        }else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
        }
    }

    /**
     * Method for initializing the sports data from resources.
     */
    private void initializeData() {
        //Get the resources from the XML file
        String[] minerallist = getResources().getStringArray(R.array.nama_mineral);
        String[] mineralinfo = getResources().getStringArray(R.array.info_mineral);
        TypedArray gambarAir = getResources().obtainTypedArray(R.array.gambar_air);

        //Clear the existing data (to avoid duplication)
        mMineralData.clear();

        //Create the ArrayList of Sports objects with the titles and information about each sport
        for(int i=0;i<minerallist.length;i++){
            mMineralData.add(new Menu(minerallist[i], mineralinfo[i],gambarAir.getResourceId(i,0)));
        }

        //Recycle the typed array
        gambarAir.recycle();

        //Notify the adapter of the changeinitializeData
        adapter.notifyDataSetChanged();
    }

}
