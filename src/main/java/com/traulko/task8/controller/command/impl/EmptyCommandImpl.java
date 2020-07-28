package com.traulko.task8.controller.command.impl;

import com.traulko.task8.controller.command.Command;
import com.traulko.task8.controller.command.type.ResponseType;

import java.util.HashMap;
import java.util.Map;

public class EmptyCommandImpl implements Command {
    @Override
    public Map<String, Object> execute(Map<String, Object> parameters) {
        Map<String, Object> response = new HashMap<>();
        response.put(ResponseType.STATUS, "EMPTY COMMAND");
        return response;
    }
}
