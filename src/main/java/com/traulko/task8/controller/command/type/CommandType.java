package com.traulko.task8.controller.command.type;

import com.traulko.task8.controller.command.Command;
import com.traulko.task8.controller.command.impl.*;

public enum CommandType {
    ADD_BOOK(new AddBookCommandImpl()),
    REMOVE_BOOK(new RemoveBookCommandImpl()),
    FIND_BY_ID(new FindByIdCommandImpl()),
    FIND_BY_NAME(new FindByNameCommandImpl()),
    FIND_BY_AUTHOR(new FindByAuthorCommandImpl()),
    FIND_BY_PAGES_COUNT(new FindByPagesCountCommandImpl()),
    FIND_BY_PUBLISHING_HOUSE(new FindByPublishingYearCommandImpl()),
    SORT_BY_ID(new SortByIdCommandImpl()),
    SORT_BY_NAME(new SortByNameCommandImpl()),
    SORT_BY_AUTHOR(new SortByAuthorCommandImpl()),
    SORT_BY_PAGES_COUNT(new SortByPagesCountCommandImpl()),
    SORT_BY_PUBLISHING_YEAR(new SortByPublishingYearCommandImpl()),
    FIND_ALL(new FindAllCommandImpl()),
    EMPTY_COMMAND(new EmptyCommandImpl());

    Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
