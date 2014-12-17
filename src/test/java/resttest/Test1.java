package resttest;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.RestClient;

/**
 * Created by borys.shchypanskyi on 12/17/2014.
 */
public class Test1 {
    private RestClient restClient = new RestClient();
    @Test
    public void test1(){
        String url1 = "http://jsonplaceholder.typicode.com/posts/10";
        String url2 = "http://jsonplaceholder.typicode.com/posts";
        JSONObject jsonObj1 = new JSONObject();
        JSONObject jsonObj2 = new JSONObject();
        try{
            jsonObj1 = restClient.restGet(url1);
            jsonObj1.put("id", "101");
            jsonObj1.put("userId", "-5");
            jsonObj1.put("title", "test125");
            jsonObj1.put("id", "177");
            restClient.restPost(url2, jsonObj1);
            jsonObj2= restClient.restGet(url2 + "/" + jsonObj1.get("id"));
            Assert.assertEquals(jsonObj1.toString(), jsonObj2.toString(), "Objects aren't equals!!!");
            System.out.println("Objects are equals!!!");
            System.out.println("Object1: " + jsonObj1);
            System.out.println("Object2: " + jsonObj2);;
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
