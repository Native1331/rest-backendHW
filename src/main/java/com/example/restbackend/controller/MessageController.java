package com.example.restbackend.controller;
import com.example.restbackend.domain.AnswerMessageInfo;
import com.example.restbackend.exception.InvalidIdException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.security.auth.message.MessageInfo;
import java.util.Date;
import java.util.List;
import java.util.Map;



@RestController
public class MessageController {
    private Map<String, MessageInfo> message = Map.of(
            "Hello", MessageInfo.builder().message("Hello").build(),
            "My name is" + userName, MessageInfo.builder().message("My name is" + userName).build(),
            "GoodBye", MessageInfo.builder().message("GoodBye").build()
    );
    private Map<Integer, MessageInfo> senderId = Map.of(
            "Dmitriy Dmitrievich Dmitriev", MessageInfo.builder().senderId(1).build(),
            "Olga Olegovna Sidorova", MessageInfo.builder().senderId(2).build(),
            "Ivan Ivanovitch Ivanov", MessageInfo.builder().senderId(3).build()
    );
    private Map<Integer, MessageInfo> receiverId = Map.of(
            "Dmitriy Dmitrievich Dmitriev", MessageInfo.builder().receiverId(4).build(),
            "Olga Olegovna Sidorova", MessageInfo.builder().receiverId(5).build(),
            "Ivan Ivanovitch Ivanov", MessageInfo.builder().receiverId(6).build()
    );

    @PostMapping("receiverId/senderId/message")
    @ApiOperation("Создание сообщения")
    public List<MessageInfo> getUsers(@RequestBody MessageInfo messageInfo) {
        if (MessageInfo.getMessage().equals("Hello")) {
               return AnswerMessageInfo.builder()
                    .receiveIdDate(new Date())
                    .senderId()
                    .receiverId()
                    .message()
                    .build();
        } else {
            throw new InvalidIdException();
        }
    }

    @GetMapping("userName/receiverId")
    @ApiOperation("Поиск своих сообщений по ID")
  //  public AnswerMessageInfo getUserName(@RequestParam value = 1; Integer receiverId)

    public List<MessageInfo> getUsers(@RequestParam Integer receiverId) {
           if (receiverId.equals(5)) {
                throw new InvalidIdException();
            } else {
                return AnswerMessageInfo.builder()
                        .findUsersWith(receiverId)
                        .message
                        .userId(1)
                        .build();
            }
        }
    }


