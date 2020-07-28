package com.traulko.task8.model.validator;

public class BookValidator {
    public static final int MIN_PAGES_COUNT = 1;
    public static final int MAX_PAGES_COUNT = 2500;
    public static final int MIN_PUBLISHING_YEAR = 0;
    public static final int MAX_PUBLISHING_YEAR = 2020;
    public static final int MIN_CHAR_COUNT = 1;
    public static final int MAX_CHAR_COUNT = 255;
    public static final int MIN_INDEX_VALUE = 1;

    public boolean isCorrectIndex(long index) {
        boolean result = true;
        if (index < MIN_INDEX_VALUE) {
            result = false;
        }
        return result;
    }

    public boolean isCorrectName(String name) {
        if (name == null) {
            return false;
        }
        return isStringCorrectLength(name);
    }

    public boolean isCorrectAuthor(String author) {
        if (author == null) {
            return false;
        }
        return isStringCorrectLength(author);
    }

    public boolean isCorrectPagesCount(int pagesCount) {
        boolean isMoreMin = pagesCount >= MIN_PAGES_COUNT;
        boolean isLessMax = pagesCount <= MAX_PAGES_COUNT;
        return isMoreMin && isLessMax;
    }

    public boolean isCorrectPublishingYear(int publishingYear) {
        boolean isMoreMin = publishingYear >= MIN_PUBLISHING_YEAR;
        boolean isLessMax = publishingYear <= MAX_PUBLISHING_YEAR;
        return isMoreMin && isLessMax;
    }

    private boolean isStringCorrectLength(String string) {
        int length = string.length();
        boolean isMoreMin = length >= MIN_CHAR_COUNT;
        boolean isLessMax = length <= MAX_CHAR_COUNT;
        return isMoreMin && isLessMax;
    }
}
