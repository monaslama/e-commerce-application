package com.example.mona.e_commerce_app_v1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class shopping_card extends AppCompatActivity {
    ArrayAdapter<String> myadapter;
    ListView mylist;
    dp_helper_1 myclass;
     String cust_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_card);
//final String cust_id=(getIntent().getExtras().getString("cust_id"));
       // i.putExtra("cust_id",cust_id);
        mylist=(ListView)findViewById(R.id.my_list_shopping);
        myadapter =new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
        mylist.setAdapter(myadapter);

        cust_id=(getIntent().getExtras().getString("cust_id"));

       myclass =new dp_helper_1(this);

        Cursor myCu= myclass.get_all_quantity_in_shopping(Integer.parseInt(cust_id));

        while (!myCu.isAfterLast()) {
           myadapter.add(myCu.getString(2)+":-"+myCu.getString(0)+" q: "+myCu.getString(1));
           // myadapter.add(myCu.getString(2));
            myCu.moveToNext();
        }
    }
    @Override
    protected void onRestart() {

        myadapter.clear();
        cust_id=(getIntent().getExtras().getString("cust_id"));
        Cursor myCu= myclass.get_all_quantity_in_shopping(Integer.parseInt(cust_id));
        while (!myCu.isAfterLast()) {
            myadapter.add(myCu.getString(2)+":-"+myCu.getString(0)+" q: "+myCu.getString(1));
            // myadapter.add(myCu.getString(2));
            myCu.moveToNext();
        }
        super.onRestart();
    }
}
