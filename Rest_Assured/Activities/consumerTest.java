package Project;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(PactConsumerTestExt.class)
public class consumerTest
{
    //Headers
    Map<String, String> headers = new HashMap<String, String>();
    //Resource path
    String createUser = "/api/users";
    //create the contract
    @Pact(consumer = "UserConsumer",provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) throws ParseException {
        //Add the headers
        headers.put("Content-Type","application/json");
        //create request and response object
        DslPart requestResponseBody =new PactDslJsonBody()
                .numberType("id",8991)
                .stringType("firstName","mounika")
                .stringType("lastName","amballa")
                .stringType("email","mounika@example.com");
        //return the contract
        return builder.given("A request to create a user")
                .uponReceiving("A request to create a user")
                .path(createUser)
                .method("POST")
                .headers(headers)
                .body(requestResponseBody)
                .willRespondWith()
                .status(201)
                .body(requestResponseBody)
                .toPact();

    }
    //Test for consumer
    @Test
    @PactTestFor(providerName = "UserProvider",port="8080")
    public void postRequestTest(){
        // Mock url
        RestAssured.baseURI = "http://localhost:8080";
        // Create request specification
        RequestSpecification rq = RestAssured.given().headers(headers).when();
        //create request body
        Map<String,Object> reqBody=new HashMap<>();
        reqBody.put("id",8991);
        reqBody.put("firstName","mounika");
        reqBody.put("lastName","amballa");
        reqBody.put("email","mounika@example.com");


        // Send POST request
        Response response = rq.body(reqBody).post(createUser);
        // Assertion
        assert (response.getStatusCode() == 201);

    }

}
