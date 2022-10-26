package SetOfCommands;

import static SetOfCommands.CommandsPack.getPeople_data;

public class Clear extends Command {
    public Clear() {
        super("clear", "очистить коллекцию");
    }

    @Override
    public String go() {
        getPeople_data().clear();
        return "Коллекция очищена.";
    }

}
