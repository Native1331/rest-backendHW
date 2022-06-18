package restbackend.tests;
import com.example.restbackend.domain.UserInfo;
import org.junit.jupiter.api.Test;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChatControllerTest extends TestBase{
    @Test
    void  registrationTest(){
        UserInfo[] userInfos = spec.get("userLogin/userPassword")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(UserInfo[].class);

        Stream.of(userInfos)
                .filter(userInfo -> userInfo.getUserId().equals(1))
                .filter(userInfo -> userInfo.getToken().equals("a1"))
                .peek(userInfo -> System.out.println(userInfo.getUserId()))
                .map(userInfo -> userInfo.toString())
                .collect(Collectors.toList());
    }

    @Test
    void findByNameTest() {
        UserInfo[] userInfos = spec.get("userName/userId")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(UserInfo[].class);

        Stream.of(userInfos)
                .filter(userInfo -> userInfo.getUserName().equals("Dmitriy Dmitrievich Dmitriev"))
                .peek(userInfo -> System.out.println(userInfo.getUserName()))
                .map(userInfo -> userInfo.toString())
                .collect(Collectors.toList());
    }
}
