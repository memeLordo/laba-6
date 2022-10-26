package SetOfCommands;

import java.io.IOException;

import static SetOfCommands.CommandsPack.*;
import static SetOfCommands.Show.setMessage;

public class Head extends Command{

    public Head() {
        super("head", "вывести первый элемент коллекции");
    }

    @Override
    public String go() throws IOException {
        isPeopleDataEmptyCheck();
        setMessage("===========================\n");
            Show.showPerson(getPeople_data().firstElement());
        return coolEdit(Show.getMessage());
    }
}
