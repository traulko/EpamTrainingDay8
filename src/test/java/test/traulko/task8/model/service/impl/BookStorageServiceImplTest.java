package test.traulko.task8.model.service.impl;

import com.traulko.task8.exception.BookStorageServiceException;
import com.traulko.task8.exception.DaoException;
import com.traulko.task8.model.entity.CustomBook;
import com.traulko.task8.model.service.BookStorageService;
import com.traulko.task8.model.service.impl.BookStorageServiceImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class BookStorageServiceImplTest {
    BookStorageService bookStorageService;

    @BeforeClass
    public void setUp() {
        bookStorageService = new BookStorageServiceImpl();
    }

    @AfterClass
    public void tearDown() {
        bookStorageService = null;
    }

    @Test(expectedExceptions = BookStorageServiceException.class)
    public void addExceptionTest() throws BookStorageServiceException {
        bookStorageService.add(null, null, 0, 0);
    }

    @Test(expectedExceptions = BookStorageServiceException.class)
    public void removeExceptionTest() throws BookStorageServiceException {
        bookStorageService.remove(null, null, 0, 0);
    }

    @Test
    public void findByIdPositiveTest() throws BookStorageServiceException {
        CustomBook actual = bookStorageService.findById(1000);
        CustomBook expected = new CustomBook();
        assertEquals(actual, expected);
    }

    @Test
    public void findByIdNegativeTest() throws BookStorageServiceException {
        CustomBook actual = bookStorageService.findById(1);
        CustomBook expected = new CustomBook();
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = BookStorageServiceException.class)
    public void findByIdExceptionTest() throws BookStorageServiceException {
        bookStorageService.findById(-1);
    }

    @Test
    public void findByAuthorPositiveTest() throws BookStorageServiceException {
        List<CustomBook> actual = bookStorageService.findByAuthor("Viktor Roz");
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book2", bookAuthors, 254, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(actual, expected);
    }

    @Test
    public void findByAuthorNegativeTest() throws BookStorageServiceException {
        List<CustomBook> actual = bookStorageService.findByAuthor("Viktor Roz");
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book", bookAuthors, 12, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = BookStorageServiceException.class)
    public void findByAuthorExceptionTest() throws BookStorageServiceException {
        bookStorageService.findByAuthor(null);
    }

    @Test
    public void findByNamePositiveTest() throws BookStorageServiceException {
        List<CustomBook> actual = bookStorageService.findByName("Book2");
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book2", bookAuthors, 254, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(actual, expected);
    }

    @Test
    public void findByNameNegativeTest() throws BookStorageServiceException {
        List<CustomBook> actual = bookStorageService.findByName("Book");
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book", bookAuthors, 12, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = BookStorageServiceException.class)
    public void findByNameExceptionTest() throws BookStorageServiceException {
        bookStorageService.findByName(null);
    }

    @Test
    public void findByPagesCountPositiveTest() throws BookStorageServiceException {
        List<CustomBook> actual = bookStorageService.findByPagesCount(254);
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book2", bookAuthors, 254, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(actual, expected);
    }

    @Test
    public void findByPagesCountNegativeTest() throws BookStorageServiceException {
        List<CustomBook> actual = bookStorageService.findByPagesCount(1);
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book", bookAuthors, 12, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = BookStorageServiceException.class)
    public void findByPagesCountExceptionTest() throws BookStorageServiceException {
        bookStorageService.findByPagesCount(-1);
    }

    @Test
    public void findByPublishingYearPositiveTest() throws BookStorageServiceException {
        List<CustomBook> actual = bookStorageService.findByPublishingYear(2018);
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book2", bookAuthors, 254, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(actual, expected);
    }

    @Test
    public void findByPublishingYearNegativeTest() throws BookStorageServiceException {
        List<CustomBook> actual = bookStorageService.findByPublishingYear(0);
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Viktor Roz");
        CustomBook book = new CustomBook("Book", bookAuthors, 12, 2018);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = BookStorageServiceException.class)
    public void findByPublishingYearExceptionTest() throws BookStorageServiceException {
        bookStorageService.findByPublishingYear(-1);
    }

    @Test
    public void sortByAuthorPositiveTest() throws BookStorageServiceException {
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
        List<CustomBook> actual = bookStorageService.sortBooksByAuthor();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByAuthorNegativeTest() throws BookStorageServiceException {
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
        List<CustomBook> actual = bookStorageService.sortBooksByAuthor();
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortByIdPositiveTest() throws BookStorageServiceException {
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
        List<CustomBook> actual = bookStorageService.sortById();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByIdNegativeTest() throws BookStorageServiceException {
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
        List<CustomBook> actual = bookStorageService.sortById();
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortByNamePositiveTest() throws BookStorageServiceException {
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
        List<CustomBook> actual = bookStorageService.sortBooksByName();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByNameNegativeTest() throws BookStorageServiceException {
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
        List<CustomBook> actual = bookStorageService.sortBooksByName();
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortByPagesCountPositiveTest() throws BookStorageServiceException {
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
        List<CustomBook> actual = bookStorageService.sortBooksByPagesCount();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByPagesCountNegativeTest() throws BookStorageServiceException {
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
        List<CustomBook> actual = bookStorageService.sortBooksByPagesCount();
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortByPublishingYearPositiveTest() throws BookStorageServiceException {
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
        List<CustomBook> actual = bookStorageService.sortBooksByPublishingYear();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByPublishingYearNegativeTest() throws BookStorageServiceException {
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
        List<CustomBook> actual = bookStorageService.sortBooksByPublishingYear();
        assertNotEquals(actual, expected);
    }
}