package com.example.abhishek.betaapp1_0;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import java.util.ArrayList;

public class App extends Fragment {

    private Toolbar toolbar;
    private RecyclerView rv;
    private CardView cardView;

    private ArrayList<DataModel> dataModel;

    private RecyclerView.Adapter adapter;

    public App() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

       // initControls();

    }

    private void initControls() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recyclerView);

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

        rv.setHasFixedSize(true);


        adapter = new Adapter(dataModel);

        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        return rootView;
    }


}
