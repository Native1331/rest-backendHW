package restbackend.tests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;

public class TestBase {
    String message;
    Integer senderId;
    Integer receiverId;
    static {
        RestAssured.baseURI = "http://localhost:8080";
    }

    RequestSpecification spec =
            with()
                    .baseUri("http://localhost:8080")
                    .basePath("/");
}
