package by.epam.fest.action.button;

import by.epam.fest.action.button.impl.*;
import by.epam.fest.action.button.impl.admin.*;
import by.epam.fest.action.button.impl.musician.AddSongCommandImpl;
import by.epam.fest.action.button.impl.musician.DeleteSongCommandImpl;
import by.epam.fest.action.button.impl.TableFestivalCommandImpl;
import by.epam.fest.action.button.impl.user.BookTicketCommandImpl;
import by.epam.fest.action.button.impl.user.DeleteUsageCommandImpl;
import by.epam.fest.action.button.impl.user.RegistrationCommandImpl;

public class CommandChooser {

    private CommandChooser() { }

    public static BaseCommand defineCommand(String action) {
        BaseCommand command = new DefaultCommandImpl();
        switch (action) {
            //индекс
            case "sign_in":
                command=new SignInCommandImpl();
                break;
            case "registration":
                command = new RegistrationCommandImpl();
                break;
            case "festival_table":
                command= new TableFestivalCommandImpl();
                break;
            case "sign_out":
                command=new SignOutCommandImpl();
                break;
            // музыкант
            case "add_song":
                command=new AddSongCommandImpl();
                break;
            case "delete_song":
                command=new DeleteSongCommandImpl();
                break;
                // admin
            case "user_table":
                command=new TableUserCommandImpl();
                break;
            case "delete_user":
                command=new DeleteUserCommandImpl();
                break;
            case "musician_table":
                command=new TableMusicianCommandImpl();
                break;
            case "delete_musician":
                command=new DeleteMusicianCommandImpl();
                break;
            case "add_musician":
                command=new AddMusicianCommandImpl();
                break;
            case "add_day":
                command=new AddDayCommandImpl();
                break;
                //user
            case "delete_usage":
                command=new DeleteUsageCommandImpl();
                break;
            case "book_ticket":
                command=new BookTicketCommandImpl();
                break;
        }
        return command;
    }
}
