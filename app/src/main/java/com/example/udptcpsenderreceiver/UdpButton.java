package com.example.udptcpsenderreceiver;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class UdpButton extends android.support.v7.widget.AppCompatButton {

    public static String udpName;
    public static String udpSend;
    public static String udpIp;
    public static int udpPort;
    public static int id, clickButtonId,clickButtonId2;

    Activity activity;
    Context context;



    public UdpButton(int ButtonId, final Context context, Activity mActivity) {
        super(context);

        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT,1);
        LinearLayout linearLayout2 ;

        this.activity = mActivity;
        this.context = context;
        this.id = ButtonId;
        this.setId(ButtonId);
        this.setLayoutParams(lp2);
        this.setBackgroundColor(Color.parseColor("#FEFFDE"));
        this.setTextSize(MainActivity.px/90);

        this.setText( MainActivity.sp.getString("isim"+id,""));
        int identify = 10000+id;
        //linearLayout2 = findViewById(getResources().getIdentifier(identify,"id","com.example.son")/*0+MainActivity.sayac*/);          //SON EKLENEN LAYOUT TANIMLANIYOR
        linearLayout2 = (LinearLayout) mActivity.findViewById(identify);
        linearLayout2.addView(this, lp2);       //DİNAMİK BUTON LAYOUTA EKLENİYOR

        this.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                Button button = (Button) v;
                clickButtonId = button.getId();
                udpName = MainActivity.sp.getString("isim"+clickButtonId,"");
                udpSend = MainActivity.sp.getString("send"+clickButtonId,"");
                udpIp   = MainActivity.sp.getString("ip"+  clickButtonId,"");
                udpPort = MainActivity.sp.getInt("port"+   clickButtonId, 0);

                MainActivity.dataDialog.openAlertDialog(context,clickButtonId);

                return true;
            }
        });

        this.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button2 = (Button) v;
                clickButtonId2 = button2.getId();
                //MainActivity.udpSender.UdpSender(context,clickButtonId2);
                if(MainActivity.setButton.isChecked())
                    MainActivity.tcpSender.TcpSender(clickButtonId2);
                else
                    MainActivity.udpSender.UdpSender(context,clickButtonId2);
            }
        });
    }




    /*private void send(Context context) //UDP SEND İŞLEMLERİ
    {
        port = getSharedPreferences("Bveriler", MODE_PRIVATE).getInt("port1"+a,0);
        ip = sp.getString("ip"+a, "");
        data = getSharedPreferences("Bveriler", MODE_PRIVATE).getString("send1"+a,"");

        try
        {
            DatagramSocket s = new DatagramSocket();
            InetAddress local = null;
            local = InetAddress.getByName(ip);
            int msg_length = data.length();
            byte[] message = data.getBytes();
            DatagramPacket p = new DatagramPacket(message, msg_length, local, port);
            s.send(p);
            Toast.makeText(context,"VERİ GÖNDERİLDİ",LENGTH_SHORT).show();
        }
        catch (SocketException e)
        {
            e.printStackTrace();
            Toast.makeText(context,"VERİ GÖNDERİLEMEDİ",LENGTH_SHORT).show();
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
            Toast.makeText(context,"VERİ GÖNDERİLEMEDİ",LENGTH_SHORT).show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            Toast.makeText(context,"VERİ GÖNDERİLEMEDİ",LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(context,"VERİ GÖNDERİLEMEDİ",LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }*/
    /* Değişkenler

     */


        /*;dynamicButton = new Button(MainActivity.this); //YENİ DİNAMİK BUTON OLUŞTURULUYOR VE ÖZELLİKLERİ BELİRLENİYOR
        dynamicButton.setId(sayac);
        dynamicButton.setMaxLines(100+sayac);
        dynamicButton.setLayoutParams(lp2)

        dynamicButton.setOnLongClickListener(new View.OnLongClickListener() {  //DİNAMİK BUTON UZUN TIKLAMAYI DİNLEMEDE
        @Override
        public boolean onLongClick(View v) {
            SetPassDialog.check=true;
            if(SetPassDialog.check == true) {
                btn = (Button) v;
                a = String.valueOf(btn.getMaxLines() % 100);  //BUTON VERİLERİNİN FARKLI İSİMLERDE TUTULABİLMESİ İÇİN ÖNCEDEN BUTONLARA ÖZEL
                dataReg();                                    //AYARLANMIŞ MAX LİNE DEĞERİ ALINIYOR
            }
            else
            {
                Toast.makeText(MainActivity.this,"yapılandırma modunu açınız", LENGTH_SHORT).show();
            }
            return true;
        }
    });

        dynamicButton.setOnClickListener(new View.OnClickListener() {  //DİNAMİK BUTON KISA TIKLAMAYI DİNLEMEDE
        public void onClick(View v) {
            btna =(Button) v;
            a = String.valueOf(btna.getMaxLines()%100);     //BUTON VERİLERİNİN FARKLI İSİMLERDE TUTULABİLMESİ İÇİN ÖNCEDEN BUTONLARA ÖZEL
            UDPSend();                                      //AYARLANMIŞ MAX LİNE DEĞERİ ALINIYOR
        }
    });*/
}
