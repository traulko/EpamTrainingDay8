package com.traulko.task8.controller.command.impl;

import com.traulko.task8.controller.command.Command;
import com.traulko.task8.controller.command.type.ParameterType;
import com.traulko.task8.controller.command.type.ResponseType;
import com.traulko.task8.exception.BookStorageServiceException;
import com.traulko.task8.model.entity.CustomBook;
import com.traulko.task8.model.service.BookStorageService;
import com.traulko.task8.model.service.impl.BookStorageServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class FindByAuthorCommandImpl implements Command {
    @Override
    public Map<String, Object> execute(Map<String, Object> parameters) {
        Map<String, Object> response = new HashMap<>();
        BookStorageService bookStorageService = new BookStorageServiceImpl();
        try {
            List<CustomBook> books = bookStorageService.findByAuthor((String) parameters.get(ParameterType.AUTHOR));
            response.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
            response.put(ResponseType.RESULT, books);
        } catch (BookStorageServiceException e) {
            response.put(ResponseType.STATUS, ResponseType.STATUS_FAIL);
        }
        return response;
    }
}
