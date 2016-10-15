package data;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by Chiru on 14-Oct-16.
 */

public class CityPreference {

    SharedPreferences prefs;

    public CityPreference(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);

    }

    public String getCity(){
        return prefs.getString("city", "Syracuse,US");
    }

    public void setCity(String city){
        prefs.edit().putString("city", city).commit();
    }
}


