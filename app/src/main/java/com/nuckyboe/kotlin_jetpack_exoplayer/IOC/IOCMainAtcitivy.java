package com.nuckyboe.kotlin_jetpack_exoplayer.IOC;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation.ContentView;
import com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation.ViewInject;
import com.nuckyboe.kotlin_jetpack_exoplayer.R;

@ContentView(R.layout.activity_main_ioc)
public class IOCMainAtcitivy extends AppCompatActivity {

    @ViewInject(R.id.tv_ioc_name)
    public TextView iocName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JikeInject.bind(this);
        iocName.setText("fjsogjodfjgoisdfjgodijf");
    }
}
