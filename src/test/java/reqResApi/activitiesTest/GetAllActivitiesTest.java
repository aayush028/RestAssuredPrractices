package reqResApi.activitiesTest;

import base.BaseTest;
import dataObject.activities.CreateActivities;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ApiEndPoints;
import utilities.ApiHelpers;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllActivitiesTest extends BaseTest {

    @Test
    public void getListOfAllActivities() {

        SoftAssert softAssert = new SoftAssert();
        ApiHelpers apiHelpers = new ApiHelpers();

        test.info("Sending GET request to fetch all activities");
        Response response = given()
                .spec(apiHelpers.requestSpecificationBaseURI())
                .when()
                .get(ApiEndPoints.
                        getActivities);

        test.info("Response received: " + response.asString());

        List<CreateActivities> listAllActivitiesResponse =
                Arrays.asList(response.as(CreateActivities[].class));

        softAssert.assertEquals(response.getStatusCode(), 200, "Status code not matched");
        test.pass("Status code is 200");

        softAssert.assertTrue(response.getContentType().contains("application/json"), "Content type mismatch");
        test.pass("Content type is application/json");

        softAssert.assertTrue(listAllActivitiesResponse.stream().allMatch(a -> a.getId() != null),
                "Some activities have null IDs");
        softAssert.assertTrue(listAllActivitiesResponse.stream().allMatch(a -> a.getTitle() != null && !a.getTitle().isEmpty()),
                "Some activities have missing titles");
        softAssert.assertTrue(listAllActivitiesResponse.stream().allMatch(a -> a.getDueDate() != null),
                "Some activities have missing dueDate");

        test.pass("All activities have ID, title, and dueDate");

        softAssert.assertAll();
    }
}
