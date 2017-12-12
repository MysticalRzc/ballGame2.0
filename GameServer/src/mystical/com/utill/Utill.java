package mystical.com.utill;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mystical on 2017/12/12.
 */
public class Utill {
    private final static String regEx = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

    public static boolean isAddress(String address) {
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(address);
        if (m.find())
            return true;
        else
            return false;
    }

    public static boolean isPort(Object port) {
        try {
            int p = Integer.parseInt(port.toString());
            if (p < 65535 && p > 0)
                return true;
            return false;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
