package com.example.customview.audio.test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customview.R;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private List<String> datas = new ArrayList<>();
    private MyAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_test);
        initVertical();
    }

    public void initVertical(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_vertical);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        for(int i = 0; i < 50; i ++) {
            datas.add(i + "");
        }

        adapter = new MyAdapter(datas);
        recyclerView.setAdapter(adapter);
    }
}
