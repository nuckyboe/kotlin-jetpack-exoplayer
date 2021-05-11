package com.nuckyboe.kotlin_jetpack_exoplayer.IOC;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation.ContentView;
import com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation.ViewClick;
import com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation.ViewInject;
import com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation.ViewLongClick;
import com.nuckyboe.kotlin_jetpack_exoplayer.R;

@ContentView(R.layout.activity_main_ioc)
public class IOCMainActivity extends AppCompatActivity {

    @ViewInject(R.id.tv_ioc_name)
    public TextView iocName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JikeInject.bind(this);
        iocName.setText("成功添加布局并findview");

    }

    @ViewClick({R.id.tv_ioc_name})
    public void click(View view){
        iocName.setText("我被掉包了");
        Toast.makeText(this, "我被掉包了",Toast.LENGTH_LONG).show();
    }

    @ViewLongClick({R.id.tv_ioc_name})
    public boolean longClick(View view){
        iocName.setText("longClick");
        Toast.makeText(this, "longClick",Toast.LENGTH_LONG).show();
        return true;
    }
}
