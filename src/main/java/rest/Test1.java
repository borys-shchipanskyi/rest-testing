package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;


/**
 * Created by borys.shchypanskyi on 12/16/2014.
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://jsonplaceholder.typicode.com/posts/10");
        HttpResponse response = client.execute(request);
        System.out.println(response.getAllHeaders());
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        String str2 = "";

        while ((line = rd.readLine()) != null) {
            System.out.println(line);
            str2 += line;
        }
        JSONObject json = new JSONObject();
    }
}
