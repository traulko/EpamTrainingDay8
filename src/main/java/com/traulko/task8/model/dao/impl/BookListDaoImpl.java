package com.traulko.task8.model.dao.impl;

import com.traulko.task8.model.connection.ConnectionPool;
import com.traulko.task8.exception.DaoException;
import com.traulko.task8.model.dao.BookListDao;
import com.traulko.task8.model.entity.CustomBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookListDaoImpl implements BookListDao {
    public static final String ADD_BOOK = "INSERT INTO book (bookName, author, pagesCount, publishingYear) VALUES (?, ?, ?, ?)";
    public static final String REMOVE_BOOK = "DELETE FROM book WHERE bookName = ? AND author = ? AND pagesCount = ? AND publishingYear = ?";
    public static final String FIND_ALL_BOOKS = "SELECT bookId, bookName, author, edition, pageNumber FROM book";
    public static final String FIND_BOOK_BY_ID = FIND_ALL_BOOKS + " WHERE bookId = ? ";
    public static final String FIND_BOOKS_BY_NAME = FIND_ALL_BOOKS + " WHERE bookName = ? ";
    public static final String FIND_BOOKS_BY_AUTHOR = FIND_ALL_BOOKS + " WHERE author = ? ";
    public static final String FIND_BOOKS_BY_PAGES_COUNT = FIND_ALL_BOOKS + " WHERE pagesCount = ? ";
    public static final String FIND_BOOKS_BY_PUBLISHING_YEAR = FIND_ALL_BOOKS + " WHERE publishingYear = ? ";
    public static final String SORT_BY_ID = FIND_ALL_BOOKS + " ORDER BY bookId ";
    public static final String SORT_BY_NAME = FIND_ALL_BOOKS + " ORDER BY bookName ";
    public static final String SORT_BY_AUTHOR = FIND_ALL_BOOKS + " ORDER BY author ";
    public static final String SORT_BY_PAGES_COUNT = FIND_ALL_BOOKS + " ORDER BY pagesCount ";
    public static final String SORT_BY_PUBLISHING_YEAR = FIND_ALL_BOOKS + " ORDER BY publishingYear ";


    @Override
    public void add(CustomBook book) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(ADD_BOOK)) {
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthorStringFormat());
            statement.setInt(3, book.getPagesCount());
            statement.setInt(4, book.getPublishingYear());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error while adding book to database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void remove(CustomBook book) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(REMOVE_BOOK)) {
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthorStringFormat());
            statement.setInt(3, book.getPagesCount());
            statement.setInt(4, book.getPublishingYear());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error while removing book from database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public CustomBook findById(long id) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        CustomBook book = new CustomBook();
        Connection connection = connectionPool.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(FIND_BOOK_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    book = createBookFromSql(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding book by id from database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return book;
    }

    @Override
    public List<CustomBook> findByName(String name) throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BOOKS_BY_NAME)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding books by name from database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    @Override
    public List<CustomBook> findByAuthor(String author) throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BOOKS_BY_AUTHOR)) {
            statement.setString(1, author);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding books by author from database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    @Override
    public List<CustomBook> findByPagesCount(int pagesCount) throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BOOKS_BY_PAGES_COUNT)) {
            statement.setInt(1, pagesCount);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding books by pagesCount from database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    @Override
    public List<CustomBook> findByPublishingYear(int publishingYear) throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BOOKS_BY_PUBLISHING_YEAR)) {
            statement.setInt(1, publishingYear);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding books by publishingYear from database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    @Override
    public List<CustomBook> sortById() throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SORT_BY_ID)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while sort books by id", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    @Override
    public List<CustomBook> sortBooksByName() throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SORT_BY_NAME)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while sort books by name", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    @Override
    public List<CustomBook> sortBooksByAuthor() throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SORT_BY_AUTHOR)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while sort books by author", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    @Override
    public List<CustomBook> sortBooksByPagesCount() throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SORT_BY_PAGES_COUNT)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while sort books by pagesCount", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    @Override
    public List<CustomBook> sortBooksByPublishingYear() throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SORT_BY_PUBLISHING_YEAR)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while sort books by publishingYear", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    @Override
    public List<CustomBook> findAll() throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(FIND_ALL_BOOKS)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while get all books from database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    private CustomBook createBookFromSql(ResultSet resultSet) throws DaoException {
        CustomBook book = new CustomBook();
        try {
            book.setId(resultSet.getInt("bookId"));
            book.setName(resultSet.getString("bookName"));
            book.setAuthorStringFormat(resultSet.getString("author"));
            book.setPagesCount(resultSet.getInt("pagesCount"));
            book.setPublishingYear(resultSet.getInt("publishingYear"));
        } catch (SQLException e) {
            throw new DaoException("Error while finding books", e);
        }
        return book;
    }
}
