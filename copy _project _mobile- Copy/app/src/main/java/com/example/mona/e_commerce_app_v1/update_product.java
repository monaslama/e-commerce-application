package com.example.mona.e_commerce_app_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class update_product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        final dp_helper_1 myclass=new dp_helper_1(this);
        final TextView name=(TextView)findViewById(R.id.textView7);
        final TextView price=(TextView)findViewById(R.id.textView8);
        final EditText updated_quantity=(EditText)findViewById(R.id.editText8);
        Button update=(Button)findViewById(R.id.button6);

        price.setText(getIntent().getExtras().getString("price"));
        name.setText(getIntent().getExtras().getString("pro_name"));
        updated_quantity.setText(getIntent().getExtras().getString("quantity"));
        final String cust_id=(getIntent().getExtras().getString("cust_id"));

       // name.setText(getIntent().getExtras().getString("pro_name"));
       // final int pro_id=myclass.get_product_id(name.getText().toString());
       // price.setText(myclass.get_price(pro_id));
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //product_name come from intent
                myclass.update_quantities(myclass.get_product_id(name.getText().toString()),Integer.parseInt(price.getText().toString()),Integer.parseInt(updated_quantity.getText().toString()),Integer.parseInt(cust_id));
                updated_quantity.setText("");
                Toast.makeText(getApplicationContext(),"updated sucessfully ",Toast.LENGTH_LONG).show();

            }
        });

        Button back=(Button)findViewById(R.id.button7);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent back=new  Intent (update_product.this,show_products.class);
                back.putExtra("cust_id",cust_id);
                startActivity(back);
            }
        });

    }

    }

