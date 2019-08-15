package by.epam.fest.action.button;

import by.epam.fest.action.CommandName;
import by.epam.fest.action.button.impl.*;
import by.epam.fest.action.button.impl.admin.*;
import by.epam.fest.action.button.impl.musician.AddSongCommandImpl;
import by.epam.fest.action.button.impl.musician.DeleteSongCommandImpl;
import by.epam.fest.action.button.impl.TableFestivalCommandImpl;
import by.epam.fest.action.button.impl.user.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.HashMap;
import java.util.Map;

/**Singletone
 */
public class CommandChooser {
    private static Logger logger = LogManager.getLogger(CommandChooser.class);
    private static class LazyHolder {
        public static final CommandChooser INSTANCE = new CommandChooser();
    }

    public static CommandChooser getInstance() {
        return LazyHolder.INSTANCE;
    }
    private final Map<CommandName, BaseCommand> repository = new HashMap<>();

    /**
     * pairs key Command enum values child of BaseCommand
     */
    private CommandChooser() {
        repository.put(CommandName.ERROR, new DefaultCommandImpl());
        repository.put(CommandName.LANGUAGE, new LanguageCommandImpl());
        repository.put(CommandName.FEST_TABLE, new TableFestivalCommandImpl());
        repository.put(CommandName.SIGN_IN, new SignInCommandImpl());
        repository.put(CommandName.REGISTRATION, new RegistrationCommandImpl());
        repository.put(CommandName.BOOK_TICKET, new BookTicketCommandImpl());
        repository.put(CommandName.DELETE_USAGE, new DeleteUsageCommandImpl());
        repository.put(CommandName.ADD_SONG, new AddSongCommandImpl());
        repository.put(CommandName.DELETE_SONG, new DeleteSongCommandImpl());
        repository.put(CommandName.ADD_DAY, new AddDayCommandImpl());
        repository.put(CommandName.ADD_MUSICIAN, new AddMusicianCommandImpl());
        repository.put(CommandName.DELETE_MUSICIAN, new DeleteMusicianCommandImpl());
        repository.put(CommandName.DELETE_USER, new DeleteUserCommandImpl());
        repository.put(CommandName.MUSICIAN_TABLE, new TableMusicianCommandImpl());
        repository.put(CommandName.USER_TABLE, new TableUserCommandImpl());
        repository.put(CommandName.UPDATE_PRICES, new UpdatePricesCommandImpl());
        repository.put(CommandName.SIGN_OUT, new SignOutCommandImpl());
    }

    /**Get enum representation of action
     * than get from map command
     * @param action
     * @return
     */
    public  BaseCommand defineCommand(String action) {
        CommandName commandName = null;
        BaseCommand command = null;
        try {
            commandName= CommandName.findEnum(action);
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
           command = repository.get(CommandName.ERROR);
             }
        logger.info("new Command",command);
        return command;
    }
}
