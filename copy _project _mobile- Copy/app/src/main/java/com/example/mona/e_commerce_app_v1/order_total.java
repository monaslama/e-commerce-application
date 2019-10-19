package com.example.mona.e_commerce_app_v1;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class order_total extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_total);

        final dp_helper_1 myclass=new dp_helper_1(this);
        final String cust_id=(getIntent().getExtras().getString("cust_id"));

        final TextView total=(TextView)findViewById(R.id.textView10);
        int quantity=0;
        Cursor myCu= myclass.get_all_quantity(Integer.parseInt(cust_id));
        while (!myCu.isAfterLast()) {
            quantity+=myCu.getInt(0)*myCu.getInt(1);
            myCu.moveToNext();
        }
        total.setText(String.valueOf(quantity));
        Button buy=(Button)findViewById(R.id.button8);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(order_total.this, "buy and go to set address", Toast.LENGTH_SHORT).show();
                //add order,order details
               Intent i=new Intent(order_total.this,MapsActivity.class);
                i.putExtra("cust_id",cust_id);
                myclass.on_delete_shopping();
               startActivity(i);


            }
        });
        Button back=(Button)findViewById(R.id.button9);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(order_total.this,show_products.class);
                i.putExtra("cust_id",cust_id);
                startActivity(i);
            }
        });
    }
    }

