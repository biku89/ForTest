package com.example.test.application.blacklist;

public record AddPersonToBlacklistCommand(
        String pesel,
        String reason) {

}
