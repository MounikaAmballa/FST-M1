package Activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity3
{
    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    int petId;

    @BeforeClass
    public void setUp()
    {
        //create request spec
        reqSpec=new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .build();
        //create response spec
        resSpec=new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .expectBody("status",equalTo("alive"))
                .build();
    }

    @DataProvider
    public Object[][] petInfo() {
        Object[][] data = new Object[][] {
                { 77232, "Riley", "alive" },
                { 77233, "Hansel", "alive" }
        };
        return data;
    }

    @Test(priority=1)
    public void postreq()
    {
        Map<String,Object> map=new HashMap<>();

        //Add Pet1
        map.put("id",77232);
        map.put("name","Riley");
        map.put("status","alive");

        Response response=given().spec(reqSpec).body(map).when().post();

        //Add Pet2
        map.put("id",77233);
        map.put("name","Hansel");
        map.put("status","alive");

        response=given().spec(reqSpec).body(map).when().post();

        //Assertion
        response.then().spec(resSpec);
    }

    @Test(priority=2,dataProvider = "petInfo")
    public void getreq(int id,String name,String status) {
        Response response = given().spec(reqSpec).pathParam("petId", id).get("/{petId}");
        String body = response.getBody().asPrettyString();
        System.out.println(body);

        //Assertion
        response.then().spec(resSpec).body("name", equalTo(name));
    }

    @Test(priority=3,dataProvider = "petInfo")
    public void deletereq(int id,String name,String status)
    {
        Response response=given().spec(reqSpec).pathParam("petId",id).delete("/{petId}");
        String body=response.getBody().asPrettyString();
        System.out.println(body);

        //Assertion
        response.then().spec(resSpec).body("code",equalTo(200));

    }

}
