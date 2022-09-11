package SetOfCommands;
import static SetOfCommands.CommandsPack.*;
public class RemoveFirst extends Command {
    public RemoveFirst() {
        super("removefirst", "удалить первый элемент из коллекции",false);
    }
    @Override
    public void go() {
        if (CommandsPack.isPeopleDataEmpty()){
            if(isPeopleDataEmpty()){
                putPeopleDataUp(getPeople_data().firstElement().getId());
                getPeople_data().pop();
                System.out.println("RemoveFirst completed.");
            }
        }
    }
}
