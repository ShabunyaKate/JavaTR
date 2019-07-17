package by.epam.musician.action;

import by.epam.musician.action.impl.DefaultCommandImpl;
import by.epam.musician.action.impl.LoginCommandImpl;
import by.epam.musician.action.impl.RegistrationCommandImpl;

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
        }

        return command;
    }
}
