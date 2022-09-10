package SetOfCommands;

import static SetOfCommands.CommandsPack.*;

public class Contains extends Command {

    public Contains() {
        super("contains", "description",true);
    }
    @Override
    public void go() {
        if (CommandsPack.isPeopleDataEmpty())
            getPeople_data().stream().filter(inputCommand::equals).forEach(Show::showPerson);
    }
}
