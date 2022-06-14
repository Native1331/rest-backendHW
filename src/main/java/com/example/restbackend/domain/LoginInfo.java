package com.example.restbackend.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming (value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LoginInfo {

    private String SenderUserId;
    private String ReceiverUserID;
    private String userFirstName;
    private String userMiddleName;
    private String userSurname;
}
