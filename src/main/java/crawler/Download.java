package crawler;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This is a download URL class.
 * Download URL and get the html.
 *
 * @author GZhY
 * @version 1.0
 */
public class Download {

    public static String downloadURL(URL url){
        String html = null;
        // TODO: 2016/11/8 增加爬虫代码
        return html;
    }

    public static String downloadURL(String strURL) {
        try {
            URL url = new URL(strURL);
            return downloadURL(url);
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
