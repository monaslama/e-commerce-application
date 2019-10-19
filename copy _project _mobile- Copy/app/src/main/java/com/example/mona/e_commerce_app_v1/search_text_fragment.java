package com.example.mona.e_commerce_app_v1;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class search_text_fragment extends Fragment {


    public search_text_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root_view=inflater.inflate(R.layout.fragment_search_text_fragment, container, false);
        final EditText pro_name=(EditText)root_view.findViewById(R.id.pro_name_ed);
        ListView mylist=(ListView)root_view.findViewById(R.id.my_search_t);
        final ArrayAdapter<String> myadapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1);
        mylist.setAdapter(myadapter);
        final dp_helper_1 myclass=new dp_helper_1(getActivity());
       // final String cust_id=(getIntent().getExtras().getString("cust_id"));
        Button add=(Button)root_view.findViewById(R.id.button15);
        add.setOnClickListener(new View.OnClickListener() {
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
        return inflater.inflate(R.layout.fragment_search_text_fragment, container, false);
    }

}
