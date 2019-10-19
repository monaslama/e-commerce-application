package com.example.mona.e_commerce_app_v1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class continue_signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_signup);

       // final String[] b_date = new String[1];
        final dp_helper_1 moviedb1=new dp_helper_1(getApplicationContext());
        Button submit=(Button)findViewById(R.id.button5);
        Button back=(Button)findViewById(R.id.button6);
        final TextView mydate=(TextView) findViewById(R.id.my_date);

        CalendarView celender=(CalendarView)findViewById(R.id.calendarView);
        // long b_date= celender.getDate();
        celender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

               /* Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),String.valueOf(i1),Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),String.valueOf(i2),Toast.LENGTH_LONG).show();*/
                String  b_date = i2 + "/"+ (i1+1) + "/" + i;
                mydate.setText(b_date);
            }
        });

       // Toast.makeText(getApplicationContext(),mydate.getText().toString(),Toast.LENGTH_LONG).show();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=(getIntent().getExtras().getString("name"));
                String email=(getIntent().getExtras().getString("email"));
                String pass=(getIntent().getExtras().getString("pass"));
                String gen=(getIntent().getExtras().getString("gen"));
                String job_cust=(getIntent().getExtras().getString("job_cust"));
                moviedb1.insert_customr(name,email,pass,gen,mydate.getText().toString(),job_cust);
                Intent i=new Intent(continue_signup.this,show_products.class);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(continue_signup.this,sign_up.class);
                startActivity(i);
            }
        });
    }
}
