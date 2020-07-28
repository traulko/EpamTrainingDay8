package com.traulko.task8.controller.command.impl;

import com.traulko.task8.controller.command.Command;
import com.traulko.task8.controller.command.type.ParameterType;
import com.traulko.task8.controller.command.type.ResponseType;
import com.traulko.task8.exception.BookStorageServiceException;
import com.traulko.task8.model.service.BookStorageService;
import com.traulko.task8.model.service.impl.BookStorageServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class AddBookCommandImpl implements Command {
    @Override
    public Map<String, Object> execute(Map<String, Object> parameters) {
        BookStorageService bookStorageService = new BookStorageServiceImpl();
        Map<String, Object> response = new HashMap<>();
        String name = (String) parameters.get(ParameterType.NAME);
        String authors = (String) parameters.get(ParameterType.AUTHOR);
        int pagesCount = (int) parameters.get(ParameterType.PAGES_COUNT);
        int publishingYear = (int) parameters.get(ParameterType.PUBLISHING_YEAR);
        try {
            bookStorageService.add(name, authors, pagesCount, publishingYear);
            response.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
        } catch (BookStorageServiceException e) {
            response.put(ResponseType.STATUS, ResponseType.STATUS_FAIL);
        }
        return response;
    }
}
