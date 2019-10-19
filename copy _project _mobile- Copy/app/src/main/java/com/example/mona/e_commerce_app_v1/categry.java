package com.example.mona.e_commerce_app_v1;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class categry extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categry);

        ListView mylist=(ListView)findViewById(R.id.my_list);
        final ArrayAdapter<String> myadapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
        mylist.setAdapter(myadapter);
        final dp_helper_1 myclass=new dp_helper_1(this);
        final String cust_id=(getIntent().getExtras().getString("cust_id"));
        Cursor myCu= myclass.get_categry();

        while (!myCu.isAfterLast()) {
            myadapter.add(myCu.getString(0));
            myCu.moveToNext();
        }

        Button back=(Button)findViewById(R.id.button10);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(categry.this,show_products.class);
                i.putExtra("cust_id",cust_id);
                startActivity(i);
            }
        });

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // final String cust_id=(getIntent().getExtras().getString("cust_id"));
                String cat_name=((TextView)view).getText().toString();
                Intent i1=new Intent(categry.this,pro_in_categry.class);
                i1.putExtra("cat_name",cat_name);
                i1.putExtra("cust_id",cust_id);
                startActivity(i1);
            }
        });
    }
}
