package crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This is a download URL class.
 * Download URL and get the html.
 *
 * @author GZhY
 * @version 1.0
 */
public class Download {

    public static String downloadURL(String strURL) {
        try {
            URL url = new URL(strURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.connect();
            int state = con.getResponseCode();
            if (state == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line, result = "";
                while ((line = in.readLine()) != null)
                    result += line;
                return result;
            }
        } catch (IOException e) {
            System.out.println("download: " + strURL + "失败！");
            e.printStackTrace();
        }
        return null;
    }
}
