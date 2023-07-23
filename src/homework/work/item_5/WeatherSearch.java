package homework.work.item_5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import homework.InputErrorCheck;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.zip.GZIPInputStream;

public class WeatherSearch {
    private static final String KEY = "258a742008cb4876b1e187a3b0fb02c3";
    private static final String weatherAPI = "https://devapi.qweather.com/v7/weather/now?";
    private static final String cityAPI = "https://geoapi.qweather.com/v2/city/lookup?";

    public static void showWeather() {
        while (true) {
            System.out.print("请输入城市名（退出请输入0）：");
            String name = InputErrorCheck.inputStringErrorCheck();
            if (name.equals("0")) break;
            String codeName = "";
            try {
                codeName = URLEncoder.encode(name, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }

            String cityID = getCityCode(codeName);
            String info = getInfo(weatherAPI + "key=" + KEY + "&location=" + cityID);
            JSONObject jsonObject = JSON.parseObject(info);
            String s = jsonObject.getString("code");
            if (!(s.equals("200"))) {
                System.out.println("城市输入有误");
                continue;
            }
            JSONObject now = (JSONObject)jsonObject.get("now");
            String temp = now.getString("temp");
            String feelTemp = now.getString("feelsLike");
            String text = now.getString("text");
            String windDir = now.getString("windDir");
            String preessure = now.getString("pressure");
            String date = now.getString("obsTime").substring(0, 16);
            System.out.println("当前城市：" + name);
            System.out.println("天气：" + text);
            System.out.println("更新时间：" + date);
            System.out.println("温度：" + temp + "℃");
            System.out.println("体感温度：" + feelTemp + "℃");
            System.out.println("风向：" + windDir);
            System.out.println("气压：" + preessure);
        }
    }

    public static String getCityCode(String name) {
        String urlString = cityAPI + "key=" + KEY + "&location=" + name;
        String info = getInfo(urlString);
        JSONObject json = JSON.parseObject(info);
        JSONArray locations = (JSONArray)json.get("location");
        JSONObject location = locations.getJSONObject(0);
        String cityCode = location.getString("id");
        return cityCode;
    }

    public static String getInfo(String urlString) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setConnectTimeout(5000);
            InputStream is = urlConnection.getInputStream();
            GZIPInputStream gzipInputStream = new GZIPInputStream(is);
            InputStreamReader reader = new InputStreamReader(gzipInputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null) { sb.append(line); }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}