package com.nuckyboe.kotlin_jetpack_exoplayer.IOC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.nuckyboe.inject_annotation.BindView;
import com.nuckyboe.kotlin_jetpack_exoplayer.R;

public class BindViewActivity extends AppCompatActivity {

    @BindView(R.id.tv_bind_view_name)
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_view);
    }
}





