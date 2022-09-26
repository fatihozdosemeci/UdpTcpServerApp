package com.example.udptcpsenderreceiver;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SetPassDialog extends AppCompatDialogFragment {
    private EditText editUsername;
    private EditText editPassword;
    public static boolean check=false;
    String username = "amega",password="123456",passInput,userInput,ipAddressString,ownIp;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_passdialog,null);

        editUsername = view.findViewById(R.id.editUsername);
        editPassword = view.findViewById(R.id.editPassword);


        builder.setView(view)
                .setTitle("login")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userInput = editUsername.getText().toString();
                        passInput = editPassword.getText().toString();
                        if(username.equals(userInput))
                        {
                            if(password.equals(passInput))
                            {
                                check = true;
                                Toast.makeText(getActivity(),"ayarlama modu açık",Toast.LENGTH_SHORT).show();
                               //MainActivity.addButon.setVisibility(View.VISIBLE);
                               //MainActivity.cıkButon.setVisibility(View.VISIBLE);
                                MainActivity.textIp.setVisibility(View.VISIBLE);
                            }
                            else
                            {
                                check = false;
                                Toast.makeText(getActivity(),"kullanıcı adınız veya parolanız hatalı",Toast.LENGTH_SHORT).show();
                            }

                        }
                        else
                        {
                            check = false;
                            Toast.makeText(getActivity(),"kullanıcı adınız veya parolanız hatalı",Toast.LENGTH_SHORT).show();
                        }


                    }
                });



        return builder.create();
    }




}
