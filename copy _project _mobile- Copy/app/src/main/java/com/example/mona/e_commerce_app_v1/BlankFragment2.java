package com.example.mona.e_commerce_app_v1;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {


    EditText mytext;
    Cursor matched_employees;
    int voice_code=1;
    ListView mylist;
    dp_helper_1 myhelper;
    public BlankFragment2() {
        // Required empty public constructor
    }
//voice fragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root_view=inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        myhelper=new dp_helper_1(getActivity());
        mylist =(ListView)root_view.findViewById(R.id.mylist_search_v);
        mytext=(EditText)root_view.findViewById(R.id.editText7);
        ImageButton voicebtn=(ImageButton)root_view.findViewById(R.id.imageButton);
        voicebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                startActivityForResult(i,voice_code);
            }
        });
         return  root_view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==voice_code&&resultCode==getActivity().RESULT_OK)
        {
            ArrayList <String>text=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            mytext.setText(text.get(0));
            ArrayAdapter<String>employees_adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1);
            mylist.setAdapter(employees_adapter);
            Cursor matched_emp=myhelper.get_products_search(text.get(0));
            if(matched_emp!=null)
            {
                while (!matched_emp.isAfterLast())
                {
                    employees_adapter.add(matched_emp.getString(0));
                    matched_emp.moveToNext();
                }
            }
            else
                Toast.makeText(getActivity(),"no matched employee",Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
