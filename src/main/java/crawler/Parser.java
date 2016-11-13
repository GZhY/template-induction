package crawler;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

/**
 * This is a XXX class.
 * What is the function of this class?
 *
 * @author GZhY
 * @version 1.0
 */
public class Parser {

    public static Document url2Document(String url) {
        try {
            return Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36")
                    .timeout(5000).get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Document html2Document(String html, String baseUri) {
        return Jsoup.parse(html, baseUri);
    }

    public static Document html2Document(String html) {
        return Jsoup.parse(html);
    }

    public static Document filePath2Document(String filePath, String baseUri){
        try {
            return Jsoup.parse(new File(filePath), "UTF-8", baseUri);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
