package com.example.mona.e_commerce_app_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        final dp_helper_1 myclass=new dp_helper_1(this);
        final String cust_id=(getIntent().getExtras().getString("cust_id"));
        final EditText pro_name=(EditText)findViewById(R.id.editText4);
        final EditText price=(EditText)findViewById(R.id.editText5);
        final EditText amount=(EditText)findViewById(R.id.editText6);
        final Button addproducts=(Button)findViewById(R.id.button4);

        addproducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myclass.add_product(Integer.parseInt(price.getText().toString()),Integer.parseInt(amount.getText().toString()),pro_name.getText().toString());
                Toast.makeText(getApplicationContext(),"product added sucessfuly",Toast.LENGTH_LONG).show();
                pro_name.setText("");
                price.setText("");
                amount.setText("");
            }
        });
        Button back=(Button)findViewById(R.id.button5);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent i1 =new Intent(add_product.this,show_products.class);
                i1.putExtra("cust_id",cust_id);
                startActivity(i1);
            }
        });

    }
}
