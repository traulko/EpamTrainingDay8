package test.traulko.task8.model.dao.impl;

import com.traulko.task8.exception.DaoException;
import com.traulko.task8.model.dao.BookListDao;
import com.traulko.task8.model.dao.impl.BookListDaoImpl;
import com.traulko.task8.model.entity.CustomBook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BookListDaoImplTest {
    BookListDao bookListDao;

    @BeforeClass
    public void setUp() {
        bookListDao = new BookListDaoImpl();
    }

    @AfterClass
    public void tearDown() {
        bookListDao = null;
    }

    @Test
    public void findByIdPositiveTest() throws DaoException {
        CustomBook actual = bookListDao.findById(-1);
        CustomBook expected = new CustomBook();
        assertEquals(actual, expected);
    }

    @Test
    public void findByIdNegativeTest() throws DaoException {
        CustomBook actual = bookListDao.findById(1);
        CustomBook expected = new CustomBook();
        assertNotEquals(actual, expected);
    }

    @Test
    public void findByAuthorPositiveTest() throws DaoException {
        List<CustomBook> actual = bookListDao.findByAuthor("Viktor Roz");
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book2", bookAuthors, 254, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(actual, expected);
    }

    @Test
    public void findByAuthorNegativeTest() throws DaoException {
        List<CustomBook> actual = bookListDao.findByAuthor("Viktor Roz");
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book", bookAuthors, 12, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertNotEquals(actual, expected);
    }

    @Test
    public void findByNamePositiveTest() throws DaoException {
        List<CustomBook> actual = bookListDao.findByName("Book2");
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book2", bookAuthors, 254, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(actual, expected);
    }

    @Test
    public void findByNameNegativeTest() throws DaoException {
        List<CustomBook> actual = bookListDao.findByName("Book");
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book", bookAuthors, 12, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertNotEquals(actual, expected);
    }

    @Test
    public void findByPagesCountPositiveTest() throws DaoException {
        List<CustomBook> actual = bookListDao.findByPagesCount(254);
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book2", bookAuthors, 254, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(actual, expected);
    }

    @Test
    public void findByPagesCountNegativeTest() throws DaoException {
        List<CustomBook> actual = bookListDao.findByPagesCount(0);
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book", bookAuthors, 12, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertNotEquals(actual, expected);
    }

    @Test
    public void findByPublishingYearPositiveTest() throws DaoException {
        List<CustomBook> actual = bookListDao.findByPublishingYear(2018);
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book2", bookAuthors, 254, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(actual, expected);
    }

    @Test
    public void findByPublishingYearNegativeTest() throws DaoException {
        List<CustomBook> actual = bookListDao.findByPublishingYear(0);
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book", bookAuthors, 12, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortByAuthorPositiveTest() throws DaoException {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Yanka Kupala");
        book1Authors.add("Yakub Kolas");
        CustomBook book1 = new CustomBook("Book", book1Authors, 156, 2020);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Viktor Roz");
        CustomBook book2 = new CustomBook("Book2", book2Authors, 254, 2018);
        List<String> book3Authors = new ArrayList<>();
        book3Authors.add("Egor Bondar");
        book3Authors.add("Yura Lagodich");
        CustomBook book3 = new CustomBook("Book3", book3Authors, 148, 2019);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book3);
        expected.add(book2);
        expected.add(book1);
        List<CustomBook> actual = bookListDao.sortBooksByAuthor();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByAuthorNegativeTest() throws DaoException {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Yanka Kupala");
        book1Authors.add("Yakub Kolas");
        CustomBook book1 = new CustomBook("Book", book1Authors, 156, 2020);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Viktor Roz");
        CustomBook book2 = new CustomBook("Book2", book2Authors, 254, 2018);
        List<String> book3Authors = new ArrayList<>();
        book3Authors.add("Egor Bondar");
        book3Authors.add("Yura Lagodich");
        CustomBook book3 = new CustomBook("Book3", book3Authors, 148, 2019);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        expected.add(book3);
        List<CustomBook> actual = bookListDao.sortBooksByAuthor();
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortByIdPositiveTest() throws DaoException {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Yanka Kupala");
        book1Authors.add("Yakub Kolas");
        CustomBook book1 = new CustomBook("Book", book1Authors, 156, 2020);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Viktor Roz");
        CustomBook book2 = new CustomBook("Book2", book2Authors, 254, 2018);
        List<String> book3Authors = new ArrayList<>();
        book3Authors.add("Egor Bondar");
        book3Authors.add("Yura Lagodich");
        CustomBook book3 = new CustomBook("Book3", book3Authors, 148, 2019);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        expected.add(book3);
        List<CustomBook> actual = bookListDao.sortById();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByIdNegativeTest() throws DaoException {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Yanka Kupala");
        book1Authors.add("Yakub Kolas");
        CustomBook book1 = new CustomBook("Book", book1Authors, 156, 2020);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Viktor Roz");
        CustomBook book2 = new CustomBook("Book2", book2Authors, 254, 2018);
        List<String> book3Authors = new ArrayList<>();
        book3Authors.add("Egor Bondar");
        book3Authors.add("Yura Lagodich");
        CustomBook book3 = new CustomBook("Book3", book3Authors, 148, 2019);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book3);
        expected.add(book2);
        expected.add(book1);
        List<CustomBook> actual = bookListDao.sortById();
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortByNamePositiveTest() throws DaoException {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Yanka Kupala");
        book1Authors.add("Yakub Kolas");
        CustomBook book1 = new CustomBook("Book", book1Authors, 156, 2020);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Viktor Roz");
        CustomBook book2 = new CustomBook("Book2", book2Authors, 254, 2018);
        List<String> book3Authors = new ArrayList<>();
        book3Authors.add("Egor Bondar");
        book3Authors.add("Yura Lagodich");
        CustomBook book3 = new CustomBook("Book3", book3Authors, 148, 2019);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        expected.add(book3);
        List<CustomBook> actual = bookListDao.sortBooksByName();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByNameNegativeTest() throws DaoException {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Yanka Kupala");
        book1Authors.add("Yakub Kolas");
        CustomBook book1 = new CustomBook("Book", book1Authors, 156, 2020);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Viktor Roz");
        CustomBook book2 = new CustomBook("Book2", book2Authors, 254, 2018);
        List<String> book3Authors = new ArrayList<>();
        book3Authors.add("Egor Bondar");
        book3Authors.add("Yura Lagodich");
        CustomBook book3 = new CustomBook("Book3", book3Authors, 148, 2019);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book3);
        expected.add(book2);
        expected.add(book1);
        List<CustomBook> actual = bookListDao.sortBooksByName();
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortByPagesCountPositiveTest() throws DaoException {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Yanka Kupala");
        book1Authors.add("Yakub Kolas");
        CustomBook book1 = new CustomBook("Book", book1Authors, 156, 2020);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Viktor Roz");
        CustomBook book2 = new CustomBook("Book2", book2Authors, 254, 2018);
        List<String> book3Authors = new ArrayList<>();
        book3Authors.add("Egor Bondar");
        book3Authors.add("Yura Lagodich");
        CustomBook book3 = new CustomBook("Book3", book3Authors, 148, 2019);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book3);
        expected.add(book1);
        expected.add(book2);
        List<CustomBook> actual = bookListDao.sortBooksByPagesCount();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByPagesCountNegativeTest() throws DaoException {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Yanka Kupala");
        book1Authors.add("Yakub Kolas");
        CustomBook book1 = new CustomBook("Book", book1Authors, 156, 2020);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Viktor Roz");
        CustomBook book2 = new CustomBook("Book2", book2Authors, 254, 2018);
        List<String> book3Authors = new ArrayList<>();
        book3Authors.add("Egor Bondar");
        book3Authors.add("Yura Lagodich");
        CustomBook book3 = new CustomBook("Book3", book3Authors, 148, 2019);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book3);
        expected.add(book2);
        expected.add(book1);
        List<CustomBook> actual = bookListDao.sortBooksByPagesCount();
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortByPublishingYearPositiveTest() throws DaoException {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Yanka Kupala");
        book1Authors.add("Yakub Kolas");
        CustomBook book1 = new CustomBook("Book", book1Authors, 156, 2020);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Viktor Roz");
        CustomBook book2 = new CustomBook("Book2", book2Authors, 254, 2018);
        List<String> book3Authors = new ArrayList<>();
        book3Authors.add("Egor Bondar");
        book3Authors.add("Yura Lagodich");
        CustomBook book3 = new CustomBook("Book3", book3Authors, 148, 2019);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        expected.add(book3);
        expected.add(book1);
        List<CustomBook> actual = bookListDao.sortBooksByPublishingYear();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByPublishingYearNegativeTest() throws DaoException {
        List<String> book1Authors = new ArrayList<>();
        book1Authors.add("Yanka Kupala");
        book1Authors.add("Yakub Kolas");
        CustomBook book1 = new CustomBook("Book", book1Authors, 156, 2020);
        List<String> book2Authors = new ArrayList<>();
        book2Authors.add("Viktor Roz");
        CustomBook book2 = new CustomBook("Book2", book2Authors, 254, 2018);
        List<String> book3Authors = new ArrayList<>();
        book3Authors.add("Egor Bondar");
        book3Authors.add("Yura Lagodich");
        CustomBook book3 = new CustomBook("Book3", book3Authors, 148, 2019);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book3);
        expected.add(book2);
        expected.add(book1);
        List<CustomBook> actual = bookListDao.sortBooksByPublishingYear();
        assertNotEquals(actual, expected);
    }
}