package SetOfCommands;

import java.io.IOException;

import static SetOfCommands.CommandsPack.*;

public class Head extends Command{

    public Head() {
        super("head", "вывести первый элемент коллекции",false);
    }

    @Override
    public String go() throws IOException {
        if (CommandsPack.isPeopleDataEmpty())
            Show.showPerson(getPeople_data().firstElement());
        return Show.getMessage();
    }
}
