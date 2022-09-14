package SetOfCommands;

import java.io.IOException;

import static SetOfCommands.CommandsPack.*;

public class Remove extends Command {

    public Remove() {
        super("remove", "remove from the collection one element whose field value is equivalent to the specified", true);
    }

    @Override
    public String go() throws NullPointerException, IOException {
        if (CommandsPack.isPeopleDataEmpty()){
            putPeopleDataUp(getPeople_data().stream().filter((p) -> ifPersonInCollection(p, inputCommand)).findFirst().get().getId());
            getPeople_data().pop();
            sortPeopleData();
        }
        return "Remove completed.";
    }
}
