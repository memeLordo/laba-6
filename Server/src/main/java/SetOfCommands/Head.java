package SetOfCommands;

import Parameters.Person;

import static SetOfCommands.CommandsPack.*;

public class Head extends Command{

    public Head() {
        super("head", "вывести первый элемент коллекции",false);
    }

    @Override
    public void go() {
        if (CommandsPack.isPeopleDataEmpty())
            Show.showPerson(getPeople_data().firstElement());
    }
}
