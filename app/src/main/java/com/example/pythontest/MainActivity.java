package com.example.pythontest;
/*
参考サイト
https://chaquo.com/chaquopy/doc/current/android.html
https://chaquo.com/chaquopy/doc/current/faq.html
https://stackoverflow.com/questions/64396955/does-chaquopy-support-tensorflow-2-2-or-2-3-1
https://stackoverflow.com/questions/66621214/insert-value-to-function-in-python-file-using-chaquopy-in-android-studio
https://qiita.com/mzmz__02/items/6480a2ba316e4cfbea0f
 */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.chaquo.python.*;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.chaquo.python.*;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textview);

        //Pythonが利用できる状態じゃなければ利用できるようにする
        if (!Python.isStarted()) {
            //thisの部分はJavaのソースファイルが一つの場合はこのままいでけるはずです
            Python.start(new AndroidPlatform(this));
        }
        Python py = Python.getInstance();
        PyObject module = py.getModule("hello");//pythonファイルの名前.pyのやつ
        PyObject obj = module.callAttr("unko");//pythonファイルのdef unko():のunkoの部分
        textView.setText(obj.toString());
    }
}