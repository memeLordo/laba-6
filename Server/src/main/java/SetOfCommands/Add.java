package SetOfCommands;

import Parameters.Person;


import static SetOfCommands.CommandsPack.getPeople_data;
import static Parameters.Person.PersonSet;
import static SetOfCommands.CommandsPack.*;

public class Add extends Command {


    public Add() {
        super("add", "добавить новый элемент в коллекцию", true);
    }

    @Override
    public String go() {

        if (inputCommand.equals("def")){
            Person bebra = new Person();
            getPeople_data().push(bebra);
            sortPeopleData();
            return "New default user added.\n";
        } else {
            Person bebraPerson = PersonSet();
            getPeople_data().push(bebraPerson);
            sortPeopleData();
            return "New user added.\n";
        }
    }


}
