package reqResApi.parentTest;

import base.BaseTest;
import dataFactory.UserDataFactory;
import dataObject.user.User;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ApiEndPoints;
import utilities.ApiHelpers;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateListOfUserTest extends BaseTest {

    @Test
    public void createMultipleUsers() {
        ApiHelpers apiHelpers = new ApiHelpers();
        SoftAssert softAssert = new SoftAssert();

        test.info("Preparing request body for creating 50 users");

        List<User> usersList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            usersList.add(UserDataFactory.getUserDetails());
        }

        test.info("Sending POST request to create multiple users");
        Response response = given()
                .spec(apiHelpers.requestSpecificationBaseURI())
                .body(usersList)
                .when()
                .post(ApiEndPoints.createMultipleUserApi);

        test.info("Response received: " + response.asString());

        softAssert.assertEquals(response.getStatusCode(), 200, "Status code not matched");
        test.pass("Status code is 200");

        softAssert.assertTrue(response.getContentType().contains("application/json"), "Content type mismatch");
        test.pass("Content type is application/json");

        softAssert.assertEquals(response.jsonPath().getString("code"), "200", "Code field mismatch");
        test.pass("Code is 200");

        softAssert.assertEquals(response.jsonPath().getString("type"), "unknown", "Type field mismatch");
        test.pass("Type is unknown");

        softAssert.assertEquals(response.jsonPath().getString("message"), "ok", "Message field mismatch");
        test.pass("Message is ok");

        softAssert.assertAll();
    }
}
