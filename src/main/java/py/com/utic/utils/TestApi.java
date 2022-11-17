package py.com.utic.utils;

import org.apache.commons.logging.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.logging.Logger;

public class TestApi {

    public static void main(String[] args) {
        TestApi testApi = new TestApi();
        String a =testApi.getByteArrayFromImageURL("https://images.contentstack.io/v3/assets/blt187521ff0727be24/blt9d0c487b98ba6b42/60ee0ffb975ffd4ff25ec2f5/noxus_splash.jpg");
        System.out.println(a);
    }

    private String getByteArrayFromImageURL(String url) {

        try {
            URL imageUrl = new URL(url);
            URLConnection connection = imageUrl.openConnection();
            InputStream is = connection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int read = 0;
            while ((read = is.read(buffer, 0, buffer.length)) != -1) {
                baos.write(buffer, 0, read);
            }
            baos.flush();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (Exception e) {
            Logger.getLogger("Error", e.toString());
        }
        return null;
    }
//    private final String BASEURL = "https://api.unsplash.com/search/photos?per_page=1&query=";
//    private final String TOKEN = "Client-ID P495eptzbntnC9o4FqkONA-922padhgqbp7lG_1-0OM";
//
//    public static void main(String[] args) {
//        TestApi test = new TestApi();
//        String response = test.getImages("tesla");
//        try {
//            JSONObject jsonObject = new JSONObject(response);
//            JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("results"));
//            JSONObject object = jsonArray.getJSONObject(0);
//            JSONObject object2 = object.getJSONObject("links");
//            System.out.println(object2.getString("html"));
//        } catch (JSONException err) {
//            System.out.println(err);
//        }
//    }
//
//
//
//    private String getImages(String query) {
//        try {
//            URL url = new URL(BASEURL + query);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestProperty("Authorization", TOKEN);
//
//            connection.disconnect();
//            if (connection.getResponseCode() != 200) {
//                throw new RuntimeException("Error de conexión " + connection.getResponseCode());
//            } else {
//
//                BufferedReader in = new BufferedReader(
//                        new InputStreamReader(connection.getInputStream()));
//                String inputLine;
//                StringBuffer content = new StringBuffer();
//                while ((inputLine = in.readLine()) != null) {
//                    content.append(inputLine);
//                }
//                in.close();
//                return content.toString();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
