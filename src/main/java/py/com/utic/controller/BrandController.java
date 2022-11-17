package py.com.utic.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import py.com.utic.entity.Brand;
import py.com.utic.service.BrandService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class BrandController {

    @Autowired
    private BrandService service;

    @GetMapping("/utic/brand")
    public List<Brand> getAll(){
        return service.getAll();
    }

    @GetMapping("/utic/brand/{id}")
    public Optional<Brand> getById(@PathVariable("id") String idBrand){
        return service.getById(Long.parseLong(idBrand));
    }

    @PostMapping("/utic/brand")
    public void save(@RequestBody Brand brand){
        brand.setImage(getImageUrl(brand.getName()));
        service.save(brand);
    }

    @DeleteMapping("utic/brand/{id}")
    public void deleteById(@PathVariable("id") String idBrand){
        service.deleteById(Long.parseLong(idBrand));
    }

    private String getImageUrl(String brand){
        String response = getImages(brand.toLowerCase());
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("results"));
            JSONObject object = jsonArray.getJSONObject(0);
            JSONObject object2 = object.getJSONObject("links");
            return (object2.getString("html"));
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
