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

        if (inputCommand.equals(getColumns()[0])) System.out.println(getPeople_data().stream().max(Comparator.comparing(Person::getId)).get().getId());
        if (inputCommand.equals(getColumns()[1])) System.out.println(getPeople_data().stream().max(Comparator.comparing(Person::getName)).get().getName());
        if (inputCommand.equals(getColumns()[2])) System.out.println(getPeople_data().stream().max(Comparator.comparing(Person::getCoordinates)).get().getCoordinates());
        if (inputCommand.equals(getColumns()[3])) System.out.println(getPeople_data().stream().max(Comparator.comparing(Person::getCreationDate)).get().getCreationDate());
        if (inputCommand.equals(getColumns()[4])) System.out.println(getPeople_data().stream().max(Comparator.comparing(Person::getHeight)).get().getHeight());
        if (inputCommand.equals(getColumns()[5])) System.out.println(getPeople_data().stream().max(Comparator.comparing(Person::getBirthday)).get().getBirthday());
        if (inputCommand.equals(getColumns()[6])) System.out.println(getPeople_data().stream().max(Comparator.comparing(Person::getWeight)).get().getWeight());
        if (inputCommand.equals(getColumns()[7])) System.out.println(getPeople_data().stream().max(Comparator.comparing(Person::getEyeColor)).get().getEyeColor());
        if (inputCommand.equals(getColumns()[8])) System.out.println(getPeople_data().stream().max(Comparator.comparing(Person::getLocation)).get().getLocation());




//        for (Person chel : getPeople_data()) {
//            maxId = chel.getId() > maxId.get() ? chel.getId() : maxId;
//            maxHeight = chel.getHeight() > maxHeight ? chel.getHeight() : maxHeight;
//            maxWeight = chel.getWeight() > maxWeight ? chel.getWeight() : maxWeight;
//            maxBirth = chel.getBirthday().isAfter(maxBirth) ? chel.getBirthday() : maxBirth;
//        }
//        if (inputCommand.equals(getColumns()[0])) this.findIn(maxId);
//        else if (inputCommand.equals(getColumns()[4])) this.findIn(maxHeight);
//        else if (inputCommand.equals(getColumns()[5])) this.findIn(maxWeight);
//        else if (inputCommand.equals(getColumns()[6])) this.findIn(maxBirth);
//        else System.out.println("Такого элемента нет. Введите 'info' для справки.");
    }
}
