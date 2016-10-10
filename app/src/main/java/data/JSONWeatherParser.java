package data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Util.Utils;
import model.Place;
import model.Weather;

/**
 * Created by Chiru on 10/2/2016.
 * This will fetch weather data from WeatherHttpClient class
 *  Connects to the API
 */

public class JSONWeatherParser {

    public static Weather getWeather(String data){

        Weather weather = new Weather();
        //Create JsonObject from data

        try {
            JSONObject jsonObject = new JSONObject(data);

            Place place = new Place();

            JSONObject coordObj = Utils.getObject("coord", jsonObject);
            place.setLat(Utils.getFloat("lat",coordObj));
            place.setLon(Utils.getFloat("lon",coordObj));

            //get the sys object

            JSONObject sysObj = Utils.getObject("sys",jsonObject);

            place.setCountry(Utils.getString("country", sysObj));
            place.setSunrise(Utils.getInt("sunrise",sysObj));
            place.setSunset(Utils.getInt("sunset",sysObj));

            place.setLastUpdate(Utils.getInt("dt", jsonObject));
            place.setCity(Utils.getString("name",jsonObject));

            weather.place = place;

            //get weather info from JSON object

            JSONArray jsonArray = jsonObject.getJSONArray("weather");

            JSONObject jsonWeather = jsonArray.getJSONObject(0);
            weather.currentCondition.setWeatherID(Utils.getInt("id",jsonWeather));
            weather.currentCondition.setDescription(Utils.getString("description",jsonWeather));
            weather.currentCondition.setCondition(Utils.getString("main",jsonWeather));
            weather.currentCondition.setIcon(Utils.getString("icon",jsonWeather));

            //get wind data

            JSONObject windObj = Utils.getObject("wind",jsonObject);
            weather.wind.setSpeed(Utils.getFloat("speed", windObj));
            weather.wind.setDeg(Utils.getFloat("deg", windObj));

            JSONObject cloudObj = Utils.getObject("clouds",jsonObject);
            weather.clouds.setPrecepitation(Utils.getInt("all", cloudObj));

            return weather;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}