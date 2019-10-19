package com.example.mona.e_commerce_app_v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class camera extends AppCompatActivity {

    dp_helper_1 ecommerce;
    public static EditText search_camera;
    ListView list_camera;
    Button cameraSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ecommerce = new dp_helper_1(this);
        search_camera = findViewById(R.id.search_camera);
        list_camera = findViewById(R.id.list_camer);
        Button btnCameraSearch = findViewById(R.id.camera);
        btnCameraSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), cameraCode.class);
                startActivity(i);
            }
        });

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        list_camera.setAdapter(adapter);
        cameraSearch = findViewById(R.id.search_camer);

        cameraSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String milk="8480000107480";
                if(search_camera.getText().toString().equals(String.valueOf(milk)))
                {
                search_camera.setText("milk");
                    Cursor cursor = ecommerce.get_products_search(search_camera.getText().toString());
                    adapter.clear();
                    if(!cursor.equals(null)) {
                        while (!((Cursor) cursor).isAfterLast()) {
                            adapter.add(cursor.getString(0));
                            cursor.moveToNext();
                        }
                    }
                }
                else
                {
                    adapter.clear();
                    search_camera.setText("");
                    Toast.makeText(camera.this, "the name is false", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
