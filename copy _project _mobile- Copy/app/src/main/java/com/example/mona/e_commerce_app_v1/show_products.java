package com.example.mona.e_commerce_app_v1;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class show_products extends AppCompatActivity {

    ListView mylist;
    ArrayAdapter<String> myadapter;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menue,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menue_all,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        final dp_helper_1 myclass=new dp_helper_1(this);
        final String cust_id=(getIntent().getExtras().getString("cust_id"));
        if(id==R.id.categry)
        {
            Intent i=new Intent(show_products.this,categry.class);
            i.putExtra("cust_id",cust_id);
            startActivity(i);
            return true;
        }
        if(id==R.id.search)
        {
            Intent i=new Intent(show_products.this,search.class);
            i.putExtra("cust_id",cust_id);
            startActivity(i);
            return true;
        }
        if(id==R.id.add_products)
        {
            Intent i=new Intent(show_products.this,add_product.class);
            i.putExtra("cust_id",cust_id);
            startActivity(i);
            return true;
        }
        if(id==R.id.order_total)
        {
            Intent i=new Intent(show_products.this,order_total.class);
            i.putExtra("cust_id",cust_id);
            startActivity(i);
            return true;
        }
        if(id==R.id.shopping_card)
        {
            Intent i=new Intent(show_products.this,shopping_card.class);
            i.putExtra("cust_id",cust_id);
            startActivity(i);
            return true;
        }
        if(id==R.id.search_txt)
        {
            Intent i=new Intent(show_products.this,search_txt_1.class);
            i.putExtra("cust_id",cust_id);
            startActivity(i);
            return true;
        }
        if(id==R.id.search_barcode)
        {
            Intent i=new Intent(show_products.this,bar_code.class);
            i.putExtra("cust_id",cust_id);
            startActivity(i);
            return true;
        }
        if(id==R.id.bar_graph)
        {
            Intent i=new Intent(show_products.this,simple_bargraph.class);
            i.putExtra("cust_id",cust_id);
            startActivity(i);
            return true;
        }
        if(id==R.id.search_barcod_f)
        {
            Intent i=new Intent(show_products.this,camera.class);
            i.putExtra("cust_id",cust_id);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        String selected_product=((TextView)info.targetView).getText().toString();
        final dp_helper_1 myclass=new dp_helper_1(this);
        int id=item.getItemId();

        final String cust_id=(getIntent().getExtras().getString("cust_id"));
       // Toast.makeText(getApplicationContext(),cust_id,Toast.LENGTH_LONG).show();

        if(id==R.id.add_to_shopping)
        {
            Cursor cursor=  myclass.get_product_info(myclass.get_product_id(selected_product));
            myclass.add_quantities(cursor.getInt(0),cursor.getInt(1),selected_product,Integer.parseInt(cust_id));
            Toast.makeText(getApplicationContext(),"added to shopping ",Toast.LENGTH_LONG).show();
            return true;

        }
        if(id==R.id.add_quantity)
        {
            //myclass.get_all_quantity()
            //Cursor cursor=  myclass.get_all_quantity(Integer.parseInt(cust_id));
            Cursor cursor=  myclass.get_all_quantity_in_shopping(Integer.parseInt(cust_id));
            Intent i=new Intent(show_products.this,add_quantity_shopping.class);
            i.putExtra("pro_name",selected_product);
           // Toast.makeText(getApplicationContext(),String.valueOf(cursor.getInt(1)),Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(),String.valueOf(cursor.getInt(0)),Toast.LENGTH_LONG).show();
            i.putExtra("quantity",cursor.getString(1));
            i.putExtra("price",cursor.getString(0));
            i.putExtra("cust_id",cust_id);
            startActivity(i);
            return true;
        }
        if(id==R.id.update_quantity)
        {
            //Cursor cursor=  myclass.get_all_quantity(Integer.parseInt(cust_id));
            Cursor cursor=  myclass.get_all_quantity_in_shopping(Integer.parseInt(cust_id));
            Intent i=new Intent(show_products.this,update_product.class);
            i.putExtra("pro_name",selected_product);
            i.putExtra("quantity",cursor.getString(1));
            i.putExtra("price",cursor.getString(0));
            i.putExtra("cust_id",cust_id);
            startActivity(i);
            return true;
        }
        if(id==R.id.delete_quantity)
        {
            myclass.delete_quantities(myclass.get_product_id(selected_product),Integer.parseInt(cust_id));
            return true;
        }
        if(id==R.id.desc)
        {
            Cursor cursor=  myclass.get_all_quantity_products();
            Intent i=new Intent(show_products.this,desc.class);
            i.putExtra("pro_name",selected_product);
            i.putExtra("quantity",cursor.getString(1));
            i.putExtra("price",cursor.getString(0));
            i.putExtra("cust_id",cust_id);
            startActivity(i);
            return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_products);

       mylist=(ListView)findViewById(R.id.mylist);
       myadapter =new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
        mylist.setAdapter(myadapter);
        registerForContextMenu(mylist);

       // final String cust_id=(getIntent().getExtras().getString("cust_id"));
       // Toast.makeText(getApplicationContext(),cust_id,Toast.LENGTH_LONG).show();
        final dp_helper_1 myclass=new dp_helper_1(this);
       // String name = getIntent().getExtras().getString("name");
        Cursor myCu= myclass.fetch_product();
            while (!myCu.isAfterLast())
            {
                myadapter.add(myCu.getString(0));
             /* myadapter.add(myCu.getString(1));
                myadapter.add(myCu.getString(2));
                myadapter.add(myCu.getString(3));
                myadapter.add(myCu.getString(4));
                myadapter.add(myCu.getString(5));*/
                myCu.moveToNext();
           }

           // Toast.makeText(getApplicationContext(),"nnnn",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {

        myadapter.clear();
        final dp_helper_1 myclass=new dp_helper_1(this);
        // String name = getIntent().getExtras().getString("name");
        Cursor myCu= myclass.fetch_product();
        while (!myCu.isAfterLast())
        {
            myadapter.add(myCu.getString(0));
             /* myadapter.add(myCu.getString(1));
                myadapter.add(myCu.getString(2));
                myadapter.add(myCu.getString(3));
                myadapter.add(myCu.getString(4));
                myadapter.add(myCu.getString(5));*/
            myCu.moveToNext();
        }
        super.onRestart();
    }
}
