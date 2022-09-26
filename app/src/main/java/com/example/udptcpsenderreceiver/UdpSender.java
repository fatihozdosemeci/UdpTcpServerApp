package com.example.udptcpsenderreceiver;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import static android.widget.Toast.LENGTH_SHORT;

public class UdpSender extends MainActivity {

    int port;
    String ip,send;

    public void UdpSender (Context context, int clickButtonId) {

        port = MainActivity.sp.getInt("port" + clickButtonId, 0);
        ip   = MainActivity.sp.getString("ip" + clickButtonId, "");
        send = MainActivity.sp.getString("send" + clickButtonId, "");

        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            InetAddress local = null;
            local = InetAddress.getByName(ip);
            int msg_length = send.length();
            byte[] message = send.getBytes();
            DatagramPacket p = new DatagramPacket(message, msg_length, local, port);
            datagramSocket.send(p);
            Toast.makeText(context, "VERİ GÖNDERİLDİ", LENGTH_SHORT).show();
        }
        catch (SocketException e) {
            e.printStackTrace();
            Toast.makeText(context, "VERİ GÖNDERİLEMEDİ", LENGTH_SHORT).show();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            Toast.makeText(context, "VERİ GÖNDERİLEMEDİ", LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "VERİ GÖNDERİLEMEDİ", LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "VERİ GÖNDERİLEMEDİ", LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
