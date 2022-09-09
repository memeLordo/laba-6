package SetOfCommands;

import static SetOfCommands.CommandsPack.*;

public class RemoveID extends Command {

    public RemoveID() {
        super("removeid", "удалить элемент из коллекции по его id", true);
    }

    @Override
    public void go() throws NullPointerException {
        putPeopleDataUp(getPeople_data().stream().filter((p) -> ifPerson(p, inputCommand)).findFirst().get().getId());
        getPeople_data().pop();
        sortPeopleData();
        System.out.println("RemoveID completed.");
    }
}
