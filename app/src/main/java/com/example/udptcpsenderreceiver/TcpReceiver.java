package com.example.udptcpsenderreceiver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpReceiver extends Thread {

    Socket socket;
    ServerSocket serverSocket = null;
    MulticastSocket ms = null;
    InputStreamReader isr;
    BufferedReader br;
    String message;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(3400);

            socket = serverSocket.accept();
            dataInputStream = new DataInputStream(socket.getInputStream());
            isr = new InputStreamReader(socket.getInputStream());
            br = new BufferedReader(isr);

            if(dataInputStream.available() > 0) {

                MainActivity.textView.setText(br.readLine());;

                }


        } catch (IOException e) {
            e.printStackTrace();

        }
        finally {

            try {
                if (socket != null){
                    dataInputStream.close();
                    socket.close();
                    serverSocket.close();
                    new TcpReceiver().start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // new TcpReceiver().start();
    }

    /*@Override
    public void run() {
        byte[] data = new byte[1024];
        try {
            InetAddress groupAddress = InetAddress.getByName("224.0.0.1");
            ms = new MulticastSocket(3400);
            ms.joinGroup(groupAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            serverSocket = new ServerSocket(3400);

            while (true) {
                try {
                    socket = serverSocket.accept();
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    isr = new InputStreamReader(socket.getInputStream());
                    br = new BufferedReader(isr);
                    //while (br.readLine() != "")
                    //    message = br.readLine();

                    while (!Thread.currentThread().isInterrupted()) {

                        try {

                            String read = br.readLine();

                            if (read == null) {
                                Thread.currentThread().interrupt();
                            } else {
                                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                                out.write("TstMsg");

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                   *//* while(true) {
                        if (dataInputStream.available() > 0) {
                            message = br.readLine();
                            MainActivity.textView.setText(message);
                            dataOutputStream.writeUTF("Hello Client");
                            sleep(200);
                        }
                    }*//*
                    } catch (IOException e) {
                        e.printStackTrace();
                        try {
                            dataInputStream.close();
                            dataOutputStream.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } *//*catch (InterruptedException e) {
                        e.printStackTrace();
                        try {
                            dataInputStream.close();
                            dataOutputStream.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }*//* finally {

                        try {
                            if (socket != null)
                                socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }}

    }catch (IOException e) {
            e.printStackTrace();
        }
}*/
}