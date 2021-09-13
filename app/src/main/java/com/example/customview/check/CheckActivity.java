package com.example.customview.check;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class CheckActivity extends AppCompatActivity {

    private CheckLayout clCheck;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        clCheck = findViewById(R.id.cl_check);
        clCheck.setmCallBack(new CheckLayout.CallBack() {
            @Override
            public void onSelect(int id) {
                Toast.makeText(CheckActivity.this, "id: " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
