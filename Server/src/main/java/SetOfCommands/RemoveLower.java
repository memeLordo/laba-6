package SetOfCommands;

import Parameters.Person;
import ServerOperation.Message;

import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static SetOfCommands.CommandsPack.*;

public class RemoveLower extends CommandInput {
    public RemoveLower() {
        super("removelower", "удалить из коллекции все элементы, меньшие, чем у заданного параметра");
    }

    @Override
    public String go(Message message) {
        setArgument(message);
        isPeopleDataEmptyCheck();
            Person matchingPerson = getPeople_data()
                    .stream().filter((p) -> ifPersonInCollection(p, (String) argument))
                    .findFirst().orElseGet(null);
            if(matchingPerson==null) throw new NullPointerException();

            List<Person> s = getPeople_data().stream().filter(o -> o.compareTo(matchingPerson) >= 0).collect(Collectors.toList());
            Stack<Person> s1 = new Stack<>();
            s.forEach(s1::push);
            setPeople_data(s1);

//            System.out.println("<" + matchingPerson.getId() + ">");
//
//            getPeople_data().forEach(o ->
//                    System.out.println(-Comparator.comparing(Person::getName)
//                            .thenComparing(Person::getCoordinates)
//                            .thenComparing(Person::getHeight)
//                            .thenComparing(Person::getWeight)
//                            .compare(matchingPerson, o) + " " + o.getId()));




        return "Done.";
    }
}