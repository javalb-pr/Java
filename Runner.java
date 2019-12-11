package by.gsu.pms;

import com.google.gson.*;

import java.io.*;
import java.nio.file.Path;

import static by.gsu.pms.JsonModel.*;
import static by.gsu.pms.Utils.*;

public class Runner {
    public static void main(String[] args) throws IOException {
        Utils.downloadFile();
        Path jsonFilePath = new File(FILE_PATH).toPath();
        JsonObject root = new JsonParser().parse(pathToString(jsonFilePath)).getAsJsonObject();
        String city = root.get(NAME_TAG).toString().replaceAll("\"", "");
        String countryCode = root.get(CODE_TAG).toString().replaceAll("\"", "");
        JsonObject weather = root.getAsJsonArray(WEATHER_TAG).get(0).getAsJsonObject();
        final String urlPrefix = "http://openweathermap.org/img/w/";
        final String urlPostfix = ".png";
        String iconUrl = urlPrefix + weather.get(WEATHER_ICON_TAG).toString().replaceAll("\"", "") + urlPostfix;
        String briefWeatherDescription = weather.get(MAIN_TAG).toString().replaceAll("\"", "");
        String fullyWeatherDescription = weather.get(WEATHER_DESCRIPTION_TAG).toString().replaceAll("\"", "");
        JsonObject main = root.getAsJsonObject(MAIN_TAG);
        String currentTemp = FahrenheitToCelsius(main.get(MAIN_TEMPERATURE_TAG).toString().replaceAll("\"", ""));
        String pressure = main.get(MAIN_PRESSURE_TAG).toString();
        String minTemp = FahrenheitToCelsius(main.get(MAIN_MIN_TEMPERATURE_TAG).toString());
        String maxTemp = FahrenheitToCelsius(main.get(MAIN_MAX_TEMPERATURE_TAG).toString());
        JsonObject wind = root.getAsJsonObject(WIND_TAG);
        String windsSpeed = wind.get(WIND_SPEED_TAG).toString();
        String windsDirection = degToStringDirection(wind.get(WIND_DEG_TAG).getAsInt());
        String windInView = windsSpeed + " m/s " + windsDirection;
        String clouds = root.getAsJsonObject(CLOUDS_TAG).get(CLOUDS_ALL_TAG).toString();

        String htmlBeforeCard = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Weather widget</title>\n" +
                "    <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\" style=\"max-height: 2800px\">\n" +
                "    <div class=\"card border-primary mt-5 ml-5\" style=\"max-width: 18rem;\">\n";
        String cardHeader = "<div class=\"card-header bg-transparent border-primary text-primary\">" + city +
                " <span class=\"text-muted\">" + countryCode + "</span></div>";
        String cardBody = "<div class=\"card-body text-info\">\n" +
                "            <h5 class=\"card-title\">" + currentTemp + " C° " + briefWeatherDescription + "</h5>\n" +
                "            <p class=\"card-text\">\n" +
                "                may be " + minTemp + " C° - " + maxTemp + "C°\n" +
                "                <br>\n" +
                "                " + fullyWeatherDescription + "\n" +
                "                <img src=\"" + iconUrl + "\" alt=\"#\">\n" +
                "                <br>\n" +
                "                cloudiness: " + clouds + "%\n" +
                "                <br>\n" +
                "                pressure: " + pressure + " mmHg\n" +
                "            </p>\n" +
                "        </div>";
        String cardFooter = "        <div class=\"card-footer bg-transparent border-primary text-primary\">Wind: " + windInView + "</div>\n";
        String htmlAfterCard = "    </div>\n" +
                "</div>\n" +
                "<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n" +
                "</body>\n" +
                "</html>";
        String finalHtml = htmlBeforeCard + cardHeader + cardBody + cardFooter + htmlAfterCard;
        writeStringInFile(new File("index.html"), finalHtml);
    }
}
