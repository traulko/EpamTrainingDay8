package com.traulko.task8.model.factory;

import com.traulko.task8.model.dao.BookListDao;
import com.traulko.task8.model.dao.impl.BookListDaoImpl;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final BookListDao bookListDaoImpl = new BookListDaoImpl();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public BookListDao getBookListDao() {
        return bookListDaoImpl;
    }
}
