package com.example.contactapplicatiion;

import java.io.Serializable;

public class ContactPojo implements Serializable {

    private String name;
    private String phoneNo;
    private String address;
    private String emailId;
    public void setName(String name)
    {
        this.name=name;
    }
    public void setPhoneNo(String phoneNo)
    {
        this.phoneNo=phoneNo;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    public void setMailid(String emailId)
    {
        this.emailId=emailId;
    }

    public String getName()
    {
        return name;
    }
    public String getPhoneNo()
    {
        return phoneNo;
    }
    public String getAddress()
    {
        return address;
    }
    public String getEmailId()
    {
        return emailId;
    }

}
