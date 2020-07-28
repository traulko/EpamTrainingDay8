package test.traulko.task8.controller;

import com.traulko.task8.controller.BookStorageController;
import com.traulko.task8.controller.command.type.ParameterType;
import com.traulko.task8.controller.command.type.ResponseType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class BookStorageControllerTest {
    @Test
    public void processRequestPositiveTest() {
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
        String currentCommand = "ADD_BOOK";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(ParameterType.NAME,"Book");
        parameters.put(ParameterType.AUTHOR, "Yanka Kupala,Yakub Kolas");
        parameters.put(ParameterType.PAGES_COUNT, 156);
        parameters.put(ParameterType.PUBLISHING_YEAR, 2020);
        Map<String, Object> actual = BookStorageController.getInstance().processRequest(currentCommand, parameters);
        assertEquals(actual, expected);
    }

    @Test
    public void processRequestNegativeTest() {
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, ResponseType.STATUS_SUCCESS);
        String currentCommand = "ADD BOOK";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(ParameterType.NAME,"Book");
        parameters.put(ParameterType.AUTHOR, "Yanka Maur");
        parameters.put(ParameterType.PAGES_COUNT, 225);
        parameters.put(ParameterType.PUBLISHING_YEAR, 2020);
        Map<String, Object> actual = BookStorageController.getInstance().processRequest(currentCommand, parameters);
        assertNotEquals(actual, expected);
    }
}