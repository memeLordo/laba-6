package SetOfCommands;
import static SetOfCommands.CommandsPack.getPeople_data;

public class Clear extends Command {
    public Clear() {
        super("clear", "очистить коллекцию",false);
    }

    @Override
    public void go() {
        getPeople_data().forEach(
                p->getPeople_data().pop());
        System.out.println("Коллекция очищена.");
    }

}
