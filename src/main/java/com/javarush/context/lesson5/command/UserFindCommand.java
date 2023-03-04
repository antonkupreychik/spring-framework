package com.javarush.context.lesson5.command;

import com.javarush.context.lesson5.annotations.Command;

@Command
public record UserFindCommand(Long id) {
}
