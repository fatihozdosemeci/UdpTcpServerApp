package com.example.udptcpsenderreceiver;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class LayoutManagement extends AppCompatActivity {

    private LinearLayout linearLayout;
    private LinearLayout triLayout;
    private int triLayoutId = 0;
    private int layoutId = 0;

    LinearLayout.LayoutParams lp3;
    LinearLayout.LayoutParams lp ;

    public LayoutManagement(){
        lp3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,MainActivity.py/10,1);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,1);
        lp3.setMargins(10,10,10,10);
    }


    public void addLayout(int id, Context context) {

        if (id % 3 == 1) {
            triLayoutId++;
            triLayout = new LinearLayout(context); //YENİ LAYOUT SÜTUNU OLUŞTURULUYOR VE ÖZELLİKLERİ BELİRLENİYOR
            triLayout.setOrientation(LinearLayout.HORIZONTAL);
            triLayout.setId(1000+triLayoutId);
            triLayout.setWeightSum(3);
            MainActivity.ll.addView(triLayout, lp);

            for(int k=0;k<3;k++)
            {
                layoutId++;
                linearLayout = new LinearLayout(context); //YENİ LAYOUT OLUŞTURULUYOR VE ÖZELLİKLERİ BELİRLENİYOR
                linearLayout.generateViewId();
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setId(10000+layoutId);
                linearLayout.setPadding(5,5,5,5);
                triLayout.addView(linearLayout,lp3);
            }
        }
        else;
    }
    public void removeLayout(Activity mActivity){
        LinearLayout reLinear2;
        LinearLayout reLinear;


        if (MainActivity.j > 0) {
            reLinear = mActivity.findViewById(MainActivity.j+10000);//EN SON EKLENMİŞ LİNEAR LAYOUT
            reLinear.removeView(mActivity.findViewById(MainActivity.j));   //SON EKLENEN LAYOUTTAN BUTON SİLİNİYOR

            if (MainActivity.j % 3 == 1) {
                reLinear2 = mActivity.findViewById(1000+triLayoutId);    //ÜÇ LAYOUT TUTAN SON LAYOUT SÜTUNU
                for(int k=0;k<3;k++)
                {
                    reLinear2.removeView(mActivity.findViewById(10000+layoutId)); //TEK BUTONU TUTAN LAYOUT SİLİNİYOR
                    layoutId--;
                }
                MainActivity.ll.removeView(reLinear2);                     //SON EKLNEMİŞ LAYOUT SÜTUNU SİLİNİYOR
                triLayoutId--;                               //SON EKLNEMİŞ LAYOUT SÜTUN SAYISI BİR AZALTILIYOR
            }
        }
    }
}

