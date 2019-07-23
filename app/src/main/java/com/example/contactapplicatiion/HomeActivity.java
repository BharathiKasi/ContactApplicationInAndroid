package com.example.contactapplicatiion;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    Button create,display;
    private static int REQUEST_CODE=1;
    public  List<ContactPojo> contactList=new ArrayList<>();
    ContactPojo contactPojo;
    ListComparator listComparator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        create=(Button) findViewById(R.id.create_contact_button);
        display=(Button) findViewById(R.id.show_contact_button);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(HomeActivity.this,CreateContact.class);
               startActivityForResult(intent,REQUEST_CODE);

            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(contactList,listComparator);
              Intent intent=new Intent(HomeActivity.this,DisplayList.class);
              Bundle bundle=new Bundle();
              bundle.putSerializable("list",(Serializable)contactList);
              intent.putExtras(bundle);
              startActivity(intent);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE)
        {
            if(resultCode==RESULT_OK)
            {
                if(data!=null) {
                    String username = data.getStringExtra("username");
                    String number = data.getStringExtra("number");
                    String address = data.getStringExtra("address");
                    String mailid = data.getStringExtra("mailId");
                    if(listComparator==null)
                    {
                        listComparator=new ListComparator();
                    }
                    String s = listComparator.listComparator(number,contactList);
                    if (s.equals("contains")) {
                        Toast.makeText(HomeActivity.this, "this phone number is already exist", Toast.LENGTH_SHORT).show();
                    } else {
                        contactPojo = new ContactPojo();
                        contactPojo.setName(username);
                        contactPojo.setPhoneNo(number);
                        contactPojo.setAddress(address);
                        contactPojo.setMailid(mailid);
                        contactList.add(contactPojo);
                        Toast.makeText(getApplicationContext(), "your contact saved ", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        }
    }
}
