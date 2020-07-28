package com.traulko.task8.model.dao;

import com.traulko.task8.exception.DaoException;
import com.traulko.task8.model.entity.CustomBook;

import java.util.List;

public interface BookListDao {
    void add(CustomBook book) throws DaoException;

    void remove(CustomBook book) throws DaoException;

    CustomBook findById(long id) throws DaoException;

    List<CustomBook> findByName(String name) throws DaoException;

    List<CustomBook> findByAuthor(String author) throws DaoException;

    List<CustomBook> findByPagesCount(int pagesCount) throws DaoException;

    List<CustomBook> findByPublishingYear(int publishingYear) throws DaoException;

    List<CustomBook> sortById() throws DaoException;

    List<CustomBook> sortBooksByName() throws DaoException;

    List<CustomBook> sortBooksByAuthor() throws DaoException;

    List<CustomBook> sortBooksByPagesCount() throws DaoException;

    List<CustomBook> sortBooksByPublishingYear() throws DaoException;

    List<CustomBook> findAll() throws DaoException;
}
