package SetOfCommands;

import Parameters.Person;


import static Server.ServerClass.addResponse;
import static SetOfCommands.CommandsPack.getPeople_data;
import static Parameters.Person.PersonSet;
import static SetOfCommands.CommandsPack.*;

public class Add extends Command {


    public Add() {
        super("add", "добавить новый элемент в коллекцию", true);
    }

    @Override
    public void go() {

        if (inputCommand.equals("def")){
            Person bebra = new Person();
            getPeople_data().push(bebra);
            sortPeopleData();
            addResponse("New default user added.");
        } else {
            Person bebraPerson = PersonSet();
            getPeople_data().push(bebraPerson);
            sortPeopleData();
            addResponse("New user added.");
        }
    }


}
