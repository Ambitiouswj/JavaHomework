package homework.work.item_5;

import java.awt.Desktop;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadPicture {
    private static String pathName = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F4%2F57844ad461ab6.jpg&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671798369&t=fdfb7e5e6e0719284e8aba4d6d8418fb";

    public static void startDownload() {
        (new DownloadThread(pathName, new FinishDownload() {
            public void finishDownload(long second) {
                System.out.println("下载完成！");
                try {
                    Desktop.getDesktop().open(new File("image_1.jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        })).start();
    }
}

class DownloadThread extends Thread {
    private String path;
    private FinishDownload finishDownload;

    public DownloadThread(String path, FinishDownload finishDownload) {
        this.path = path;
        this.finishDownload = finishDownload;
    }

    public void run() {
        System.out.println("开始下载");
        try {
            long startTime = System.currentTimeMillis();
            URL url = new URL(this.path);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(5000);
            InputStream is = connection.getInputStream();
            byte[] data = this.read(is);
            File file = new File("image_1.jpg");
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(data);
            outputStream.close();
            this.finishDownload.finishDownload(System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] read(InputStream in) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[10240];
        int len;
        while((len = in.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        in.close();
        return outputStream.toByteArray();
    }
}