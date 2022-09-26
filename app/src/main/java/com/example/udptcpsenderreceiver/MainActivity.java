package com.example.udptcpsenderreceiver;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.StrictMode;
import android.os.Bundle;
import android.os.UserHandle;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends BaseActivity  {


    public static Button addButton,deleteButton;
    public static ToggleButton  setButton;
    public static UdpButton udpBtn;
    public static DataDialog dataDialog;
    public static UdpSender udpSender;
    public static TcpSender tcpSender;
    public static LayoutManagement layoutManagement;

    public static String ipAddressString;
    public static int j=0 ,py,px,r;
    private AdView banner;

    public static TextView textIp,textView,incomingText,ipText;
    public static SharedPreferences sp;
    public static SharedPreferences.Editor editor;
    public static LinearLayout ll;

    public static ArrayList<String> predictIp;
    public static ArrayAdapter<String> adapter;
    public static MainActivity MainContex;
    public static ScrollView scrollView;


import android.os.Bundle;
import android.os.StrictMode;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MainContex = MainActivity.this;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
