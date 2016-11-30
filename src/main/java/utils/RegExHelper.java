package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is a XXX class.
 * What is the function of this class?
 *
 * @author GZhY
 * @version 1.0
 */
public class RegExHelper {

    /**
     * Parse regular expression with groupID.
     * @param text text to parse
     * @param regEx regular expression
     * @param groupID group ID, which defaults to 1.
     * @return the groupID th data of first match
     */
    public static String parseRegEx(String text, String regEx, int groupID) {
        if (regEx == null || text == null) return null;
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            if (matcher.groupCount() >= groupID)
                return matcher.group(groupID);
            else return matcher.group();
        } else return null;
    }

    public static String parseRegEx(String text, String regEx) {
        return parseRegEx(text, regEx, 1);
    }

}


