package com.traulko.task8.controller;

import com.traulko.task8.controller.command.Command;
import com.traulko.task8.controller.command.provider.CustomProvider;
import com.traulko.task8.exception.BookStorageServiceException;

import java.util.Map;

public class BookStorageController {
    private static BookStorageController instance;

    public static BookStorageController getInstance() {
        if (instance == null) {
            instance = new BookStorageController();
        }
        return instance;
    }

    public Map<String, Object> processRequest(String cmd, Map<String, Object> parameters) {
        Command command = CustomProvider.defineCommand(cmd);
        return command.execute(parameters);
    }
}
