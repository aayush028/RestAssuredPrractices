package utilities;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ApiHelpers {

    public RequestSpecification requestSpecificationBaseURI()
    {
        return new RequestSpecBuilder().setBaseUri(ApiEndPoints.BaseUrl).addHeader("Content-Type", "application/json").build();
    }
}
