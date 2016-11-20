package com.example.abhishek.betaapp1_0;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import static com.example.abhishek.betaapp1_0.R.id.appName;

public class App extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private CardView cardView;
    MaterialSearchView searchView;

    private ArrayList<DataModel> dataModel;

    private RecyclerView.Adapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        initControls();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Beta Apps");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        searchView = (MaterialSearchView)findViewById(R.id.search_view);


    }

    private void initControls() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

      //  if(toolbar != null) {
        //    setSupportActionBar(toolbar);
          //  getSupportActionBar().setTitle("Beta Apps");
        //}

        final String[] appName = {"Google","Google Maps","Facebook","Instagram","Whatsapp","MX Player"};
        final int[] appLogo = {R.drawable.google,R.drawable.googlemaps,R.drawable.facebook,R.drawable.instagram,R.drawable.whatsapp,R.drawable.mxplayer};

        dataModel = new ArrayList<>();

        for(int i = 0;i < appName.length;i++) {
            DataModel data = new DataModel();

            data.setAppLogo(appLogo[i]);
            data.setAppName(appName[i]);
            dataModel.add(data);
        }

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adapter(dataModel);

        recyclerView.setAdapter(adapter);
    }


}
