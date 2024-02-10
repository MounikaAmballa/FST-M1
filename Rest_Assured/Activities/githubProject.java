package Project;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class githubProject {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    String sshKey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIKo4vqPjRuwTpVxIpXb5zU/kgR0XFN1VSFLckMeCiKeX";
    int sshKeyId;

    @BeforeClass
    public void setup() {
          //create request spec
          reqSpec = new RequestSpecBuilder()
                  .setBaseUri("https://api.github.com/user/keys")
                  .addHeader("Authorization", "token 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")
                  .addHeader("Content-Type","application/json")
                  .build();
          //create response spec
          resSpec = new ResponseSpecBuilder()
                  .expectResponseTime(lessThan(5000L))
                  .expectBody("key", equalTo(sshKey))
                  .expectBody("title", equalTo("TestAPIKey"))
                  .build();
      }


        @Test(priority=1)
        public void postreq()
        {

            Map<String,String> map=new HashMap<>();
            map.put("title","TestAPIKey");
            map.put("key",sshKey);

            Response response=given().spec(reqSpec).body(map).when().post();
            //Extract ID
            sshKeyId=response.then().extract().path("id");
            System.out.println(sshKeyId);

            //Assertion
            response.then().statusCode(201).spec(resSpec);
        }

        @Test(priority=2)
        public void getreq() {

            Response response = given().spec(reqSpec).pathParam("keyId", sshKeyId).get("/{keyId}");

            //Assertion
           response.then().statusCode(200).spec(resSpec);

           }

        @Test(priority=3)
        public void deletereq()
        {
            Response response = given().spec(reqSpec).pathParam("keyId", sshKeyId).delete("/{keyId}");

            //Assertion
            response.then().statusCode(anyOf(is(200),is(204)));


        }

    }


