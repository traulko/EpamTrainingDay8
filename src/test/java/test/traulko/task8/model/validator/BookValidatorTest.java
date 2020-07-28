package test.traulko.task8.model.validator;

import com.traulko.task8.model.validator.BookValidator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BookValidatorTest {
    BookValidator bookValidator;

    @BeforeClass
    public void setUp() {
        bookValidator = new BookValidator();
    }

    @AfterClass
    public void tearDown() {
        bookValidator = null;
    }

    @Test
    public void isCorrectNamePositiveTest() {
        boolean actual = bookValidator.isCorrectName("Name");
        assertTrue(actual);
    }

    @Test
    public void isCorrectNameNegativeTest() {
        boolean actual = bookValidator.isCorrectName(null);
        assertFalse(actual);
    }

    @Test
    public void isCorrectAuthorPositiveTest() {
        boolean actual = bookValidator.isCorrectAuthor("Author");
        assertTrue(actual);
    }

    @Test
    public void isCorrectAuthorNegativeTest() {
        boolean actual = bookValidator.isCorrectAuthor(null);
        assertFalse(actual);
    }

    @Test
    public void isCorrectPagesCountPositiveTest() {
        boolean actual = bookValidator.isCorrectPagesCount(100);
        assertTrue(actual);
    }

    @Test
    public void isCorrectPagesCountNegativeTest() {
        boolean actual = bookValidator.isCorrectPagesCount(-1);
        assertFalse(actual);
    }

    @Test
    public void isCorrectPublishingYearPositiveTest() {
        boolean actual = bookValidator.isCorrectPublishingYear(2020);
        assertTrue(actual);
    }

    @Test
    public void isCorrectPublishingYearNegativeTest() {
        boolean actual = bookValidator.isCorrectPublishingYear(2021);
        assertFalse(actual);
    }

    @Test
    public void isCorrectIndexPositiveTest() {
        boolean actual = bookValidator.isCorrectIndex(12);
        assertTrue(actual);
    }

    @Test
    public void isCorrectIndexNegativeTest() {
        boolean actual = bookValidator.isCorrectIndex(-1);
        assertFalse(actual);
    }
}