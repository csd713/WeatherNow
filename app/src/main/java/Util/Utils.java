package Util;

/**
 * Created by Chiru on 10/1/2016.
 */

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Put all static variables referenced in the code in this class
 * to organize things
 */
public class Utils {
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    public static final String ICON_URL = "http://openweathermap.org/img/w/";

    public static JSONObject getObject(String tagName, JSONObject jsonObject) throws JSONException {
        JSONObject jObj = jsonObject.getJSONObject(tagName);
        return jObj;
    }
    public static String getString(String tagName, JSONObject jsonObject)throws JSONException{
        return jsonObject.getString(tagName);
    }
    public static float getFloat(String tagName, JSONObject jsonObject)throws JSONException{
        return (float) jsonObject.getDouble(tagName);
    }

    public static float getDouble(String tagName, JSONObject jsonObject)throws JSONException{
        return (float) jsonObject.getDouble(tagName);
    }
    public static int getInt(String tagName, JSONObject jsonObject)throws JSONException{
        return jsonObject.getInt(tagName);
    }
}
