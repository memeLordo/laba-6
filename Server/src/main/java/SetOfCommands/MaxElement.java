package SetOfCommands;

import Parameters.Color;
import Parameters.Coordinates;
import Parameters.Location;
import Parameters.Person;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

import static SetOfCommands.CommandsPack.*;
import static SetOfCommands.InfoData.getColumns;

public class MaxElement extends Command {
    public MaxElement() {
        super("maxby", "вывести любой объект из коллекции, значение заданного поля которого является максимальным",true);
    }

    @Override
    public void go() {

        if (inputCommand.equals(getColumns()[0])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getId)).get());
        if (inputCommand.equals(getColumns()[1])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getName)).get());
        if (inputCommand.equals(getColumns()[2])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getCoordinates)).get());
        if (inputCommand.equals(getColumns()[3])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getCreationDate)).get());
        if (inputCommand.equals(getColumns()[4])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getHeight)).get());
        if (inputCommand.equals(getColumns()[5])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getBirthday)).get());
        if (inputCommand.equals(getColumns()[6])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getWeight)).get());
        if (inputCommand.equals(getColumns()[7])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getEyeColor)).get());
        if (inputCommand.equals(getColumns()[8])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getLocation)).get());

    }
}
