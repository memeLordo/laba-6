package SetOfCommands;

import java.io.IOException;

import static Parameters.Person.PersonSet;
import static SetOfCommands.CommandsPack.*;

public class UpdateID extends Command {
    public UpdateID() {
        super("update", "description", true);
    }

    @Override
    public String go() throws IOException {
        int inputID = Integer.parseInt(inputCommand);
        CommandsPack.isPeopleDataEmptyCheck();
        putPeopleDataUp(inputID);
        getPeople_data().pop();
        getPeople_data().push(PersonSet(inputID));
        sortPeopleData();
        return "Пользователь изменён";
    }
}