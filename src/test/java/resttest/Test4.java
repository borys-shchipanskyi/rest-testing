package resttest;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
    *step1: GET info from URL and save as json
    *step2: change some values in  json info and update data use PUT request
    *step3: GET new json info and compere it with previous info
 */
public class Test4 extends Tests{
    /*
*step1: Try to GET info from URL with not real id and save as json
*step2: Check if response code equals 500
*/
    private int ID = 777;

    @Test
    public void test3() {
        System.out.println("***Test4 Started***");
        JSONObject jsonObj2 = new JSONObject();
        try{
            jsonObj1 = restClient.restGet(URL+ID);
            jsonObj1.put("userId", "777");
            jsonObj1.put("title", "test125");
            restClient.restPut(URL, jsonObj1);
            jsonObj2 = restClient.restGet(URL+ID);
            Assert.assertEquals(jsonObj1.toString(), jsonObj2.toString(), "Objects aren't equals!!!");
            System.out.println("Objects are equals!!!");
            System.out.println("Object1: " + jsonObj1);
            System.out.println("Object2: " + jsonObj2);;
        } catch (Exception e){
            System.out.println(String.format("Exception: %s in TEST1", e.getClass()));
            //e.printStackTrace();
        }
        System.out.println("***Test1 Completed***");
    }
}
