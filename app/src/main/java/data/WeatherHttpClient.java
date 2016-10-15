package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Util.Utils;

/**
 * Created by Chiru on 10/1/2016.
 *
 * This is the heart of the application
 * We are going to parse/get the JSON object from web/API
 * and get info we need.
 */

public class WeatherHttpClient {
    public String getWeatherData(String place){

        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try {
            connection = (HttpURLConnection) (new URL(Utils.BASE_URL + place + Utils.APP_ID)).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();
            //Read the response we are getting from the URL

            StringBuffer stringBuffer = new StringBuffer();
            inputStream = connection.getInputStream();

            //This will have all the data read from response
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while((line = bufferedReader.readLine()) !=  null){
                //breaks into line by line
                stringBuffer.append(line + "\r\n");
            }
            inputStream.close();
            connection.disconnect();
            return stringBuffer.toString();

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}