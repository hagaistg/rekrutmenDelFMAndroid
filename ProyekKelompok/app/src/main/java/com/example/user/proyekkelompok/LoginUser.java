package com.example.user.proyekkelompok;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginUser extends AppCompatActivity {
    private SharedPreferences pref;
    EditText namaa, nimm;
    private SharedPreferences.Editor editor;
    private final String USERNAME = "admin";
    private final String PASS = "admin";
    ProgressDialog pDialog;
    EditText e1,e2;
    Button b1;
    Button b2;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        db = new DatabaseHelper(this);
        e1 = findViewById(R.id.email);
        e2 = findViewById(R.id.password);
        b1 = findViewById(R.id.login);
        b2 = findViewById(R.id.register);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ia = new Intent(LoginUser.this, Register.class);
                startActivity(ia);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean Chkemailpass = db.emailpassword(email, password);
                if(Chkemailpass == true) {
                    pDialog = new ProgressDialog(LoginUser.this);
                    pDialog.setMessage("Sedang Login...");
                    pDialog.setIndeterminate(false);
                    pDialog.setCancelable(true);
                    pDialog.show();
                    //Toast.makeText(getApplicationContext(),"Succesfully login", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginUser.this, HalamanUtamaUser.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_SHORT).show();
            }
        });
        namaa = (EditText)findViewById(R.id.email);
        nimm = (EditText)findViewById(R.id.password);

        pref = getSharedPreferences("mypreferences", MODE_PRIVATE);
        editor = pref.edit();
        editor.putString(USERNAME, "admin");
        editor.putString(PASS , "admin");
        editor.apply();


        Button btnLogin = findViewById(R.id.btn_masuk);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = namaa.getText().toString();
                String nim = nimm.getText().toString();
                String savedName = pref.getString(USERNAME, "-");
                String savedPass = pref.getString(PASS, "-");
                if(nama.equals("") || nim.equals("")){
                    Toast.makeText(getApplicationContext(), "Tidak boleh kosong" , Toast.LENGTH_SHORT).show();

                }else if(nama.equals(savedName) && nim.equals(savedPass)){
                    Intent next = new Intent(getApplicationContext(),HalamanUtamaAdmin.class);
                    startActivity(next);
                    finish();
                }else{
                    Toast.makeText(LoginUser.this, "Salah" , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    }


