package test.traulko.task8.controller.command.impl;

import com.traulko.task8.controller.command.Command;
import com.traulko.task8.controller.command.impl.EmptyCommandImpl;
import com.traulko.task8.controller.command.type.ResponseType;
import com.traulko.task8.model.entity.BookStorage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class EmptyCommandImplTest {
    Command emptyCommand;

    @BeforeClass
    public void setUp() {
        emptyCommand = new EmptyCommandImpl();
    }

    @AfterClass
    public void tearDown() {
        emptyCommand = null;
    }

    @Test
    public void executePositiveTest() {
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, "EMPTY COMMAND");
        Map<String, Object> actual = emptyCommand.execute(new HashMap<>());
        assertEquals(actual, expected);
    }

    @Test
    public void executeNegativeTest() {
        Map<String, Object> expected = new HashMap<>();
        expected.put(ResponseType.STATUS, "");
        Map<String, Object> actual = emptyCommand.execute(new HashMap<>());
        assertNotEquals(actual, expected);
    }
}