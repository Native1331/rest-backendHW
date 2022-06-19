package com.example.restbackend.controller;
import com.example.restbackend.domain.LoginInfo;
import com.example.restbackend.domain.UserInfo;
import com.example.restbackend.exception.InvalidIdException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;



/**–
 найти друга по Ф.И.О+, в ответ его ID, отправить сообщение от одного к другому+
 (сохраняется на сервере само сообщение и ID от кого кому), проверить есть ли сообщения для себя (по своему ID));**/
@RestController
public class RegistrationController {
    private Map<String, LoginInfo> userLogin = Map.of(
            "Dmitriy Dmitriev", LoginInfo.builder().userLogin("Dmitriy Dmitriev").build(),
            "Olga Sidorova", LoginInfo.builder().userLogin("Olga Sidorova").build(),
            "Ivan  Ivanov", LoginInfo.builder().userLogin("Ivan  Ivanov").build()
    );
    private Map<String, LoginInfo> userName = Map.of(
            "Dmitriy Dmitrievich Dmitriev", LoginInfo.builder().userName("Dmitriy Dmitrievich Dmitriev").build(),
            "Olga Petrovna Sidorova", LoginInfo.builder().userName("Olga Petrovna Sidorova").build(),
            "Ivan Ivanovitch Ivanov", LoginInfo.builder().userName("Ivan Ivanovitch Ivanov").build()
    );
    private Map<Integer, LoginInfo> userPassword = Map.of(
            111, LoginInfo.builder().userPassword("111").build(),
            222, LoginInfo.builder().userPassword("222").build(),
            333, LoginInfo.builder().userPassword("333").build()
    );
    private Map<Integer, UserInfo> userId = Map.of(
            1, UserInfo.builder().userId(1).build(),
            2, UserInfo.builder().userId(2).build(),
            3, UserInfo.builder().userId(3).build()
    );
    private Map<String, UserInfo> token = Map.of(
            "a1", UserInfo.builder().token("a1").build(),
            "b2", UserInfo.builder().token("b2").build(),
            "c3", UserInfo.builder().token("c3").build()
    );

    @PostMapping("userLogin/userPassword")
    @ApiOperation("Регистрация пользователя")
    public UserInfo getUserId(@RequestBody LoginInfo loginInfo) {
        if (loginInfo.getUserLogin().equals("Dmitriy Dmitriev") ||
                (loginInfo.getUserPassword().equals("111"))) {
            return UserInfo.builder()
                    .userLogin(loginInfo.getUserLogin())
                    .userPassword(loginInfo.getUserPassword())
                    .userId(1)
                    .token("a1")
                    .build();
        } else {
            throw new InvalidIdException();
        }
    }

    @GetMapping("userName/userId")
    @ApiOperation("Поиск по ФИО")
    public UserInfo getUserName(@RequestParam LoginInfo loginInfo) {
        //   (value = userName; String Dmitriy Dmitrievich Dmitriev) {
        if (loginInfo.getUserName().equals("Dmitriy Dmitrievich Dmitriev")) {
            throw new InvalidIdException();
        } else {
            return   UserInfo.builder()
                    .userId(1)
                    .build();
        }
    }
}





