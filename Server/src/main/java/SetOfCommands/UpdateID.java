package SetOfCommands;

import ServerOperation.Message;

import java.io.IOException;

import static Parameters.Person.PersonSet;
import static SetOfCommands.CommandsPack.*;

public class UpdateID extends CommandInput {
    public UpdateID() {
        super("update", "description");
    }

    @Override
    public String go(Message message) {
        int inputID = (int)message.getArgument();
        CommandsPack.isPeopleDataEmptyCheck();
        putPeopleDataUp(inputID);
        getPeople_data().pop();
        getPeople_data().push(PersonSet(inputID));
        sortPeopleData();
        return "Пользователь изменён";
    }
}