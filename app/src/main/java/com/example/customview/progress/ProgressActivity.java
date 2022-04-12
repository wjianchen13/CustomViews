package com.example.customview.progress;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class ProgressActivity extends AppCompatActivity {

    private CircleCornerProgressBar progress;
    private Button btnAdd;
    private Button btnDec;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        progress = findViewById(R.id.progressbar);
        btnAdd = findViewById(R.id.btn_add);
        btnDec = findViewById(R.id.btn_dec);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(progress != null)
                    progress.setmProgress(++i);
            }
        });
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(progress != null)
                    progress.setmProgress(--i);
            }
        });
    }
}
