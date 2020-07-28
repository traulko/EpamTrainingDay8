package test.traulko.task8.controller.command.provider;

import com.traulko.task8.controller.command.Command;
import com.traulko.task8.controller.command.provider.CustomProvider;
import com.traulko.task8.controller.command.type.CommandType;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomProviderTest {
    @Test
    public void defineCommandPositiveTest() {
        Command expected = CommandType.ADD_BOOK.getCommand();
        Command actual = CustomProvider.defineCommand("ADD_BOOK");
        assertEquals(actual, expected);
    }

    @Test
    public void defineCommandNegativeTest() {
        Command expected = CommandType.ADD_BOOK.getCommand();
        Command actual = CustomProvider.defineCommand("DELETE_BOOK");
        assertNotEquals(actual, expected);
    }
}