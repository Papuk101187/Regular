package ParseFile;

import Parse.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserParser {
    ArrayList<User> usersbox = new ArrayList<>();


    public User Userparse(String user) {
        Pattern pattern = Pattern.compile("(?:(\\w+):)?(\\w+)(?:(@)?(\\w+)?)");
        Matcher matcher = pattern.matcher(user);
        if (matcher.matches()) {
            return buildUser(matcher);
        }

        return null;
    }

    private User buildUser(Matcher user) {
        String nickname = user.group(1);
        String username = user.group(2);
        String password = user.group(4);
        return rule(nickname, username, password);
    }

    private User rule(String nickname, String username, String password) {

        if (nickname == null) {
            nickname = username;
        }
        return new User(nickname, username, password);

    }


    public List<User> parse(String userstring) {

        for (String users : userstring.split(",")) {
            ;
            User user = (Userparse(users));
            if (user != null) {
                usersbox.add(user);
            }

        }

        return usersbox;
    }


}
