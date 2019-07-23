package com.example.contactapplicatiion;

import android.content.Intent;

import java.util.Comparator;
import java.util.List;

public class ListComparator  implements  Comparator<ContactPojo> {

    @Override
    public int compare(ContactPojo contactPojo, ContactPojo t1) {
        return contactPojo.getName().compareTo(t1.getName());
    }


    public String listComparator(String number, List<ContactPojo> list) {
        if (list.size()== 0) {
            return "notContains";
        } else {
            for (ContactPojo contactPojo : list) {
                if (number.equals(contactPojo.getPhoneNo())) {
                    return "contains";
                } else {
                    return "notContains";
                }
            }
            return null;
        }
    }


}
