package expmanager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {
    public String getAmountConverted(String from, String to, String amount){
        try {
            String key = "MTrrf5q35fQ08qKh6IBzLIG1zdSglQNf";
            URL url = new URL("https://api.apilayer.com/exchangerates_data/convert?apikey="+key+"&from="+from+"&to="+to+"&amount="+amount);


            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");


            connection.connect();

            int responseCode = connection.getResponseCode();

            if(responseCode != 200) throw new RuntimeException("HttpResponseCode: " + responseCode);

            StringBuilder informationString = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) informationString.append(scanner.nextLine());

            scanner.close();


            JSONParser jsonParser = new JSONParser();
            JSONObject dataObject = (JSONObject) jsonParser.parse(String.valueOf(informationString));

            return dataObject.get("result").toString();


        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
