package SetOfCommands;

import Parameters.Person;

import static SetOfCommands.CommandsPack.*;

public class Remove extends Command {

    public Remove() {
        super("remove", "remove from the collection one element whose field value is equivalent to the specified", true);
    }

    @Override
    public String go() throws NullPointerException {
        isPeopleDataEmptyCheck();
            putPeopleDataUp(getPeople_data()
                    .stream().filter((p) -> ifPersonInCollection(p, inputCommand))
                    .findFirst().orElseGet(null).getId());
            getPeople_data().pop();
            sortPeopleData();
        return "Remove completed.";
    }
//    int checkPerson(){
//        int personID = ;
//
//        if(personID==0)  throw new RuntimeException("В коллекции нет доступного элемента.");
//        return personID;
//    }
}
