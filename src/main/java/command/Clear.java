package command;
import static command.CommandsPack.getPeople_data;

public class Clear extends Command {
    public Clear() {
        super("clear", "очистить коллекцию",false);
    }

    @Override
    public void go() {
        while (!getPeople_data().empty())
            getPeople_data().pop();
        System.out.println("Коллекция очищена.");
    }

}
