package pl.bartlomiej_swies.model.weatherData;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class WeatherData {

    private JSONObject jsonObject;

    public WeatherData(String jsonString) {
        this.jsonObject = new JSONObject(jsonString);
    }

    protected String getStringValueFromJsonObject(String object, String key) {
        String stringValue = jsonObject.getJSONObject(object).getString(key);
        return stringValue;
    }

    protected double getDoubleValueFromJsonObject(String object, String key) {
        double doubleValue = jsonObject.getJSONObject(object).getDouble(key);
        return doubleValue;
    }

    protected int getIntegerValueFromJsonObject(String object, String key) {
        int integerValue = jsonObject.getJSONObject(object).getInt(key);
        return integerValue;
    }

    protected String getStringValueFromJsonArray(String object, String key) {
        JSONArray jsonArray = jsonObject.getJSONArray(object);
        for(int i = 0; i < jsonArray.length(); i++){
            String stringValue = jsonArray.getJSONObject(i).getString(key);
            return stringValue;
        }
        return null;
    }

    protected Double getDoubleValueFromJsonArray(String object, String key) {
        JSONArray jsonArray = jsonObject.getJSONArray(object);
        for(int i = 0; i < jsonArray.length(); i++){
            double doubleValue = jsonArray.getJSONObject(i).getDouble(key);
            return doubleValue;
        }
        return null;
    }

    protected Integer getIntegerValueFromJsonArray(String object, String key) {
        JSONArray jsonArray = jsonObject.getJSONArray(object);
        for(int i = 0; i < jsonArray.length(); i++){
            int value = jsonArray.getJSONObject(i).getInt(key);
            return value;
        }
        return null;
    }
}
