package com.traulko.task8.controller.command.provider;

import com.traulko.task8.controller.command.Command;
import com.traulko.task8.controller.command.type.CommandType;

public class CustomProvider {
    public static Command defineCommand(String cmd) {
        Command command;

        if ((cmd != null) && (!cmd.isEmpty())) {
            try {
                command = CommandType.valueOf(cmd.toUpperCase()).getCommand();
            } catch (IllegalArgumentException e) {
                command = CommandType.EMPTY_COMMAND.getCommand();
            }
        } else {
            command = CommandType.EMPTY_COMMAND.getCommand();
        }
        return command;
    }
}
