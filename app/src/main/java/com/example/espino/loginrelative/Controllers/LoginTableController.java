package com.example.espino.loginrelative.Controllers;


public class LoginTableController implements ILoginMvc {
    public static final int OK = 0;
    public static final int PASSWD_DIGIT = 1;
    public static final int PASSWD_CASE =2;
    public static final int PASSWD_LENGTH = 3;

    public int validateCredentials(String user, String passwd){
        int res = OK;

        if(!passwd.matches("(.*)\\d+(.*)"))
            res = PASSWD_DIGIT;
        else if(!passwd.matches("(.*)\\p{Lower}+(.*)") || !passwd.matches("(.*)\\p{Upper}+(.*)"))
            res = PASSWD_CASE;
        else if(passwd.length() > 8)
            res = PASSWD_LENGTH;

        return res;
    }
}
