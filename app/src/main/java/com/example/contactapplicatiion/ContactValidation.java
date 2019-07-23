package com.example.contactapplicatiion;

public class ContactValidation{

    String emailvalidator = "^[a-zA-z]+[a-zA-z0-9-!#.$%&*+?><_]+@+([a-zA-z0-9])+\\.[a-zA-z]{2,4}$";
    public int namecheck(String username) {
        if (username.length() < 3) {
            return 1;
        }
        else {
            return 0;
        }
    }
        public int phoneNumberCheck(String phoneNo) {
            if (phoneNo.length() < 10 || phoneNo.length() > 10) {
                return 1;
            } else {
                return 0;
            }
        }
        public int addrssCheck(String address) {
            if (address.length() == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        public int mailidCheck(String mailid) {
            if (!(mailid.matches(emailvalidator))) {
                return 1;
            } else {
                return 0;
            }
        }



    }


