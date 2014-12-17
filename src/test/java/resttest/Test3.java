package resttest;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
    /*
    *step1: Try to GET info from URL with not real id and save as json
    *step2: Check if response code equals 500
    */

public class Test3 extends Tests{
    private int ID = 777;

    @Test
    public void test3() {
        System.out.println("***Test3 Started***");
        try {
            jsonObj1 = restClient.restGet(URL + ID);
        } catch (Exception e){
            System.out.println(String.format("Exception: %s in TEST3", e.getClass()));
        }
        Assert.assertTrue(restClient.getRestCode() == 500, "Objects are equals!!!");
        System.out.println(String.format("%s Internal Server Error", restClient.getRestCode()));
        System.out.println("***Test3 Completed***");
    }
}
