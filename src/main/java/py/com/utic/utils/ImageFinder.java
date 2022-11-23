package py.com.utic.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageFinder {

    public String getImageUrl(String brand, String model) {
        String response = getImages(brand.toLowerCase().concat("-").concat(model.replace(" ", ".").toLowerCase()));
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("results"));
            JSONObject object = jsonArray.getJSONObject(0);
            JSONObject object2 = object.getJSONObject("urls");
            return (object2.getString("regular"));
        } catch (JSONException err) {
            System.out.println(err);
            return null;
        }
    }

    private String getImages(String query) {
        final String BASEURL = "https://api.unsplash.com/search/photos?per_page=1&query=";
        final String TOKEN = "Client-ID P495eptzbntnC9o4FqkONA-922padhgqbp7lG_1-0OM";
        try {
            URL url = new URL(BASEURL + query);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);

            connection.disconnect();
            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Error de conexión " + connection.getResponseCode());
            } else {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                return content.toString();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
