package com.jjoey.dynamictabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.jjoey.dynamictabs.models.Customize;
import com.jjoey.dynamictabs.utils.CustomizeAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomizeActivity extends AppCompatActivity {

    private static final String TAG = CustomizeActivity.class.getSimpleName();

    private RecyclerView customizeRV;
    private Button letsGoBtn;

    private List<Customize> objectList = new ArrayList<>();
    private CustomizeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        init();

        letsGoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adapter.getNumChecked() > 0){
                    startActivity(new Intent(CustomizeActivity.this, MainActivity.class));
                    finish();
                } else {
                    Snackbar.make(findViewById(android.R.id.content), "Select A Category Before You Proceed", Snackbar.LENGTH_LONG).show();
                }
            }
        });

    }

    private void init() {
        customizeRV = findViewById(R.id.customizeRV);
        letsGoBtn = findViewById(R.id.letsGoBtn);

        setUpRV();

    }

    private void setUpRV() {
        customizeRV.setHasFixedSize(true);
        customizeRV.setLayoutManager(new LinearLayoutManager(this));

//        AdapterHeaderItem headerItem = new AdapterHeaderItem();
//        headerItem.setHeaderTitle("help us customise your screen better. choose your favorite categories to begin:");
//        objectList.add(headerItem);

        Customize cust = new Customize();
        cust.setChecked(false);
        cust.setIcon(R.drawable.naturecard);
        objectList.add(cust);

        Customize customize = new Customize();
        customize.setChecked(false);
        customize.setIcon(R.drawable.spacecard);
        objectList.add(customize);

        Customize customize2 = new Customize();
        customize2.setChecked(false);
        customize2.setIcon(R.drawable.seasonscard);
        objectList.add(customize2);

        Customize customize3 = new Customize();
        customize3.setChecked(false);
        customize3.setIcon(R.drawable.artcard);
        objectList.add(customize3);

        Customize customize4 = new Customize();
        customize4.setChecked(false);
        customize4.setIcon(R.drawable.scificard);
        objectList.add(customize4);

        Customize customize5 = new Customize();
        customize5.setChecked(false);
        customize5.setIcon(R.drawable.misccard);
        objectList.add(customize5);

        adapter = new CustomizeAdapter(this, objectList);
        customizeRV.setAdapter(adapter);

    }

}
