package com.example.mona.e_commerce_app_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class add_quantity_shopping extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quantity_shopping);

        final dp_helper_1 myclass=new dp_helper_1(this);
        final TextView price=(TextView)findViewById(R.id.price);
        final TextView pro_name=(TextView)findViewById(R.id.pro_name);
        final EditText quantity=(EditText)findViewById(R.id.quantity);

        final String cust_id=(getIntent().getExtras().getString("cust_id"));
        price.setText(getIntent().getExtras().getString("price"));
        pro_name.setText(getIntent().getExtras().getString("pro_name"));
        quantity.setText(getIntent().getExtras().getString("quantity"));

       // int pro_id=myclass.get_product_id(getIntent().getExtras().getString("pro_name"));
        //Toast.makeText(getApplicationContext(),String.valueOf(pro_id),Toast.LENGTH_LONG).show();
       Button add=(Button)findViewById(R.id.add);
       add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getApplicationContext(),quantity.getText().toString(),Toast.LENGTH_LONG).show();
               myclass.update_quantities(myclass.get_product_id(pro_name.getText().toString()),Integer.parseInt(price.getText().toString()),Integer.parseInt(quantity.getText().toString()),Integer.parseInt(cust_id));
               Toast.makeText(getApplicationContext(),"added sucessfully",Toast.LENGTH_LONG).show();
               quantity.setText("");
           }
       });
        Button back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(add_quantity_shopping.this,show_products.class);
                i.putExtra("cust_id",cust_id);
                startActivity(i);
            }
        });
    }
}
