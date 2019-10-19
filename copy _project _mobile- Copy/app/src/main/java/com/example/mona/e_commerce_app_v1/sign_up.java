package com.example.mona.e_commerce_app_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText cust_name     =(EditText)findViewById(R.id.email);
        final  EditText user_name      =(EditText)findViewById(R.id.editText4);
        final  EditText password      =(EditText)findViewById(R.id.editText5);
        final  EditText gender    =(EditText)findViewById(R.id.editText6);
        //final  EditText birth_date=(EditText)findViewById(R.id.editText7);
        final  EditText job=(EditText)findViewById(R.id.editText8);
        Button contione=(Button)findViewById(R.id.reset);
        Button back=(Button)findViewById(R.id.button4);
        final dp_helper_1 moviedb=new dp_helper_1(getApplicationContext());
        contione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=cust_name.getText().toString();
                String email=user_name.getText().toString();
                String pass=password.getText().toString();
                String gen=gender.getText().toString();
                // String b_date=birth_date.getText().toString();
                String job_cust=job.getText().toString();

                // call fun insert
                Intent i=new Intent(sign_up.this,continue_signup.class);
                i.putExtra("name",name);
                i.putExtra("email",email);
                i.putExtra("pass",pass);
                i.putExtra("gen",gen);
                i.putExtra("job_cust",job_cust);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_activity=new Intent(sign_up.this,log_in.class);
                startActivity(main_activity);
            }
        });
    }
}
