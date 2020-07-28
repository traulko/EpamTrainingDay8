package com.traulko.task8.controller.command.impl;

import com.traulko.task8.controller.command.Command;
import com.traulko.task8.controller.command.type.ParameterType;
import com.traulko.task8.controller.command.type.ResponseType;
import com.traulko.task8.exception.BookStorageServiceException;
import com.traulko.task8.model.service.BookStorageService;
import com.traulko.task8.model.service.impl.BookStorageServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class RemoveBookCommandImpl implements Command {
    @Override
    public Map<String, Object> execute(Map<String, Object> parameters) {
        BookStorageService bookStorageService = new BookStorageServiceImpl();
        Map<String, Object> response = new HashMap<>();
        if (parameters.containsKey(ParameterType.ID)
                && parameters.containsKey(ParameterType.NAME)
                && parameters.containsKey(ParameterType.AUTHOR)
                && parameters.containsKey(ParameterType.PAGES_COUNT)
                && parameters.containsKey(ParameterType.PUBLISHING_YEAR)) {
            String name = (String) parameters.get("name");
            String authors = (String) parameters.get("author");
            int pagesCount = (int) parameters.get("pagesCount");
            int publishingYear = (int) parameters.get("publishingYear");
            try {
                bookStorageService.remove(name, authors, pagesCount, publishingYear);
                response.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
            } catch (BookStorageServiceException e) {
                response.put(ResponseType.STATUS, ResponseType.STATUS_FAIL);
            }
        }
        return response;
    }
}
