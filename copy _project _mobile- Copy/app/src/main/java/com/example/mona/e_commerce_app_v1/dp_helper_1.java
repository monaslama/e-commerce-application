package com.example.mona.e_commerce_app_v1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Date;


public class dp_helper_1 extends SQLiteOpenHelper {
    private  static final  String dbname="product_db2";
    SQLiteDatabase moviedb;
    public dp_helper_1(@Nullable Context context)  {
        super(context, "product_db2", null, 9);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table customers(cust_id integer primary key autoincrement,custname text," +
                "username text,password integer,gender text,birthdate text,job text);");

        sqLiteDatabase.execSQL("create table orders(ordid integer primary key autoincrement" +
                ",orddate text ,custid integer ,adress text " +
                ",FOREIGN key(custid)REFERENCES customers( cust_id  ))");

        sqLiteDatabase.execSQL("create table categories(cat_id integer primary key autoincrement" +
                ",catname text );");

        sqLiteDatabase.execSQL("create table products(proid integer primary key autoincrement" +
                ",pro_name text ,price integer,quatity integer,catid integer " +
                ",FOREIGN key(catid)REFERENCES categories(cat_id ))");

        sqLiteDatabase.execSQL("create table order_details(ord_id integer," +
                "pro_id integer ,quantity integer " +
                ",FOREIGN key(ord_id)REFERENCES orders(ordid ),FOREIGN key(pro_id)REFERENCES products(proid ),primary key (ord_id,pro_id))");

        sqLiteDatabase.execSQL("create table shopping_card( product_id integer primary key autoincrement" +
                ",price integer ,Amount Integer ,pro_name text ,custid integer" +
                ",FOREIGN key(product_id)REFERENCES products(proid ),FOREIGN key(custid)REFERENCES customers(cust_id ))");

        //,custid integer,FOREIGN key(custid)REFERENCES customers(cust_id ),
        /*sqLiteDatabase.execSQL("create table shopping_card(shop_id integer primary key autoincrement" +
                ",product_id Integer  " +
                ",FOREIGN key(product_id)REFERENCES products(proid ))");*/

        ContentValues row=new ContentValues();
        /*row.put("custname","ahmed mohamed");
        row.put("username","ahmed");
        row.put("password","123");
        row.put("gender","male");
        row.put("birthdate","1/1/2000");
        row.put("job","doctor");
        sqLiteDatabase.insert("customers",null,row);


        row.put("custname"," mohamed ahmed");
        row.put("username","mohamed");
        row.put("password","1234");
        row.put("gender","male");
        row.put("birthdate","1/1/2001");
        row.put("job","engineer");
        sqLiteDatabase.insert("customers",null,row);*/

//sqLiteDatabase.execSQL("insert into cutomers(custname,username,password,gender,birthdate,job) values("mohamed ahmed","mohamed")");
        row.put("custname","mai ahmed");
        row.put("username","mai");
        row.put("password","12345");
        row.put("gender","female");
        row.put("birthdate","1/1/2002");
        row.put("job","engineer");
        sqLiteDatabase.insert("customers",null,row);

        row.put("custname","mona slama");
        row.put("username","mona");
        row.put("password","123456");
        row.put("gender","female");
        row.put("birthdate","1/1/2003");
        row.put("job","engineer");
        sqLiteDatabase.insert("customers",null,row);

      /*  ContentValues row3=new ContentValues();
        row3.put("orddate","1/5/2018");
        row3.put("custid","1");
        row3.put("adress","25elmateria_st");
        //pass customerid through the forms
        sqLiteDatabase.insert("orders",null,row3);

        row3.put("orddate","1/8/2018");
        row3.put("custid",2);
        row3.put("adress","25suez_st");
        //pass customerid through the forms
        sqLiteDatabase.insert("orders",null,row3);

        row3.put("orddate","1/9/2018");
        row3.put("custid","3");
        row3.put("adress","alex_st");
        //pass customerid through the forms
        sqLiteDatabase.insert("orders",null,row3);

        row3.put("orddate","1/11/2018");
        row3.put("custid","4");
        row3.put("adress","paris_st");
        //pass customerid through the forms
        sqLiteDatabase.insert("orders",null,row3);*/

        ContentValues row2=new ContentValues();
        row2.put("catname","milks");
        //pass customerid through the forms
        sqLiteDatabase.insert("categories",null,row2);

        row2.put("catname","carss");
        //pass customerid through the forms
        sqLiteDatabase.insert("categories",null,row2);

        row2.put("catname","computers");
        //pass customerid through the forms
        sqLiteDatabase.insert("categories",null,row2);

        row2.put("catname","labtops");
        //pass customerid through the forms
        sqLiteDatabase.insert("categories",null,row2);

        insert_all_products(sqLiteDatabase);

      /*  ContentValues row5=new ContentValues();
        row5.put("ord_id","1");
        row5.put("quantity","100");
        row5.put("pro_id","4");
        //pass customerid through the forms
        sqLiteDatabase.insert("order_details",null,row5);

        row5.put("ord_id","2");
        row5.put("quantity","150");
        row5.put("pro_id","3");
        //pass customerid through the forms
        sqLiteDatabase.insert("order_details",null,row5);

        row5.put("ord_id","3");
        row5.put("quantity","200");
        row5.put("pro_id","2");
        //pass customerid through the forms
        sqLiteDatabase.insert("order_details",null,row5);

        row5.put("ord_id","4");
        row5.put("quantity","300");
        row5.put("pro_id","1");
        //pass customerid through the forms
        sqLiteDatabase.insert("order_details",null,row5);*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("drop table if exists customers");
        sqLiteDatabase.execSQL("drop table if exists orders");
        sqLiteDatabase.execSQL("drop table if exists order_details");
        sqLiteDatabase.execSQL("drop table if exists products");
        sqLiteDatabase.execSQL("drop table if exists categories");
        sqLiteDatabase.execSQL("drop table if exists shopping_card");
        onCreate(sqLiteDatabase);
    }


    public void on_delete_shopping()
    {
        moviedb=getWritableDatabase();
        moviedb.delete("shopping_card", null,null);
        moviedb.close();
    }

    public  void insert_all_products(SQLiteDatabase sqLiteDatabase)
    {
        ContentValues row4=new ContentValues();
        row4.put("pro_name","car_1");
        row4.put("price","10000");
        row4.put("quantity","100");
        row4.put("catid",2);
        //pass customerid through the forms
        sqLiteDatabase.insert("products",null,row4);

        row4.put("pro_name","car_2");
        row4.put("price","1000");
        row4.put("quantity","10");
        row4.put("catid",2);
        //pass customerid through the forms
        sqLiteDatabase.insert("products",null,row4);

        ContentValues row3=new ContentValues();
        row3.put("pro_name","milk_1");
        row3.put("price","100");
        row3.put("quatity","300");
        row3.put("catid",1);
        // sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.insert("products",null,row3);


        row3.put("pro_name","milk_2");
        row3.put("price","10");
        row3.put("quatity","30");
        row3.put("catid",1);
        sqLiteDatabase.insert("products",null,row3);

        // ContentValues row7=new ContentValues();

        row3.put("pro_name","computer");
        row3.put("price","1000");
        row3.put("quantity","100");
        row3.put("catid",3);
        //pass customerid through the forms
        sqLiteDatabase.insert("products",null,row3);

        ContentValues row1=new ContentValues();
        row1.put("pro_name","milk_3");
        row1.put("price","80");
        row1.put("quatity","30");
        row1.put("catid",1);
        sqLiteDatabase.insert("products",null,row1);

        row1.put("pro_name","1_milk");
        row1.put("price","100");
        row1.put("quatity","300");
        row1.put("catid",1);
        sqLiteDatabase.insert("products",null,row1);

        //ContentValues row8=new ContentValues();
        row1.put("pro_name","labtop");
        row1.put("price","7000");
        row1.put("quantity","800");
        row1.put("catid",4);
        //pass customerid through the forms
        sqLiteDatabase.insert("products",null,row1);

        row1.put("pro_name","labtop_lenovo");
        row1.put("price","700");
        row1.put("quantity","80");
        row1.put("catid",4);
        //pass customerid through the forms
        sqLiteDatabase.insert("products",null,row1);
        //moviedb.close();
    }
    public void insert_customr(String c_name ,String us_name,String pass,String gender,String bdate,String job)
    {
        ContentValues row=new ContentValues();
        row.put("custname",c_name);
        row.put("username",us_name);
        row.put("password",pass);
        row.put("gender",gender);
        row.put("birthdate",bdate);
        row.put("job",job);
        moviedb=getWritableDatabase();
        moviedb.insert("customers",null,row);
    }
    public void insert_order(String date , int cus_id , String address)
    {
        ContentValues row=new ContentValues();
        row.put("orddate",date);
        row.put("custid",cus_id);
        row.put("adress",address);
        moviedb=getWritableDatabase();
        moviedb.insert("orders",null,row);
    }
    public Integer get_id_order(int cus_id)
    {
        moviedb=getReadableDatabase();
        Cursor cursor=moviedb.rawQuery("select ord_id from orders where custid like ?"+cus_id,null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }
    public void insert_order_details(int ord_id,int cu ) {

        Cursor cursor = get_all_quantity_in_shopping(cu);
        //row.put("pro_id",pro_id);
        //row.put("quantity",quantity);
        String pro_name;
        int pro_id;
        while (!cursor.isAfterLast()) {
            ContentValues row = new ContentValues();
            row.put(" ord_id", ord_id);
            pro_name=cursor.getString(2);
            pro_id=get_product_id(pro_name);
            row.put("pro_id",pro_id);
            row.put("quantity",Integer.parseInt(cursor.getString(1)));
            cursor.moveToNext();
            moviedb = getWritableDatabase();
            moviedb.insert("order_details", null, row);
        }

    }

    public void update_customer_password( Integer cust_id,Integer new_pass)
    {
        moviedb=getWritableDatabase();
        ContentValues row=new ContentValues();
        row.put("password",new_pass);
        moviedb.update("customers",row,"cust_id like ?",new String[]{String.valueOf(cust_id)});
        moviedb.close();
    }


    public Integer get_cust_id_user(String user_name)
    {
        moviedb=getReadableDatabase();
        Cursor cursor=moviedb.rawQuery("select cust_id from customers where username like ?",new String[]{user_name});
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public Integer get_cust_id(String cust_name)
    {
        moviedb=getReadableDatabase();
        Cursor cursor=moviedb.rawQuery("select cust_id from customers where custname like ?",new String[]{cust_name});
        cursor.moveToFirst();
        return cursor.getInt(0);
    }
    public Cursor fetch()
    {   moviedb=getReadableDatabase();
        String []rowdetaled={"custname","username","password","gender","birthdate","job"};
        Cursor cursor=moviedb.query("customers",rowdetaled,null,null,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }
        moviedb.close();
        return cursor;
    }
    public Cursor get_products_search(String name)
    {
        moviedb=getReadableDatabase();
        String []rowdetailed={"%"+name+"%"};
        Cursor cursor=moviedb.rawQuery("select pro_name from products where pro_name like ?  ",rowdetailed);
        cursor.moveToFirst();
        moviedb.close();
        return cursor;
    }
    public Cursor fetch_product()
    {
        moviedb=getReadableDatabase();
        String []rowdetaled={"pro_name"};
        // String []rowdetaled={"proid","pro_name","price","quatity","catid"};
        Cursor cursor=moviedb.query("products",rowdetaled,null,null,null,null,null);
        // Cursor cursor=moviedb.rawQuery("select pro_name from products",null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }

        return cursor;
    }

    public boolean check(String mail,int pass)
    {
        moviedb=getReadableDatabase();
        // String []rowdetailed={String.valueOf(pass)};
        Cursor cursor=moviedb.rawQuery("select username from customers where password = "+pass,null);
        cursor.moveToFirst();
        // Toast.makeText(getapplication context,"",Toast.LENGTH_LONG).show();
        moviedb.close();
        if(cursor.getString(0)==mail)
        {
            return true;
        }
        return false;
    }

    public Cursor check_pass(String mail)
    {
        moviedb=getReadableDatabase();
        String []rowdetailed={mail};
        Cursor cursor=moviedb.rawQuery("select password from customers where username like ?",rowdetailed);
        cursor.moveToFirst();
        moviedb.close();
        return cursor;
    }
    public Cursor check_cut_name(String cust_name)
    {
        moviedb=getReadableDatabase();
        String []rowdetailed={cust_name};
        Cursor cursor=moviedb.rawQuery("select username from customers where custname like ? ",rowdetailed);
        cursor.moveToFirst();
        moviedb.close();
        return cursor;
    }
    public Cursor check_user_name(String user_name)
    {

        moviedb=getReadableDatabase();
        String []rowdetailed={user_name};
        Cursor cursor=moviedb.rawQuery("select custname from customers where  username like ? ",rowdetailed);
        cursor.moveToFirst();
        moviedb.close();
        return cursor;
    }

    public void add_product(Integer price,Integer amount,String pro_name)
    {
        //,Integer cust_id
        ContentValues row=new ContentValues();
        row.put("price",price);
        row.put("Amount",amount);
        // row.put("custid",cust_id);
        row.put("pro_name",pro_name);
        moviedb=getWritableDatabase();
        moviedb.insert("products",null,row);
        moviedb.close();

    }
    public void add_quantities(Integer price,Integer amount,String pro_name,Integer cust_id)
    {
        //,Integer cust_id
        amount=1;
        ContentValues row=new ContentValues();
        row.put("price",price);
        row.put("Amount",amount);
        row.put("custid",cust_id);
        row.put("pro_name",pro_name);
        moviedb=getWritableDatabase();
        moviedb.insert("shopping_card",null,row);
        moviedb.close();

    }
    public void update_quantities( Integer pro_id,Integer new_price,Integer amount,int cus_id)
    {
        moviedb=getWritableDatabase();
        ContentValues ro=new ContentValues();
        ro.put("price",new_price);
        //Toast.makeText(, amount, Toast.LENGTH_SHORT).show();
        ro.put("Amount",amount);
        //moviedb.update("shopping_card",row,"product_id like ?",new String[]{String.valueOf(pro_id)});
        moviedb.update("shopping_card",ro,"product_id =? And custid =?",new String[]{String.valueOf(pro_id),String.valueOf(cus_id)});
        moviedb.close();
    }
    public void delete_quantities(Integer product_id,int cus_id)
    {
        moviedb=getWritableDatabase();
        moviedb.delete("shopping_card","product_id =? and custid=? ",new String[]{String.valueOf(product_id),String.valueOf(cus_id)});
        moviedb.close();
    }

    public Integer get_product_id(String pro_name)
    {
        moviedb=getReadableDatabase();
        Cursor cursor=moviedb.rawQuery("select proid from products where pro_name like ?",new String[]{pro_name});
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public Cursor get_product_info(Integer pro_id)
    {
        moviedb = getReadableDatabase();
        String []name_det={String.valueOf(pro_id)};
        String[]rowdetailed={"price","quatity"};
        Cursor cursor=moviedb.rawQuery("select price , quatity  from products where proid like "+pro_id,null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        moviedb.close();
        return cursor;
    }


    public Cursor get_all_quantity(int cust_id)
    {
        moviedb = getReadableDatabase();
        String []name_det={String.valueOf(cust_id)};
        //String[]rowdetailed={"price","quatity"};
        Cursor cursor=moviedb.rawQuery("select price , Amount   from shopping_card  where custid = "+cust_id,null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        moviedb.close();
        return cursor;
    }
    public Cursor get_all_quantity_products()
    {
        moviedb = getReadableDatabase();
        //String []name_det={String.valueOf(pro_id)};
        //String[]rowdetailed={"price","quatity"};
        Cursor cursor=moviedb.rawQuery("select price , quatity   from products  ",null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        moviedb.close();
        return cursor;
    }

    public Cursor get_all_quantity_in_shopping(int cust_id)
    {
        moviedb = getReadableDatabase();
        String []name_det={String.valueOf(cust_id)};
        //String []name_det={String.valueOf(pro_id)};
        //String[]rowdetailed={"price","quatity"};
        Cursor cursor=moviedb.rawQuery("select price , Amount ,pro_name  from shopping_card  where custid like ? ",name_det);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        moviedb.close();
        return cursor;
    }
    public  Cursor get_categry()
    {
        moviedb = getReadableDatabase();
        //String []name_det={String.valueOf(pro_id)};
        String[]rowdetailed ={"catname"};
        Cursor cursor=moviedb.query("categories",rowdetailed,null,null,null,null,null);
        // Cursor cursor=moviedb.rawQuery("select catname  from categories  ",null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        moviedb.close();
        return cursor;
    }
    public int get_categry_id(String Cat_name)
    {
        moviedb=getReadableDatabase();
        String []rowde={Cat_name};
        Cursor cursor=moviedb.rawQuery("select cat_id from categories where catname like ?",rowde);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        moviedb.close();

        return cursor.getInt(0);
    }

    public Cursor get_pro_cat(int cat_id)
    {
        moviedb=getReadableDatabase();
        Cursor cursor=moviedb.rawQuery("select pro_name from products where catid="+cat_id,null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        moviedb.close();

        return cursor;
    }

}


