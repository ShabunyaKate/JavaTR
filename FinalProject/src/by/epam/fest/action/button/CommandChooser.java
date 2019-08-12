package by.epam.fest.action.button;

import by.epam.fest.action.CommandName;
import by.epam.fest.action.button.impl.*;
import by.epam.fest.action.button.impl.admin.*;
import by.epam.fest.action.button.impl.musician.AddSongCommandImpl;
import by.epam.fest.action.button.impl.musician.DeleteSongCommandImpl;
import by.epam.fest.action.button.impl.TableFestivalCommandImpl;
import by.epam.fest.action.button.impl.user.*;
import by.epam.fest.service.ServiceFactory;

import java.util.HashMap;
import java.util.Map;

public class CommandChooser {
    private static class LazyHolder {
        public static final CommandChooser INSTANCE = new CommandChooser();
    }

    public static CommandChooser getInstance() {
        return LazyHolder.INSTANCE;
    }
    private final Map<CommandName, BaseCommand> repository = new HashMap<>();

    private CommandChooser() {
        repository.put(CommandName.ERROR, new DefaultCommandImpl());
        repository.put(CommandName.LANGUAGE, new LanguageCommandImpl());
        repository.put(CommandName.FEST_TABLE, new TableFestivalCommandImpl());
        repository.put(CommandName.SIGN_IN, new SignInCommandImpl());
        repository.put(CommandName.REGISTRATION, new RegistrationCommandImpl());
        repository.put(CommandName.BOOK_TICKET, new BookTicketCommandImpl());
        repository.put(CommandName.DELETE_USAGE, new DeleteUsageCommandImpl());
        repository.put(CommandName.TICKETS, new TicketsCommandImpl());
        repository.put(CommandName.TICKET_TABLE, new TicketTableCommandImpl());
        repository.put(CommandName.ADD_SONG, new AddSongCommandImpl());
        repository.put(CommandName.DELETE_SONG, new DeleteSongCommandImpl());
        repository.put(CommandName.ADD_DAY, new AddDayCommandImpl());
        repository.put(CommandName.ADD_MUSICIAN, new AddMusicianCommandImpl());
        repository.put(CommandName.DELETE_MUSICIAN, new DeleteMusicianCommandImpl());
        repository.put(CommandName.DELETE_USER, new DeleteUserCommandImpl());
        repository.put(CommandName.PAGE_FEST, new FestPageCommandImpl());
        repository.put(CommandName.MUSICIAN_TABLE, new TableMusicianCommandImpl());
        repository.put(CommandName.USER_TABLE, new TableUserCommandImpl());
        repository.put(CommandName.UPDATE_PRICES, new UpdatePricesCommandImpl());
        repository.put(CommandName.SIGN_OUT, new SignOutCommandImpl());
    }

//    public  BaseCommand defineCommand(String action) {
//        BaseCommand command = new DefaultCommandImpl();
//        switch (action) {
//            case "change_Lang":
//                command = new LanguageCommandImpl();
//                break;
//            //индекс
//            case "sign_in":
//                command = new SignInCommandImpl();
//                break;
//            case "registration":
//                command = new RegistrationCommandImpl();
//                break;
//            case "festival_table":
//                command = new TableFestivalCommandImpl();
//                break;
//            case "sign_out":
//                command = new SignOutCommandImpl();
//                break;
//            // музыкант
//            case "add_song":
//                command = new AddSongCommandImpl();
//                break;
//            case "delete_song":
//                command = new DeleteSongCommandImpl();
//                break;
//            // admin
//            case "user_table":
//                command = new TableUserCommandImpl();
//                break;
//            case "delete_user":
//                command = new DeleteUserCommandImpl();
//                break;
//            case "musician_table":
//                command = new TableMusicianCommandImpl();
//                break;
//            case "delete_musician":
//                command = new DeleteMusicianCommandImpl();
//                break;
//            case "add_musician":
//                command = new AddMusicianCommandImpl();
//                break;
//            case "add_day":
//                command = new AddDayCommandImpl();
//                break;
//            case "update_price":
//                command = new UpdatePricesCommandImpl();
//                break;
//            //user
//            case "delete_usage":
//                command = new DeleteUsageCommandImpl();
//                break;
//            case "book_ticket":
//                command = new BookTicketCommandImpl();
//                break;
//        }
//        return command;
//    }

    public  BaseCommand defineCommand(String action) {
        CommandName commandName = null;
        BaseCommand command = null;
        try {
            commandName= CommandName.findEnum(action);
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
           command = repository.get(CommandName.ERROR);
             }
        return command;
    }
}
