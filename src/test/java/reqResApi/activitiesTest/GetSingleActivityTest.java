package reqResApi.activitiesTest;

import base.BaseTest;
import dataFactory.ActivitiesDataFactory;
import dataObject.activities.CreateActivities;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ApiEndPoints;
import utilities.ApiHelpers;

import static io.restassured.RestAssured.given;

public class GetSingleActivityTest extends BaseTest {

    @Test
    public void getSingleActivity() {
        SoftAssert softAssert = new SoftAssert();
        ApiHelpers apiHelpers = new ApiHelpers();
        CreateActivities activitiesData = ActivitiesDataFactory.getActivitiesData();

        test.info("Sending GET request to fetch all activities");
        Response response = given()
                .spec(apiHelpers.requestSpecificationBaseURI()).pathParam("id", activitiesData.getId())
                .when()
                .get(ApiEndPoints.getSingleActivities);

        test.info("Response received: " + response.asString());

        CreateActivities activityById = response.as(CreateActivities.class);

        softAssert.assertEquals(response.getStatusCode(), 200, "Status code mismatch");

        softAssert.assertTrue(response.getContentType().contains("application/json"), "Content type mismatch");

        softAssert.assertEquals(activityById.getId(), activitiesData.getId(), "ID is not 2");

        softAssert.assertEquals(activityById.getTitle(), "Activity 2", "Title mismatch");

        softAssert.assertTrue(activityById.getDueDate().matches("\\d{4}-\\d{2}-\\d{2}T.*"), "DueDate format incorrect");

        softAssert.assertTrue(activityById.isCompleted(), "Completed should be true");

        softAssert.assertAll();

    }
}
