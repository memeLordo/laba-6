package SetOfCommands;

import Parameters.Person;
import ServerOperation.Message;


import java.lang.reflect.Member;

import static SetOfCommands.CommandsPack.getPeople_data;
import static Parameters.Person.PersonSet;
import static SetOfCommands.CommandsPack.*;

public class Add extends CommandInput {


    public Add() {
        super("add", "добавить новый элемент в коллекцию");
    }

    @Override
    public String go(Message message) {
            getPeople_data().push((Person) message.getArgument());
            sortPeopleData();
            return "New user added.";
//
//            Person bebraPerson = (Person) message.getArgument();
//            getPeople_data().push(bebraPerson);
//            sortPeopleData();
//            return "New user added.";

    }


}
