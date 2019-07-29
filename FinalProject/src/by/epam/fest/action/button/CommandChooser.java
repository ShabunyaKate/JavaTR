package by.epam.fest.action.button;

import by.epam.fest.action.button.impl.*;
import by.epam.fest.action.button.impl.admin.DeleteUserCommandImpl;
import by.epam.fest.action.button.impl.admin.TableMusicianCommandImpl;
import by.epam.fest.action.button.impl.admin.TableUserCommandImpl;
import by.epam.fest.action.button.impl.musician.AddSongCommandImpl;
import by.epam.fest.action.button.impl.musician.DeleteSongCommandImpl;
import by.epam.fest.action.button.impl.TableFestivalCommandImpl;
import by.epam.fest.action.button.impl.user.RegistrationCommandImpl;
import by.epam.fest.action.button.pages.RegistrationPageCommandImpl;

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
                //
            case "musician_table":
                command=new TableMusicianCommandImpl();
                break;
            case "user_table":
                command=new TableUserCommandImpl();
                break;
            case "delete_user":
                command=new DeleteUserCommandImpl();
                break;
            case "registration_page":
                command=new RegistrationPageCommandImpl();
                break;

        }
        return command;
    }
}
