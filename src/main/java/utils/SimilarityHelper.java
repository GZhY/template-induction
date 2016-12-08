package utils;

/**
 * This is a XXX class.
 * What is the function of this class?
 *
 * @author GZhY
 * @version 1.0
 */
public class SimilarityHelper {

    public static double pathSimilarity(String path1, String path2) {
        if (path1 == null || path2 == null) return 0;
        String s = findCommmonPrefix(path1, path2);
        if ("".equals(s)) return 0;
        //s.nodeCount/path1.nodeCount
        return s.split(">").length / path1.split(">").length;
    }

    public static String findCommmonPrefix(String str1, String str2) {
        int index = 0;
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) index++;
            else break;
        }
        if (index > 0 && str1.charAt(index - 1) == '>') index--;
        return str1.substring(0, index);
    }
}
