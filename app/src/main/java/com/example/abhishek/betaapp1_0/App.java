package com.example.abhishek.betaapp1_0;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v4.view.MenuItemCompat;
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



import java.util.ArrayList;
import java.util.List;

import static com.example.abhishek.betaapp1_0.R.id.appName;

public class App extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private CardView cardView;

    private ArrayList<DataModel> dataModel;

    private RecyclerView.Adapter adapter;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        initControls();

    }

    private void initControls() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        final String[] appName = {"Google","Google Maps","HERE WeGo - City Navigation",
                "Pushbullet","Facebook","Messenger",
                "Instagram","Whatsapp","Snapchat",
                "Tumblr","Drippler - Tech Support & Tips","MX Player",
                "VLC","PicsArt Photo Studio","PhotoSync - Transfer Photos",
                "ibVPN - Fast & Unlimited VPN"};
        final int[] appLogo = {R.mipmap.google,R.mipmap.googlemaps,R.mipmap.herewego,
                R.mipmap.pushbullet,R.mipmap.facebook,R.mipmap.messenger,
                R.mipmap.instagram,R.mipmap.whatsapp,R.mipmap.snapchat,
                R.mipmap.tumblr,R.mipmap.drippler,R.mipmap.mxplayer,
                R.mipmap.vlc,R.mipmap.picsart,R.mipmap.photosync,
                R.mipmap.ibvpn};

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
