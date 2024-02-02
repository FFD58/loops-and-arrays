package ru.fafurin.lesson3;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class CurrencyLoader {
    private String url;

    private final String USD = "R01235";
    private final String EUR = "R01239";

    private String result;

    // <Valute ID="R01235"> - доллар США

    // формат дат дд/мм/гггг
    public void setUrl(String day, String month, String year) {
        this.url = String.format("https://www.cbr.ru/scripts/XML_daily.asp?date_req=%s/%s/%s", day, month, year);
    }

    public void getDollarQuotes(String filename, String day, String month, String year) {
        setUrl(day, month, year);
        String source = downloadWebPage();
        String result = this.formatString(source, this.USD);
        if (result.contains("Dollar quote not found!")) {
            result = String.format("%s.%s.%s: no data available", day, month, year);
            this.setStringToFile(filename, result);
            System.out.printf("Dollar quote for %s.%s.%s not found!\n", day, month, year);
        } else {
            this.setStringToFile(filename, result);
            System.out.printf("Dollar quote for %s.%s.%s successfully saved to file %s\n", day, month, year, filename);
        }
    }

    private String downloadWebPage() {
        StringBuilder res = new StringBuilder();
        try {
            String line;
            URLConnection urlConnection = new URL(this.url).openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return res.toString();
    }

    private String formatString(String source, String currentValueId) {
        if (source.contains(currentValueId)) {
            String date = source.substring(source.indexOf("Date=") + 6, source.indexOf("Date=") + 16);
            int startIndex = source.indexOf(currentValueId);
            String value = source.substring(startIndex + 104, startIndex + 111);
            return date + ": " + value;
        } else return "Dollar quote not found!";
    }

    private void setStringToFile(String filename, String source) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(source);
            bufferWriter.write("\n");
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
