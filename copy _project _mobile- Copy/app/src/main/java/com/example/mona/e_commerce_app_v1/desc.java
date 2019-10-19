package com.example.mona.e_commerce_app_v1;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class desc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);

       final dp_helper_1 myclass=new dp_helper_1(this);
        TextView pro_name=(TextView)findViewById(R.id.textView12);
        TextView price=(TextView)findViewById(R.id.textView16);
        TextView quantity=(TextView)findViewById(R.id.textView18);

        final String cust_id=(getIntent().getExtras().getString("cust_id"));
        price.setText(getIntent().getExtras().getString("price"));
        pro_name.setText(getIntent().getExtras().getString("pro_name"));
        quantity.setText(getIntent().getExtras().getString("quantity"));

        Button add=(Button)findViewById(R.id.button3);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Cursor cursor=  myclass.get_all_quantity_in_shopping(myclass.get_product_id(getIntent().getExtras().getString("pro_name")));
                Cursor cursor=  myclass.get_product_info(myclass.get_product_id(getIntent().getExtras().getString("pro_name")));
                myclass.add_quantities(cursor.getInt(0),cursor.getInt(1),getIntent().getExtras().getString("pro_name"),Integer.parseInt(cust_id));
                Toast.makeText(getApplicationContext(),"added to shopping ",Toast.LENGTH_LONG).show();
            }
        });
        Button back=(Button)findViewById(R.id.button12);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(desc.this,show_products.class);
                i.putExtra("cust_id",cust_id);
                startActivity(i);
            }
        });
    }
}
