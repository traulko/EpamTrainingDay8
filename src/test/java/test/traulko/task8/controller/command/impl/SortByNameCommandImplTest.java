package test.traulko.task8.controller.command.impl;

import com.traulko.task8.controller.command.Command;
import com.traulko.task8.controller.command.impl.SortByIdCommandImpl;
import com.traulko.task8.controller.command.impl.SortByNameCommandImpl;
import com.traulko.task8.controller.command.type.ResponseType;
import com.traulko.task8.model.entity.CustomBook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class SortByNameCommandImplTest {
    Command sortByNameCommand;

    @BeforeClass
    public void setUp() {
        sortByNameCommand = new SortByNameCommandImpl();
    }

    @AfterClass
    public void tearDown() {
        sortByNameCommand = null;
    }

    @Test
    public void executePositiveTest() {
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
        List<CustomBook> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
        expected.put(ResponseType.RESULT, books);
        Map<String, Object> parameters = new HashMap<>();
        Map<String, Object> actual = sortByNameCommand.execute(parameters);
        assertEquals(actual, expected);
    }

    @Test
    public void executeNegativeTest() {
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
        List<CustomBook> books = new ArrayList<>();
        books.add(book3);
        books.add(book1);
        books.add(book2);
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
        expected.put(ResponseType.RESULT, books);
        Map<String, Object> parameters = new HashMap<>();
        Map<String, Object> actual = sortByNameCommand.execute(parameters);
        assertNotEquals(actual, expected);
    }
}