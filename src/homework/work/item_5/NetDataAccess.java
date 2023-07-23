package homework.work.item_5;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

public class NetDataAccess {
    public static void getHttpResult(String uri, BackForResult bfr) {
        new Thread() {
            public void run() {
                try {
                    URL url = new URL(uri);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream is = new GZIPInputStream(connection.getInputStream());
                    String res = "";
                    byte[] buffer= new byte[10 * 1024];
                    int len;
                    while ((len = is.read(buffer)) != -1) {
                        res += new String(buffer, 0, len, "utf-8");
                    }
                    is.close();
                    bfr.back(res);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
