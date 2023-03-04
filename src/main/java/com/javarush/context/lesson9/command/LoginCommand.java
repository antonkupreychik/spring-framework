package com.javarush.context.lesson9.command;

import lombok.Data;

@Data
public class LoginCommand {
    private String login;
    private String password;

}
