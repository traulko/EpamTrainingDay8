package test.traulko.task8.controller.command.impl;

import com.traulko.task8.controller.command.Command;
import com.traulko.task8.controller.command.impl.FindAllCommandImpl;
import com.traulko.task8.controller.command.type.ResponseType;
import com.traulko.task8.model.entity.CustomBook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class FindAllCommandImplTest {
    Command findAllCommand;

    @BeforeClass
    public void setUp() {
        findAllCommand = new FindAllCommandImpl();
    }

    @AfterClass
    public void tearDown() {
        findAllCommand = null;
    }

    @Test
    public void executePositiveTest() {
        List<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Yanka Kupala");
        bookAuthors.add("Yakub Kolas");
        CustomBook book = new CustomBook("Book", bookAuthors, 156, 2020);
        List<String> bookAuthors2 = new ArrayList<>();
        bookAuthors2.add("Viktor Roz");
        CustomBook book2 = new CustomBook("Book2", bookAuthors2, 254, 2018);
        List<String> bookAuthors3 = new ArrayList<>();
        bookAuthors3.add("Egor Bondar");
        bookAuthors3.add("Yura Lagodich");
        CustomBook book3 = new CustomBook("Book3", bookAuthors3, 148, 2019);
        List<CustomBook> books = new ArrayList<>();
        books.add(book);
        books.add(book2);
        books.add(book3);
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
        expected.put(ResponseType.RESULT, books);
        Map<String, Object> parameters = new HashMap<>();
        Map<String, Object> actual = findAllCommand.execute(parameters);
        assertEquals(actual, expected);
    }

    @Test
    public void executeNegativeTest() {
        List<CustomBook> books = new ArrayList<>();
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
        expected.put(ResponseType.RESULT, books);
        Map<String, Object> parameters = new HashMap<>();
        Map<String, Object> actual = findAllCommand.execute(parameters);
        assertNotEquals(actual, expected);
    }
}