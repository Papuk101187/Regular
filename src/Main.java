import Parse.User;
import ParseFile.UserParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) throws IOException {

        String string = "programmer:vasia@123,programmer:vasia,vasia@1234,vasia,vasia:@trulala";
        List<User> users;
        UserParser userParser = new UserParser();
        users = userParser.parse(string);

        getUsers(users);

    }

    private static void getUsers(List<User> users) {
        int count = 1;
        for (User user : users) {
            System.out.println("№ " + count + " :");
            System.out.println("-------------------------------");
            System.out.println("nickname = " + user.nickname + " , "
                    + "username = " + user.username + " , "
                    + "password = " + user.password);
            System.out.println("-------------------------------");
            count++;
        }
    }


}



