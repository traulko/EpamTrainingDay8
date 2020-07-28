package test.traulko.task8.controller.command.impl;

import com.traulko.task8.controller.command.Command;
import com.traulko.task8.controller.command.impl.FindByAuthorCommandImpl;
import com.traulko.task8.controller.command.type.ParameterType;
import com.traulko.task8.controller.command.type.ResponseType;
import com.traulko.task8.model.entity.BookStorage;
import com.traulko.task8.model.entity.CustomBook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class FindByAuthorCommandImplTest {
    Command findByAuthorCommand;

    @BeforeClass
    public void setUp() {
        findByAuthorCommand = new FindByAuthorCommandImpl();
    }

    @AfterClass
    public void tearDown() {
        findByAuthorCommand = null;
    }

    @Test
    public void executePositiveTest() {
        List<String> bookAuthors2 = new ArrayList<>();
        bookAuthors2.add("Viktor Roz");
        CustomBook book = new CustomBook("Book2", bookAuthors2, 254, 2018);
        List<CustomBook> books = new ArrayList<>();
        books.add(book);
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
        expected.put(ResponseType.RESULT, books);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(ParameterType.AUTHOR, "Viktor Roz");
        Map<String, Object> actual = findByAuthorCommand.execute(parameters);
        assertEquals(actual, expected);
    }

    @Test
    public void executeNegativeTest() {
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Yanka Kupala");
        bookAuthors.add("Yakub Kolas");
        CustomBook book = new CustomBook("Book", bookAuthors, 156, 2020);
        List<CustomBook> books = new ArrayList<>();
        books.add(book);
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
        expected.put(ResponseType.RESULT, books);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(ParameterType.AUTHOR, "Viktor Roz");
        Map<String, Object> actual = findByAuthorCommand.execute(parameters);
        assertNotEquals(actual, expected);
    }
}