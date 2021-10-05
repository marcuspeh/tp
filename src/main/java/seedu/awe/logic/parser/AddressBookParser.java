package seedu.awe.logic.parser;

import static seedu.awe.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.awe.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.awe.logic.commands.AddCommand;
import seedu.awe.logic.commands.ClearCommand;
import seedu.awe.logic.commands.Command;
import seedu.awe.logic.commands.CreateGroupCommand;
import seedu.awe.logic.commands.DeleteCommand;
import seedu.awe.logic.commands.DeleteGroupCommand;
import seedu.awe.logic.commands.EditCommand;
import seedu.awe.logic.commands.ExitCommand;
import seedu.awe.logic.commands.FindCommand;
import seedu.awe.logic.commands.HelpCommand;
import seedu.awe.logic.commands.ListContactsCommand;
import seedu.awe.logic.commands.ListGroupsCommand;
import seedu.awe.logic.parser.exceptions.EmptyGroupException;
import seedu.awe.logic.parser.exceptions.ParseException;
import seedu.awe.model.Model;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");
    private Model model;

    public AddressBookParser() {}
    public AddressBookParser(Model model) {
        this.model = model;
    }
    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException, EmptyGroupException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListContactsCommand.COMMAND_WORD:
            return new ListContactsCommand();

        case ListGroupsCommand.COMMAND_WORD:
            return new ListGroupsCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case CreateGroupCommand.COMMAND_WORD:
            return new CreateGroupCommandParser(model).parse(arguments);

        case DeleteGroupCommand.COMMAND_WORD:
            return new DeleteGroupCommandParser(model).parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}