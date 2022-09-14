package SetOfCommands;
import static SetOfCommands.CommandsPack.getPeople_data;

public class Clear extends Command {
    public Clear() {
        super("clear", "очистить коллекцию",false);
    }

    @Override
    public String go() {
        getPeople_data().forEach(
                p->getPeople_data().pop());
        return "Коллекция очищена.";
    }

}
