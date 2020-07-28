package com.traulko.task8.model.service;

import com.traulko.task8.exception.BookStorageServiceException;
import com.traulko.task8.model.entity.CustomBook;

import java.util.List;

public interface BookStorageService {
    void add(String name, String authors, int pagesCount, int publishingYear) throws BookStorageServiceException;

    void remove(String name, String authors, int pagesCount, int publishingYear) throws BookStorageServiceException;

    CustomBook findById(long id) throws BookStorageServiceException;

    List<CustomBook> findByName(String name) throws BookStorageServiceException;

    List<CustomBook> findByAuthor(String author) throws BookStorageServiceException;

    List<CustomBook> findByPagesCount(int pagesCount) throws BookStorageServiceException;

    List<CustomBook> findByPublishingYear(int publishingYear) throws BookStorageServiceException;

    List<CustomBook> sortById() throws BookStorageServiceException;

    List<CustomBook> sortBooksByName() throws BookStorageServiceException;

    List<CustomBook> sortBooksByAuthor() throws BookStorageServiceException;

    List<CustomBook> sortBooksByPagesCount() throws BookStorageServiceException;

    List<CustomBook> sortBooksByPublishingYear() throws BookStorageServiceException;

    List<CustomBook> findAll() throws BookStorageServiceException;
}
