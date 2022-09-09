package command;
import comparator.PersonIdComparator;
import parameter.Person;

import java.util.Comparator;
import java.util.stream.Collectors;

import static command.CommandsPack.*;

public class Remove extends Command {

    public Remove() {
        super("remove", "remove from the collection one element whose field value is equivalent to the specified", true);
    }

    @Override
    public void go() throws NullPointerException {

        putPeopleDataUp(getPeople_data().stream().filter((p) -> ifPerson(p,inputCommand)).findFirst().get().getId());
        getPeople_data().pop();
        System.out.println("Remove completed.");
        sortPeopleData();
    }
}
