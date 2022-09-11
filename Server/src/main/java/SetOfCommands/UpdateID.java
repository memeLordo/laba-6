package SetOfCommands;

import static Parameters.Person.*;
import static SetOfCommands.CommandsPack.*;

public class UpdateID extends Command {
    public UpdateID() {
        super("update", "description",true);
    }

    @Override
    public void go() {
        if (CommandsPack.isPeopleDataEmpty()){
            putPeopleDataUp(inputID);
            getPeople_data().pop();
            getPeople_data().push(PersonSet(inputID));
            sortPeopleData();
            System.out.println("Пользователь изменён");
        }
    }
}