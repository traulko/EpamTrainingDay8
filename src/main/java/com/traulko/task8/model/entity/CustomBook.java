package com.traulko.task8.model.entity;

import java.util.*;

public class CustomBook {
    private int id;
    private String name;
    private List<String> authors;
    private int pagesCount;
    private int publishingYear;

    public CustomBook(String name, List<String> authors,
                      int pagesCount, int publishingYear) {
        this.name = name;
        this.authors = authors;
        this.pagesCount = pagesCount;
        this.publishingYear = publishingYear;
    }

    public CustomBook() {
        this.name = "";
        this.authors = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getAuthorStringFormat() {
        StringBuilder result = new StringBuilder();
        if (authors.size() == 1) {
            result.append(authors.get(0));
        } else {
            for (int i = 0; i < authors.size() - 1; i++) {
                result.append(authors.get(i));
                result.append(",");
            }
            result.append(authors.get(authors.size() - 1));
        }
        return result.toString();
    }

    public void setAuthorStringFormat(String authors) {
        String [] authorArray = authors.split(",");
        this.authors = new ArrayList<>(Arrays.asList(authorArray));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CustomBook other = (CustomBook) obj;
        if (name != null ? !name.equals(other.name) : other.name != null) {
            return false;
        }
        if (authors != null ? !authors.equals(other.authors) : other.authors != null) {
            return false;
        }
        if (pagesCount != other.pagesCount) {
            return false;
        }
        if (publishingYear != other.publishingYear) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        int prime = 31;
        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + (authors != null ? authors.hashCode() : 0);
        result = prime * result + pagesCount;
        result = prime * result + publishingYear;
        return result;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", CustomBook.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("authors=" + authors)
                .add("pagesCount=" + pagesCount)
                .add("publishingYear=" + publishingYear)
                .toString();
    }
}
