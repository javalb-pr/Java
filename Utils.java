package by.gsu.pms;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {

    private static final String URL_FOR_XML = "http://api.openweathermap.org/data/2.5/weather?q=Los+Angeles,US&mode=json&appid=341d98bd749d2ec539e53f1ccc7a2b39";
    public static final String FILE_PATH = "src/main/resources/2in.json";

    public static void downloadFile() throws IOException {
        URL url = new URL(URL_FOR_XML);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(FILE_PATH);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

    public static String pathToString(Path path){
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(path)){
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String FahrenheitToCelsius(String temp){
        double result = (Double.parseDouble(temp) - 32) / 1.8;
        return String.valueOf(Math.round(result * 100.0) / 100.0);
    }

    public static String degToStringDirection(int deg){
        switch (deg){
            case 0: return "N";
            case 90: return "E";
            case 180: return "S";
            case 270: return "W";
            case 360: return "N";
            default: {
                if (deg > 0 && deg < 90) return "NE";
                else if (deg > 90 && deg < 180) return "SE";
                else if (deg > 180 && deg < 270) return "SW";
                else if (deg > 270 && deg < 360) return "NW";
            }
        }
        return null;
    }

    public static void writeStringInFile(File file, String string) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(file, "UTF-8");
        writer.println(string);
        writer.close();
    }
}
