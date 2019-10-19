package com.example.mona.e_commerce_app_v1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class pro_in_categry extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_in_categry);

        ListView mylist=(ListView)findViewById(R.id.categry_pro_list);
        final ArrayAdapter<String> myadapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
        mylist.setAdapter(myadapter);

        final dp_helper_1 myclass=new dp_helper_1(this);

        Cursor myCu= myclass.get_pro_cat(myclass.get_categry_id(getIntent().getExtras().getString("cat_name")));
        while (!myCu.isAfterLast()) {
            myadapter.add(myCu.getString(0));
            myCu.moveToNext();
        }
    }
}
