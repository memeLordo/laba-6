package SetOfCommands;
import java.io.IOException;

import static SetOfCommands.CommandsPack.*;
public class RemoveFirst extends Command {
    public RemoveFirst() {
        super("removefirst", "удалить первый элемент из коллекции",false);
    }
    @Override
    public String go() throws IOException {
            if(isPeopleDataEmpty()){
                putPeopleDataUp(getPeople_data().firstElement().getId());
                getPeople_data().pop();
            }
            return "RemoveFirst completed.\n";
    }
}
