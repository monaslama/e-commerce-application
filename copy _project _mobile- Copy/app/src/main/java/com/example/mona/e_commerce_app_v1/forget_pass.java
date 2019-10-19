package com.example.mona.e_commerce_app_v1;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class forget_pass extends AppCompatActivity {

    private EditText email;
    private Button reset_pass;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        email=(EditText)findViewById(R.id.email);
        reset_pass=(Button)findViewById(R.id.reset);
        FirebaseApp.initializeApp(this);
        final dp_helper_1 myclass=new dp_helper_1(this);
       // FirebaseAuth auth = FirebaseAuth.getInstance();
       //firebaseAuth = FirebaseAuth.getInstance();
        reset_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cust_name=email.getText().toString();
                // boolean checked = moviedb.check(user_name,Integer.parseInt(pass));

                String user_mail=getIntent().getExtras().getString("user_mail");
                Cursor cursor=myclass.check_cut_name(cust_name );
                //Toast.makeText(getApplicationContext(),cursor.getString(0),Toast.LENGTH_LONG).show();
               String user_mail_db=cursor.getString(0);



                //cursor.getString(0).equals(user_name)
                if (user_mail_db.equals(user_mail)) {
                    Intent i=new Intent(forget_pass.this,update_password_cust.class);
                    int cus_id=myclass.get_cust_id(cust_name);
                    i.putExtra("user_mail",getIntent().getExtras().getString("user_mail"));
                    i.putExtra("cust_name",cust_name);
                    //i.putExtra("cust_id",String.valueOf(cus_id));
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(forget_pass.this, "cust_name is false", Toast.LENGTH_SHORT).show();
                }

                /*String useremail=email.getText().toString().trim();
                if(useremail.equals(""))
                {
                    Toast.makeText(forget_pass.this, "you need to enter your registered email id", Toast.LENGTH_SHORT).show();

                }
                else
                {
                   firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           if(task.isSuccessful())
                           {
                               Toast.makeText(forget_pass.this, "password to reset password sent", Toast.LENGTH_SHORT).show();
                               // go to another activity
                           }
                           else
                           {
                               Toast.makeText(forget_pass.this, "erorr in sending reset password ", Toast.LENGTH_SHORT).show();
                           }

                       }
                   });

                }*/


            }
        });
        Button back=(Button)findViewById(R.id.back_for_pass);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(forget_pass.this,log_in.class);
                //i.putExtra("cust_id",String.valueOf(cus_id));
                startActivity(i);
            }
        });
    }
}
