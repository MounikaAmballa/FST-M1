package Activities;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity1 {

    String ROOT_URI = "https://petstore.swagger.io/v2/pet";

    @Test(priority = 1)
    public void postrequest()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("id",77232);
        map.put("name","Riley");
        map.put("status","alive");

        Response response=given().contentType(ContentType.JSON).body(map).when().post(ROOT_URI);

        //Assertions
        response.then().body("id", equalTo(77232));
        response.then().body("name",equalTo("Riley"));
        response.then().body("status",equalTo("alive"));
    }

    @Test(priority = 2)
    public void getrequest()
    {
        Response response=given().contentType(ContentType.JSON).when().pathParam("petId","77232").get(ROOT_URI+"/{petId}");
        //Assertions
        response.then().body("id", equalTo(77232));
        response.then().body("name",equalTo("Riley"));
        response.then().body("status",equalTo("alive"));
    }

    @Test(priority = 3)
    public void deleterequest()
    {
        Response response=given().contentType(ContentType.JSON).when().pathParam("petId","77232").delete(ROOT_URI+"/{petId}");
        //Assertions
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("77232"));
    }
}
