package com.example.udptcpsenderreceiver;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpSender  {
    Socket s ;
    DataOutputStream dos;
    PrintWriter pw;
    int clickButtonId;

    public void TcpSender(int clickButtonId){
        int port = MainActivity.sp.getInt("port" + clickButtonId, 0);
        String ip = MainActivity.sp.getString("ip" + clickButtonId, "");
        String send = MainActivity.sp.getString("send" + clickButtonId, "");

        //InetAddress local = null;


        try {
            //local = InetAddress.getByName(ip);
            s = new Socket(ip, port);
            pw = new PrintWriter(s.getOutputStream());
            pw.write(send);
            pw.flush();
            pw.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*@Override
    protected Void doInBackground(Integer... voids) {
        clickButtonId = voids[0];

        int port = MainActivity.sp.getInt("port" + clickButtonId, 0);
        String ip = MainActivity.sp.getString("ip" + clickButtonId, "");
        String send = MainActivity.sp.getString("send" + clickButtonId, "");
        InetAddress local = null;


        try {
            local = InetAddress.getByName(ip);
            s = new Socket("192.168.1.102", port);
            pw = new PrintWriter(s.getOutputStream());
            pw.write(send);
            pw.flush();
            pw.close();
             s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
