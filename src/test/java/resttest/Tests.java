package resttest;

import org.json.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import rest.RestClient;

/**
 * Created by borys.shchypanskyi on 12/17/2014.
 */
public class Tests {
    public RestClient restClient = new RestClient();
    public JSONObject jsonObj1 = new JSONObject();
    public String URL  = "http://jsonplaceholder.typicode.com/posts/";;


    @AfterTest
    public void cleanEnv(){
        if (jsonObj1 != null){
            restClient.restPost(URL, jsonObj1);
        }
    }

}
