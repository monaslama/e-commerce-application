package com.example.mona.e_commerce_app_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class update_password_cust extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password_cust);

       // i.putExtra("user_mail",getIntent().getExtras().getString("user_mail"));
       // i.putExtra("cust_name",cust_name);
        final dp_helper_1 myclass=new dp_helper_1(this);

        TextView user_mail=(TextView)findViewById(R.id.textView20);
        final TextView cust_name=(TextView)findViewById(R.id.textView19);
        final EditText new_pass=(EditText) findViewById(R.id.editText3);

        user_mail.setText(getIntent().getExtras().getString("user_mail"));
        cust_name.setText(getIntent().getExtras().getString("cust_name"));

        Button reset=(Button)findViewById(R.id.button13);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myclass.update_customer_password(myclass.get_cust_id(cust_name.getText().toString()),Integer.parseInt(new_pass.getText().toString()));
                Toast.makeText(update_password_cust.this, "reset password succuessfully", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(update_password_cust.this,show_products.class);
                startActivity(i);
            }
        });
        Button back=(Button)findViewById(R.id.button14);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(update_password_cust.this,forget_pass.class);
                startActivity(i);
            }
        });
    }
}
