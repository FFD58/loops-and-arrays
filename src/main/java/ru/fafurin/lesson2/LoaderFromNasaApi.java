package ru.fafurin.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoaderFromNasaApi {
    // uri NASA API astronomy picture of the day
    private static final String NASA_API = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";

    // Возвращает строку из содержимого веб-страницы с адресом ulr
    public static String webPageToString(String startDate, String endDate) {
        // даты вводить в формате гггг-мм-дд
        String dates = String.format("&start_date=%s&end_date=%s", startDate, endDate);
        String url = NASA_API + dates;
        String result = "";
        try {
            StringBuilder res = new StringBuilder();
            String line;
            URLConnection urlConnection = new URL(url).openConnection();
            try (InputStream is = urlConnection.getInputStream(); BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                while ((line = br.readLine()) != null) {
                    res.append(line);
                }
            }
            result = res.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void getFileFromString(String string) throws IOException {
        boolean isExit = true;
        while (isExit) {
            // проверяем есть ли в строке url
            if (string.contains("\"url\"")) {
                // получаем ссылку на изображение
                String url = string.substring(string.indexOf("\"url\"") + 7, string.indexOf("}") - 1);
                // из ссылки получаем название файла
                String filename = url.substring(url.lastIndexOf("/") + 1);
                // создаем папку в директории проекта
                String path = System.getProperty("user.dir") + "\\images";
                Files.createDirectories(Paths.get(path));
                // проверяем картинку ли мы закачиваем
                if (filename.contains("jpg")) {
                    try (InputStream in = new URL(url).openStream()) {
                        Files.copy(in, Paths.get("images/" + filename));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Image " + filename + " saved.");
                // удаляем из строки блок с загруженной картинкой
                String replace = string.substring(string.indexOf("{"), string.indexOf("}") + 2);
                string = string.replace(replace, "");

            } else isExit = false;
        }
        System.out.println("Images downloaded...");
    }


}
