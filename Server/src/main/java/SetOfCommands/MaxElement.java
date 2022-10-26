package SetOfCommands;

import Parameters.Person;
import ServerOperation.Message;

import java.util.Comparator;

import static SetOfCommands.CommandsPack.*;
import static SetOfCommands.InfoData.getColumns;

public class MaxElement extends CommandInput {
    public MaxElement() {
        super("maxby", "вывести любой объект из коллекции, значение заданного поля которого является максимальным");
    }

    @Override
    public String go(Message message) {
        setArgument(message);
        if (argument.equals(getColumns()[0])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getId)).get());
        else if (argument.equals(getColumns()[1])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getName)).get());
        else if (argument.equals(getColumns()[2])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getCoordinates)).get());
        else if (argument.equals(getColumns()[3])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getCreationDate)).get());
        else if (argument.equals(getColumns()[4])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getHeight)).get());
        else if (argument.equals(getColumns()[5])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getBirthday)).get());
        else if (argument.equals(getColumns()[6])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getWeight)).get());
        else if (argument.equals(getColumns()[7])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getEyeColor)).get());
        else if (argument.equals(getColumns()[8])) Show.showPerson(getPeople_data().stream().max(Comparator.comparing(Person::getLocation)).get());
        else throw new NullPointerException();
        return Show.getMessage();
    }
}
