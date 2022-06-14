package com.example.restbackend.controller;


import com.example.restbackend.domain.LoginInfo;
import com.example.restbackend.domain.UserInfo;
import com.example.restbackend.exception.InvalidIdException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**– Мессенджер (зарегистрировать и получить уникальный ID,
 найти друга по Ф.И.О, в ответ его ID, отправить сообщение от одного к другому
 (сохраняется на сервере само сообщение и ID от кого кому), проверить есть ли сообщения для себя (по своему ID));**/
@RestController
public class BankController {
    private Map<String, UserInfo> name = Map.of(
            "Dima", UserInfo.builder().userFirstName("Dima").build(),
            "Olga", UserInfo.builder().userFirstName("Olga").build(),
            "Ivan", UserInfo.builder().userFirstName("Ivan").build()
    );
    private Map<String, UserInfo> MiddleName = Map.of(
            "Dmitrievna", UserInfo.builder().userMiddleName("Dmitrievich").build(),
            "Olegovna", UserInfo.builder().userMiddleName("Olegovna").build(),
            "Ivanovna", UserInfo.builder().userMiddleName("Ivanovitch").build()
    );
    private Map<String, UserInfo> Surname = Map.of(
            "Dima", UserInfo.builder().userSurname("Dmitriev").build(),
            "Olga", UserInfo.builder().userSurname("Sidorova").build(),
            "Ivan", UserInfo.builder().userSurname("Ivanov").build()
    );
    private Map<String, UserInfo>SenderUserId  = Map.of(
            1, UserInfo.builder().SenderUserId(1).build(),
            2, UserInfo.builder().SenderUserId(2).build(),
            3, UserInfo.builder().SenderUserId(3).build()
    );
    private Map<String, UserInfo> ReceiverUserID = Map.of(
            4, UserInfo.builder().ReceiverUserID(4).build(),
            5, UserInfo.builder().ReceiverUserID(5).build(),
            6, UserInfo.builder().ReceiverUserID(6).build()
    );

    @GetMapping("userFirstName/userMiddleName/userSurname")
    @ApiOperation("Поиск по ФИО")
    public List<UserInfo> getAllUsersInfo() {
        List <UserInfo> result = new ArrayList<>();
        for (Map.Entry<String, UserInfo> entry : SenderUserId.entrySet()) {
            result.add(entry.getValue());
        }
        return SenderUserId.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        @PostMapping("id/message")
        @ApiOperation("Передача сообщения по Id")
        public UserInfo Message(@RequestBody LoginInfo loginInfo) {
            if (SenderUserId.getId().equals("1")) {
                return UserInfo.builder()
                        .loginDate(new Date())
                        .userName(loginInfo.getUserName())
                        .build();
            } else {
                throw new InvalidIdException();
            }
        } @GetMapping("userFirstName/userMiddleName/userSurname")
        @ApiOperation("Поиск по ФИО")
        public List<UserInfo> getAllUsersInfo() {
            List <UserInfo> result = new ArrayList<>();
            for (Map.Entry<String, UserInfo> entry : users.entrySet()) {
                result.add(entry.getValue());
            }
            return usersID.entrySet()
                    .stream()
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());

    }
        @GetMapping("SenderUserId/userMessage/ReceiverUserID")
        @ApiOperation("Список  всех сообщений ")
        public List<UserInfo> getAllUsersInfo() {
            List <UserInfo> result = new ArrayList<>();
            for (Map.Entry<String, UserInfo> entry : users.entrySet()) {
                result.add(entry.getValue());
            }
            return usersID.entrySet()
                    .stream()
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
