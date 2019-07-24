package by.epam.musician.action;

import by.epam.musician.action.impl.*;
import by.epam.musician.action.impl.admin.RemoveUserCommandImpl;
import by.epam.musician.action.impl.admin.TableMusicianCommandImpl;
import by.epam.musician.action.impl.admin.TableUserCommandImpl;
import by.epam.musician.action.impl.musician.AddSongCommandImpl;
import by.epam.musician.action.impl.musician.SongTableCommandImpl;
import by.epam.musician.action.impl.musician.TableFestivalCommandImpl;
import by.epam.musician.action.impl.user.RegistrationCommandImpl;
import by.epam.musician.action.pages.RegistrationPageCommandImpl;
import by.epam.musician.action.pages.SignInPageCommandImpl;

public class CommandChooser {

    private CommandChooser() { }

    public static BaseCommand defineCommand(String action) {
        BaseCommand command = new DefaultCommandImpl();
        switch (action) {
            case "login":
                command = new LoginCommandImpl();
                break;
            case "registration":
                command = new RegistrationCommandImpl();
                break;
            case "festival_table":
                command= new TableFestivalCommandImpl();
                break;
            case "song_table":
                command=new SongTableCommandImpl();
                break;
            case "add_song":
                command=new AddSongCommandImpl();
                break;
            case "remove_song":
            //    command=new DeleteSongCommandImpl();
                break;
            case "sign_out":
                   command=new SignOutCommandImpl();
                break;
            case "musician_table":
                command=new TableMusicianCommandImpl();
                break;
            case "user_table":
                command=new TableUserCommandImpl();
                break;
            case "delete_user":
                command=new RemoveUserCommandImpl();
                break;
            case "sign_in":
                command=new SignInPageCommandImpl();
                break;
            case "registration_page":
                command=new RegistrationPageCommandImpl();
                break;

        }
        return command;
    }
}
