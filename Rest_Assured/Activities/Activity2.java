package Activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;

import static io.restassured.RestAssured.given;

public class Activity2 {

    String root_url="https://petstore.swagger.io/v2/user";

    @Test(priority = 1)
    public void postrequest() throws IOException, IOException {
        FileInputStream fis = new FileInputStream("src/test/resources/Activity2_input.json");
        String request = new String(fis.readAllBytes());
        Response response = given().contentType(ContentType.JSON).body(request).when().post(root_url);
        fis.close();

        // Assertions
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("503"));
    }


    @Test(priority = 2)
    public void getrequest()
    {
        File output = new File("src/test/resources/Activity2_output.json");
        Response response = given().contentType(ContentType.JSON).pathParam("username","mounika").when().get(root_url+"/{username}");
        String responsebody=response.getBody().asPrettyString();

        try {

            output.createNewFile();
            FileWriter writer = new FileWriter(output.getPath());
            writer.write(responsebody);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Assertions
        response.then().body("id", equalTo(503));
        response.then().body("username", equalTo("mounika"));
        response.then().body("firstName", equalTo("Justin"));
        response.then().body("lastName", equalTo("Case"));
        response.then().body("email", equalTo("justincase@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9812763450"));

    }

    @Test(priority = 3)
    public void deleterequest()
    {

        Response response = given().contentType(ContentType.JSON).pathParam("username", "mounika").when().delete(root_url+"/{username}");

        // Assertions
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("mounika"));
    }
}
