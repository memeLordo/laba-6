package SetOfCommands;
import java.io.IOException;

import static SetOfCommands.CommandsPack.*;
public class RemoveFirst extends Command {
    public RemoveFirst() {
        super("removefirst", "удалить первый элемент из коллекции");
    }
    @Override
    public String go() throws IOException {
            isPeopleDataEmptyCheck();
                putPeopleDataUp(getPeople_data().firstElement().getId());
                getPeople_data().pop();
            return "RemoveFirst completed.";
    }
}
