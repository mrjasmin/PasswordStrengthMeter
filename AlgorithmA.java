package passwordStrengthMeter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is a concrete class that implements the Algorithm interface. This class
 * uses regular expressions to determinate the strength of a password.
 *
 * @author Jasmin Krhan 
 */
public class AlgorithmA implements Algorithm {

    String[] patterns = {"^.*(?=.{8,}).*$", "^.*(?=.*[!#$%&?\"]).*$", "^.*(?=.*[0-9]).*$", "^.*(?=.*[A-Z]).*$"};

    int count;

    @Override
    public int checkPassWord(String password) {

        count = 0;

        for (String str : patterns) {

            Pattern p = Pattern.compile(str);
            Matcher m = p.matcher(password);

            if (m.find()) {
                System.out.println(password + " matches pattern " + p.toString());
                ++count;
            }

        }

        return count;

    }

}
