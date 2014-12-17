package resttest;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import rest.RestClient;

/**
 * Created by borys.shchypanskyi on 12/17/2014.
 */
public class Test2 {
    private RestClient restClient = new RestClient();
    private JSONObject jsonObj1 = new JSONObject();
    private String URL = "http://jsonplaceholder.typicode.com/posts/";
    private int ID = 5;
    
    @Test
    public void test2(){
        JSONObject jsonObjtmp = new JSONObject();
        JSONObject jsonObj2 = new JSONObject();
        try{
            jsonObj1 = restClient.restGet(URL+ID);
            jsonObjtmp = restClient.restGet(URL+ID);
            System.out.println("Object1: " + jsonObj1);
            jsonObjtmp.put("userId", "-5");
            jsonObjtmp.put("title", "test125");
            restClient.restPost(URL, jsonObjtmp);
            jsonObj2= restClient.restGet(URL+ID);
            System.out.println("Object2: " + jsonObj2);
            Assert.assertNotEquals(jsonObj1.toString(), jsonObj2.toString(), "Objects are equals!!!");
            System.out.println("Objects aren't equals!!!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @AfterTest
    public void cleanEnv(){
        restClient.restPost(URL, jsonObj1);
    }
}
