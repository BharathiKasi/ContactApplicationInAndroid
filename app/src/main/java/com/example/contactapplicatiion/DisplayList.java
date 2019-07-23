package com.example.contactapplicatiion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DisplayList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<ContactPojo> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        if(getIntent().hasExtra("list")) {
            Bundle bundle = getIntent().getExtras();
            try {
                if (bundle != null) {
                    list = (ArrayList<ContactPojo>) bundle.getSerializable("list");
                    if(list.size()==0)
                    {
                        Toast.makeText(DisplayList.this,"your contact list is empty ",Toast.LENGTH_SHORT).show();
                    }
                }
            }
            catch (Exception e)
            {
             Toast.makeText(DisplayList.this,"you got error"+e, Toast.LENGTH_SHORT).show();
            }
        }
        recyclerView=findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter=new RecyclerAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
