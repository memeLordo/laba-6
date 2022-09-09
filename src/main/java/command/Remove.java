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

//        if (this.findIn(CommandsPack.inputCommand)){
//            putPeopleDataUp(currentPerson.getId());
//            getPeople_data().pop();
//            sortPeopleData();
//            System.out.println("Пользователь удалён.");
//        }
//    }
//
//    @Override
//    public boolean findIn(Object obj) {
//        String line = obj.toString();
//        boolean trigger = true;
//        for (Person p : getPeople_data()) {
//            if (ifPerson(p, line)){
//                currentPerson = p;
//                trigger = false;
//            }
//        }
//        if (trigger) System.err.println("Нет такого элемента.");
//        return !trigger;
    }
}
