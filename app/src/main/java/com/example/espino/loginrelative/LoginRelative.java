package com.example.espino.loginrelative;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.espino.loginrelative.Controllers.ILoginMvc;
import com.example.espino.loginrelative.Controllers.LoginTableController;

public class LoginRelative extends AppCompatActivity {

    private ILoginMvc loginMvc;
    private EditText edtUser, edtPaswd;
    private Button btnOk, btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_relative);

        loginMvc = new LoginTableController();
        edtUser = (EditText) findViewById(R.id.editUser);
        edtPaswd = (EditText) findViewById(R.id.editPasswd);
        btnOk = (Button) findViewById(R.id.btnOK);
        btnCancel = (Button) findViewById(R.id.btnCancel);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String passwd = edtPaswd.getText().toString();
                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(passwd))
                    Toast.makeText(LoginRelative.this,getResources().getString(R.string.data_empty),Toast.LENGTH_SHORT).show();
                else {
                    int result = loginMvc.validateCredentials(user, passwd);
                    switch (result) {
                        case LoginTableController.PASSWD_DIGIT:
                            Toast.makeText(LoginRelative.this,getResources().getString(R.string.passwd_digit),Toast.LENGTH_SHORT).show();
                            break;
                        case LoginTableController.PASSWD_CASE:
                            Toast.makeText(LoginRelative.this,getResources().getString(R.string.passwd_case),Toast.LENGTH_SHORT).show();
                            break;
                        case LoginTableController.PASSWD_LENGTH:
                            Toast.makeText(LoginRelative.this,getResources().getString(R.string.passwd_length),Toast.LENGTH_SHORT).show();
                            break;
                        case LoginTableController.OK:
                            //se lanza la activity después del login
                            break;
                    }
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //@ referencia a algo
        //? el valor de un atributo se asigna
    }

    private void resetValues(){
        edtPaswd.setText("");
        edtUser.setText("");
    }


}
