package com.example.udptcpsenderreceiver;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class DataDialog  {

    private EditText nameInput,sendInput,portInput;
    private AutoCompleteTextView ipInput;
    String shiftValue;
    int k=1,j,shift,register,buttonValue;
    boolean esitlik;
    private Context mcontext;
    private Activity activity;
    UdpButton udpButton;

    public DataDialog(Context context,Activity activity){
        this.mcontext = context;
        this.activity = activity;

    }

    public void openAlertDialog(Context context,int clickButtonId){

        //LayoutInflater inflater = null;
        //View view = R.layout.layout_chdialog;

        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
        final View view = inflater.inflate(R.layout.layout_chdialog,null);

        AlertDialog.Builder builder1 = new AlertDialog.Builder(mcontext);


        nameInput   = view.findViewById(R.id.editText);   //İNPUTLAR TANIMLANIYOR
        sendInput   = view.findViewById(R.id.editText2);
        ipInput     = view.findViewById(R.id.editText3);
        portInput   = view.findViewById(R.id.editText4);
        ipInput.setDropDownHeight(MainActivity.py/4);
        udpButton = activity.findViewById(clickButtonId);


        nameInput.setText(UdpButton.udpName);   //İNPUTLARA ÖNCEKİ DEĞERLER YÜKLENİYOR
        sendInput.setText(UdpButton.udpSend);
        ipInput.setText(UdpButton.udpIp);
        portInput.setText(String.valueOf(UdpButton.udpPort));



        ipInput.setAdapter(MainActivity.adapter);

        for(k=0;k<MainActivity.j+1;k++)
        {  esitlik=false;
            for(j=0;j<MainActivity.predictIp.size();j++)
            {
                if(MainActivity.sp.getString("ip"+k,"").equals(MainActivity.predictIp.get(j)))
                {
                    esitlik = true;
                    break;
                }
            }
            if(esitlik == false)
            {
                if(MainActivity.sp.getString("ip"+k,"").compareTo("") != 0 )
                {
                    MainActivity.predictIp.add(MainActivity.sp.getString("ip"+k, ""));
                }
            }
        }

        for(shift=0;shift < MainActivity.predictIp.size()-1;shift++)
        {
            String currentString = MainActivity.predictIp.get(shift);
            String[] seperated = currentString.split("\\.");
            String currentString2 = MainActivity.predictIp.get(shift + 1);
            String[] seperated2 = currentString2.split("\\.");
            if (Integer.parseInt(seperated[3]) > Integer.parseInt(seperated2[3])) {
                shiftValue = MainActivity.predictIp.get(shift);
                MainActivity.predictIp.set(shift, MainActivity.predictIp.get(shift + 1));
                MainActivity.predictIp.set(shift + 1, shiftValue);
                shift = -1;
            }
        }


        MainActivity.adapter = new  ArrayAdapter<String>(MainActivity.MainContex,android.R.layout.simple_dropdown_item_1line,MainActivity.predictIp);


        builder1.setView(view)         //MESAJ KUTUSU DERLEMESİ BAŞLIYOR
                .setTitle("BİLGİLER")
                .setNegativeButton("iptal", new DialogInterface.OnClickListener() {  //NEGATİF SEÇİM BLOĞU
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("kaydet", new DialogInterface.OnClickListener() {  //POZİTİF SEÇİM BLOĞU
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                        MainActivity.editor.putString("isim"+ UdpButton.clickButtonId, nameInput.getText().toString());  // INPUTLARDAN ALINAN DEĞERLER VERİLER
                        MainActivity.editor.putString("send"+ UdpButton.clickButtonId, sendInput.getText().toString());  // DOSYASININ PARAMETRELERİNE KAYDEDİLİYOR
                        MainActivity.editor.putString("ip"  + UdpButton.clickButtonId, ipInput.getText().toString());
                        MainActivity.editor.putInt("port"+ UdpButton.clickButtonId, Integer.parseInt(portInput.getText().toString()));
                        udpButton.setText(nameInput.getText().toString());

                        Toast.makeText(mcontext,"veriler kaydedildi", LENGTH_SHORT).show();  //KAYDEDİLDİ MESAJI

                        for(register=0;register<MainActivity.predictIp.size();register++)
                        {
                            String reg = String.valueOf(register);
                            MainActivity.editor.putString("predict"+reg,MainActivity.predictIp.get(register));
                        }
                        MainActivity.editor.putInt("predictSize",MainActivity.predictIp.size());
                        MainActivity.editor.commit();

                    }
                });
        //.setNeutralButton("...");

                /*copybutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        buttonValue = UdpButton.id;
                        MainActivity.editor.putInt("buttonValue",buttonValue);
                        MainActivity.editor.commit();
                        Toast.makeText(MainActivity.MainContex,"kopyalandı",LENGTH_SHORT).show();
                        copyValue =1;
                    }
                });
                pasteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonValue = MainActivity.sp.getInt("buttonValue",0);
                        nameInput.setText(MainActivity.sp.getString("isim"+buttonValue,""));
                        sendInput.setText(MainActivity.sp.getString("send1"+buttonValue,""));
                        ipInput.setText(MainActivity.sp.getString("ip"+buttonValue,""));
                        portInput.setText(String.valueOf(MainActivity.sp.getInt("port1"+buttonValue,0)));
                        pasteButton.setVisibility(View.INVISIBLE);
                        copyValue=2;
                    }
                });*/

        builder1.show();
    }
}