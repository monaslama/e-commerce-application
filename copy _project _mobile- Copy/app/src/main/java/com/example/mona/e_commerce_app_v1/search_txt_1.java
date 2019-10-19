package com.example.mona.e_commerce_app_v1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class search_txt_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_txt_1);

        final EditText pro_name=(EditText)findViewById(R.id.editText9);
        ListView mylist=(ListView)findViewById(R.id.my_search_txt_1);
        final ArrayAdapter<String> myadapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
        mylist.setAdapter(myadapter);
        final dp_helper_1 myclass=new dp_helper_1(getApplicationContext());
        final String cust_id=(getIntent().getExtras().getString("cust_id"));
        Button search=(Button)findViewById(R.id.button16);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor= myclass.get_products_search(pro_name.getText().toString());
                while (!cursor.isAfterLast()) {
                    myadapter.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
        });
        //String name=Intent.get
    }
}
