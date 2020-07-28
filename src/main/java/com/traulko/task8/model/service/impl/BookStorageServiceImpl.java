package com.traulko.task8.model.service.impl;

import com.traulko.task8.exception.BookStorageServiceException;
import com.traulko.task8.exception.DaoException;
import com.traulko.task8.model.dao.BookListDao;
import com.traulko.task8.model.entity.CustomBook;
import com.traulko.task8.model.factory.DaoFactory;
import com.traulko.task8.model.service.BookStorageService;
import com.traulko.task8.model.validator.BookValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookStorageServiceImpl implements BookStorageService {
    @Override
    public void add(String name, String authors, int pagesCount, int publishingYear) throws BookStorageServiceException {
        BookValidator bookValidator = new BookValidator();
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();

        boolean isCorrectParameters = bookValidator.isCorrectName(name) &&
                bookValidator.isCorrectAuthor(authors) &&
                bookValidator.isCorrectPagesCount(pagesCount) &&
                bookValidator.isCorrectPublishingYear(publishingYear);
        if (isCorrectParameters) {
            CustomBook book = new CustomBook(name, getAuthors(authors), pagesCount, publishingYear);
            try {
                bookListDAO.add(book);
            } catch (DaoException e) {
                throw new BookStorageServiceException(e.getMessage());
            }
        } else {
            throw new BookStorageServiceException("Incorrect parameters");
        }
    }

    @Override
    public void remove(String name, String authors, int pagesCount, int publishingYear) throws BookStorageServiceException {
        BookValidator bookValidator = new BookValidator();
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();

        boolean isCorrectParameters = bookValidator.isCorrectName(name) &&
                bookValidator.isCorrectAuthor(authors) &&
                bookValidator.isCorrectPagesCount(pagesCount) &&
                bookValidator.isCorrectPublishingYear(publishingYear);
        if (isCorrectParameters) {
            CustomBook book = new CustomBook(name, getAuthors(authors), pagesCount, publishingYear);
            try {
                bookListDAO.remove(book);
            } catch (DaoException e) {
                throw new BookStorageServiceException(e.getMessage());
            }
        } else {
            throw new BookStorageServiceException("Incorrect parameters");
        }
    }

    @Override
    public CustomBook findById(long id) throws BookStorageServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        CustomBook book;
        try {
            book = bookListDAO.findById(id);
        } catch (DaoException e) {
            throw new BookStorageServiceException(e.getMessage());
        }
        return book;
    }

    @Override
    public List<CustomBook> findByName(String name) throws BookStorageServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        BookValidator validator = new BookValidator();
        List<CustomBook> neededBooks = new ArrayList<>();
        try {
            if (validator.isCorrectName(name)) {
                neededBooks = bookListDAO.findByName(name);
            }
        } catch (DaoException e) {
            throw new BookStorageServiceException(e.getMessage());
        }
        return neededBooks;
    }

    @Override
    public List<CustomBook> findByAuthor(String author) throws BookStorageServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        BookValidator validator = new BookValidator();
        List<CustomBook> neededBooks = new ArrayList<>();
        try {
            if (validator.isCorrectAuthor(author)) {
                neededBooks = bookListDAO.findByAuthor(author);
            }
        } catch (DaoException e) {
            throw new BookStorageServiceException(e.getMessage());
        }
        return neededBooks;
    }

    @Override
    public List<CustomBook> findByPagesCount(int pagesCount) throws BookStorageServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        BookValidator validator = new BookValidator();
        List<CustomBook> neededBooks = new ArrayList<>();
        try {
            if (validator.isCorrectPagesCount(pagesCount)) {
                neededBooks = bookListDAO.findByPagesCount(pagesCount);
            }
        } catch (DaoException e) {
            throw new BookStorageServiceException(e.getMessage());
        }
        return neededBooks;
    }

    @Override
    public List<CustomBook> findByPublishingYear(int publishingYear) throws BookStorageServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        BookValidator validator = new BookValidator();
        List<CustomBook> neededBooks = new ArrayList<>();
        try {
            if (validator.isCorrectPublishingYear(publishingYear)) {
                neededBooks = bookListDAO.findByPublishingYear(publishingYear);
            }
        } catch (DaoException e) {
            throw new BookStorageServiceException(e.getMessage());
        }
        return neededBooks;
    }

    @Override
    public List<CustomBook> sortById() throws BookStorageServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        List<CustomBook> bookList;
        try {
            bookList = bookListDAO.sortById();
        } catch (DaoException e) {
            throw new BookStorageServiceException(e.getMessage());
        }
        return bookList;
    }

    @Override
    public List<CustomBook> sortBooksByName() throws BookStorageServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        List<CustomBook> bookList;
        try {
            bookList = bookListDAO.sortBooksByName();
        } catch (DaoException e) {
            throw new BookStorageServiceException(e.getMessage());
        }
        return bookList;
    }

    @Override
    public List<CustomBook> sortBooksByAuthor() throws BookStorageServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        List<CustomBook> bookList;
        try {
            bookList = bookListDAO.sortBooksByAuthor();
        } catch (DaoException e) {
            throw new BookStorageServiceException(e.getMessage());
        }
        return bookList;
    }

    @Override
    public List<CustomBook> sortBooksByPagesCount() throws BookStorageServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        List<CustomBook> bookList;
        try {
            bookList = bookListDAO.sortBooksByPagesCount();
        } catch (DaoException e) {
            throw new BookStorageServiceException(e.getMessage());
        }
        return bookList;
    }

    @Override
    public List<CustomBook> sortBooksByPublishingYear() throws BookStorageServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        List<CustomBook> bookList;
        try {
            bookList = bookListDAO.sortBooksByPublishingYear();
        } catch (DaoException e) {
            throw new BookStorageServiceException(e.getMessage());
        }
        return bookList;
    }

    @Override
    public List<CustomBook> findAll() throws BookStorageServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        BookListDao bookListDAO = daoFactory.getBookListDao();
        List<CustomBook> neededBooks;
        try {
            neededBooks = bookListDAO.findAll();
        } catch (DaoException e) {
            throw new BookStorageServiceException(e.getMessage());
        }
        return neededBooks;
    }

    private List<String> getAuthors(String authorsStringFormat) {
        String[] authors = authorsStringFormat.split(",");
        return new ArrayList<>(Arrays.asList(authors));
    }
}
