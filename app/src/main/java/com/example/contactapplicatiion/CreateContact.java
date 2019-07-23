package com.example.contactapplicatiion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateContact extends AppCompatActivity {
   EditText firstName,phoneNo,address,mailid;
    Button create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        create=(Button) findViewById(R.id.create_contact);
        firstName=(EditText)findViewById(R.id.username);
        phoneNo=(EditText)findViewById(R.id.phoneNo);
        address=(EditText)findViewById(R.id.address);
        mailid=(EditText) findViewById(R.id.mailId);
        //ActionBar actionBar=getSupportActionBar();
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactValidation contactValidation=new ContactValidation();
                int getusername=contactValidation.namecheck(firstName.getText().toString().trim());
                int getphoneNo=contactValidation.phoneNumberCheck(phoneNo.getText().toString().trim());
                int getAddress =contactValidation.addrssCheck(address.getText().toString().trim());
                int getMailId=contactValidation.mailidCheck(mailid.getText().toString().trim());
                if(getusername==1)
                {
                    Toast.makeText(getApplicationContext(),"please enter the valid name ",Toast.LENGTH_SHORT).show();
                }
               else  if(getphoneNo==1)
                {
                    Toast.makeText(getApplicationContext(),"please enter the valid phone number",Toast.LENGTH_SHORT).show();
                }
                else  if(getAddress==1)
                {
                    Toast.makeText(getApplicationContext(),"please enter the valid city",Toast.LENGTH_SHORT).show();
                }
                else if(getMailId==1)
                {
                    Toast.makeText(getApplicationContext(),"please enter the vlaid mail address",Toast.LENGTH_SHORT).show();
                }
                if(getusername==0&&getAddress==0&&getphoneNo==0&&getMailId==0)
                {

                    Toast.makeText(getApplicationContext(),"verified",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent();
                    intent.putExtra("username",firstName.getText().toString().trim());
                    intent.putExtra("number",phoneNo.getText().toString().trim());
                    intent.putExtra("address",address.getText().toString().trim());
                    intent.putExtra("mailId",mailid.getText().toString().trim());
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

}
