package resttest;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import rest.RestClient;

/**
 * Created by borys.shchypanskyi on 12/17/2014.
 */
public class Test2 extends Tests{

    private int ID = 5;

    @Test
    public void test2(){
        System.out.println("***Test2 Started***");
        JSONObject jsonObjtmp = new JSONObject();
        JSONObject jsonObj2 = new JSONObject();
        try{
            jsonObj1 = restClient.restGet(URL+ID);
            jsonObjtmp = restClient.restGet(URL+ID);
            System.out.println(String.format("Object1: %s  Code: %d", jsonObj1, restClient.getRestCode()));

            jsonObjtmp.put("userId", "-5");
            jsonObjtmp.put("title", "test125");
            restClient.restPost(URL, jsonObjtmp);
            System.out.println("Code after post: " + restClient.getRestCode());
            jsonObj2= restClient.restGet(URL+ID);
            System.out.println(String.format("Object2: %s  Code: %d", jsonObj2, restClient.getRestCode()));
            Assert.assertNotEquals(jsonObj1.toString(), jsonObj2.toString(), "Objects are equals!!!");
            System.out.println("Objects aren't equals!!!");
        } catch (Exception e){
            System.out.println(String.format("Exception: %s in TEST2", e.getClass()));
            //e.printStackTrace();
        }
        System.out.println("***Test2 Completed***");
    }

}
