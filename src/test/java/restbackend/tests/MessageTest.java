package restbackend.tests;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class MessageTest extends TestBase {
    @Test
    void sendMessage() {
        String body = "{ \"message\": \"hello\"}";

        given()
                .log().uri()
                .log().body()
                .body(body)
                .contentType(JSON)
                .when()
                .post(baseURI, basePath)
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body ( message, is("Hello"),
                        senderId, is(2),
                        receiverId, is(4));
    }
    @Test
    void findAllMessagesFromUserById() {
        String param = "{\"receiverId\": 5}";
        given()
                .when()
                .get(baseURI, basePath)
                .then()
                .contentType(JSON)
                .log().status()
                .log().body()
                .statusCode(200)
                .body(message, is("Hello"),
                        senderId, is(2),
                        receiverId, is(4));
    }
}


