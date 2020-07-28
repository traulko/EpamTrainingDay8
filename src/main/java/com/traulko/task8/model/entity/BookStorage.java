package com.traulko.task8.model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class BookStorage {
    private static BookStorage instance;
    private List<CustomBook> books;

    private BookStorage() {
        this.books = new ArrayList<>();
    }

    public static BookStorage getInstance() {
        if (instance == null) {
            instance = new BookStorage();
        }
        return instance;
    }

    public List<CustomBook> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public boolean add(CustomBook book) {
        boolean result = true;
        if (books.contains(book)) {
            result = false;
        } else {
            books.add(book);
        }
        return result;
    }

    public boolean remove(CustomBook book) {
        boolean result = true;
        if (!books.contains(book)) {
            result = false;
        } else {
            books.remove(book);
        }
        return result;
    }

    public void removeAll() {
        books.removeAll(books);
    }

    public int size() {
        return books.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this == null || (this.getClass() != o.getClass())) {
            return false;
        }
        BookStorage bookStorage = (BookStorage) o;

        if (books == null) {
            return bookStorage.books == null;
        } else {
            return books.equals(bookStorage.books);
        }
    }

    @Override
    public int hashCode() {
        return books == null ? 0 : books.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BookStorage.class.getSimpleName() + "[", "]")
                .add("books=" + books)
                .toString();
    }
}
