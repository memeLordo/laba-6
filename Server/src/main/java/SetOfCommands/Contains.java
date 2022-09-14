package SetOfCommands;

import java.io.IOException;

import static SetOfCommands.CommandsPack.*;

public class Contains extends Command {

    public Contains() {
        super("contains", "description",true);
    }
    @Override
    public String go() throws IOException {
        if (CommandsPack.isPeopleDataEmpty())
            getPeople_data().stream().filter(inputCommand::equals).forEach(Show::showPerson);
        return coolEdit(Show.getMessage());
    }
}
