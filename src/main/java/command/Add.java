package command;

import parameter.Person;

import static parameter.Person.PersonSet;
import static command.CommandsPack.*;

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
            System.out.println("Добавлен новый стандартный пользователь");
        } else {
            Person bebraPerson = PersonSet();
            getPeople_data().push(bebraPerson);
            sortPeopleData();
            System.out.println("Добавлен новый пользователь");
        }
    }


}
