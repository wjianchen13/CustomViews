package com.example.customview.inner_stroke;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.customview.check.CheckLayout;

/**
 *
 */
public class InnerStokeActivity extends AppCompatActivity {

    private CheckLayout clCheck;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_stroke);
        clCheck = findViewById(R.id.cl_check);
        clCheck.setmCallBack(new CheckLayout.CallBack() {
            @Override
            public void onSelect(int id) {
                Toast.makeText(InnerStokeActivity.this, "id: " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
