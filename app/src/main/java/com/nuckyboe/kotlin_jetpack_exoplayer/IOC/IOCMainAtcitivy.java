package com.nuckyboe.kotlin_jetpack_exoplayer.IOC;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation.ContentView;
import com.nuckyboe.kotlin_jetpack_exoplayer.R;

@ContentView(R.layout.activity_main_ioc)
public class IOCMainAtcitivy extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JikeInject.bind(this);
    }
}
