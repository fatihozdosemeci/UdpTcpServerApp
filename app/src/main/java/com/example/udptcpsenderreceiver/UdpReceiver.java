package com.example.udptcpsenderreceiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;

public class UdpReceiver extends Thread {


    Socket socket = null;
    MulticastSocket ms = null;
    DatagramPacket dp;


    @Override
    public void run() {

        //textView = activity.findViewById(R.id.textView6);
        byte[] data = new byte[1024];
        try {
            InetAddress groupAddress = InetAddress.getByName("224.0.0.1");
            ms = new MulticastSocket(3400);
            ms.joinGroup(groupAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                dp = new DatagramPacket(data, data.length);
                if (ms != null)
                    ms.receive(dp);
                String sentence = new String( dp.getData());
                MainActivity.textView.setText(sentence);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {

                try {
                    if (socket != null)
                        socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }}

   /* public void UdpReceiver(Activity activity){
        textView = activity.findViewById(R.id.textView6);



        try {
            DatagramSocket serverSocket = new DatagramSocket(3400);
            byte[] receiveData = new byte[8];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String sentence = new String( receivePacket.getData());
                textView.setText(sentence);

            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
