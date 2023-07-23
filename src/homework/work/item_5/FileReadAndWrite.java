package homework.work.item_5;

import java.io.*;

public class FileReadAndWrite {
    public static void readAndWrite() {
        String inpath = "D:\\JavaProject\\JavaHomeWork\\src\\homework\\work\\item_5\\input.txt";
        String outpath = "D:\\JavaProject\\JavaHomeWork\\src\\homework\\work\\item_5\\output.txt";
        try {
            FileReader reader = new FileReader(inpath);
            FileWriter writer = new FileWriter(outpath);
            BufferedReader br = new BufferedReader(reader);
            BufferedWriter bw = new BufferedWriter(writer);
            new File("output");
            System.out.println("开始读写！");

            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                bw.write(str + "\n");
                bw.flush();
            }
            System.out.println("文件读写结束！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
