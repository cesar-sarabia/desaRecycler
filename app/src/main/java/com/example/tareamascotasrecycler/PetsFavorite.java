package com.example.tareamascotasrecycler;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class PetsFavorite extends AppCompatActivity {

    private static RecyclerView rv_listFavPet;
    private   ArrayList<MascotaDataModel> data;
    private  RecyclerView.Adapter adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets_favorite);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarMain);
        setTitle("Favorite Pet");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        rv_listFavPet =(RecyclerView) findViewById(R.id.rvFavMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        rv_listFavPet.setLayoutManager(llm);
        initiateData();
        initiateAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_fav, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initiateData(){
        data = new ArrayList<MascotaDataModel>();
        for (int i=0; i<MyData.nameArray.length; i++){
            if (MyData.favArray[i]>0){
                data.add(new MascotaDataModel(
                        MyData.nameArray[i],
                        MyData.drawableArray[i],
                        MyData.favArray[i]

                ));
            }

        }
    }

    private  void initiateAdapter(){
        adapter = new MascotaAdapter(data, this);
        rv_listFavPet.setAdapter(adapter);
    }


}
