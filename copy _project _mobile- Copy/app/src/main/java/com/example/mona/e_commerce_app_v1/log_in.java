package com.example.mona.e_commerce_app_v1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class log_in extends AppCompatActivity implements TextWatcher,
        CompoundButton.OnCheckedChangeListener{

    private    EditText user_et,pass_et;
    private CheckBox rem_user;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String ree_name="prefs";
    private static final String kye_rem="remember";
    private static final String key_user="username";
    private static final String key_pass="password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        sharedPreferences=getSharedPreferences(ree_name,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        user_et=(EditText)findViewById(R.id.editText);
        pass_et=(EditText)findViewById(R.id.editText2);
        rem_user=(CheckBox)findViewById(R.id.checkBox);
        final TextView forg_pass=(TextView)findViewById(R.id.forget);

        forg_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(log_in.this,forget_pass.class);
                i.putExtra("user_mail",user_et.getText().toString());

                startActivity(i);
            }
        });
        if(sharedPreferences.getBoolean(kye_rem,false))
            rem_user.setChecked(true);
        else
            rem_user.setChecked(false);
        user_et.setText(sharedPreferences.getString(key_user,""));
        pass_et.setText(sharedPreferences.getString(key_pass,""));

        user_et.addTextChangedListener((TextWatcher) this);
        pass_et.addTextChangedListener((TextWatcher) this);
        rem_user.addTextChangedListener((TextWatcher) this);

        final Button sign_in=(Button)findViewById(R.id.button);
        final  Button sign_up=(Button)findViewById(R.id.button2);
        final dp_helper_1 moviedb=new dp_helper_1(getApplicationContext());
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name = user_et.getText().toString();
                String pass = pass_et.getText().toString();
                if (!pass.isEmpty() && !user_name.isEmpty())
                {
                   Cursor cursor1=moviedb.check_user_name(user_name);
                   // Toast.makeText(getApplicationContext(),cursor1.getString(0),Toast.LENGTH_LONG).show();
                   int cus_id=moviedb.get_cust_id(cursor1.getString(0));
                   // Toast.makeText(getApplicationContext(),String.valueOf(cus_id),Toast.LENGTH_LONG).show();
                           // moviedb.get_cust_id_user(user_name);
                    Cursor cursor=moviedb.check_pass(user_name);
                   // boolean checked = moviedb.check(user_name,Integer.parseInt(pass));

                    String pass_db=String.valueOf(cursor.getInt(0));
                    if (pass_db.equals(pass)) {
                        Intent i=new Intent(log_in.this,show_products.class);
                        i.putExtra("cust_id",String.valueOf(cus_id));
                        i.putExtra("user_mail",user_name);
                        startActivity(i);
                    }
                   else
                      Toast.makeText(getApplicationContext(),"user name or password are wrong please enter the data again", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"you have to enter the data first", Toast.LENGTH_LONG).show();
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sign_up=new Intent(log_in.this,sign_up.class);
                startActivity(sign_up);
            }
        });
    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        manage_ref();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        manage_ref();
    }
    private void manage_ref()
    {
        if(rem_user.isChecked())
        {
            editor.putString(key_user,user_et.getText().toString().trim());
            editor.putString(key_pass,pass_et.getText().toString().trim());
            editor.putBoolean(kye_rem,true);
            editor.apply();
        }
        else
        {
            editor.putBoolean(kye_rem,false);
            editor.remove(key_pass);
            editor.remove(key_user);
            editor.apply();
        }

    }
}
