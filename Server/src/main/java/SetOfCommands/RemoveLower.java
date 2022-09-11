package SetOfCommands;

import Parameters.Person;

import java.util.Comparator;
import java.util.Stack;
import java.util.stream.Collectors;

import static SetOfCommands.CommandsPack.*;

public class RemoveLower extends Command {
    public RemoveLower() {
        super("removelower", "удалить из коллекции все элементы, меньшие, чем заданный",true);
    }

    @Override
    public void go() {
        if (CommandsPack.isPeopleDataEmpty())
        {
            Person matchingPerson=getPeople_data().stream().filter((p) -> ifPersonInCollection(p, inputCommand)).findFirst().get();
//            getPeople_data().stream().filter(o->
//                    Comparator.comparing(Person::getName)
//                            .thenComparing(Person::getCoordinates)
//                            .thenComparing(Person::getHeight)
//                            .thenComparing(Person::getWeight)
//                            .compare(matchingPerson, o) < 0).sorted().forEach(p -> System.out.println(p.getId())
////                            {
////                                putPeopleDataUp(p.getId());
////                                getPeople_data().pop();
////                            }
//            );
            System.out.println("<"+matchingPerson.getId()+">");

            getPeople_data().forEach(o->
                    System.out.println(-Comparator.comparing(Person::getName)
                            .thenComparing(Person::getCoordinates)
                            .thenComparing(Person::getHeight)
                            .thenComparing(Person::getWeight)
                            .compare(matchingPerson, o)+" " + o.getId()));
//                            {
//                                putPeopleDataUp(p.getId());
//                                getPeople_data().pop();
//                            }
//            );

        }
    }

    void sortPeopleData(int id) {
        Stack<Person> s1 = getPeople_data();
        Stack<Person> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            Person temp = s1.pop();
            if (temp.getId() <= id) s2.push(temp);
        }
        setPeople_data(s2);
    }
}
