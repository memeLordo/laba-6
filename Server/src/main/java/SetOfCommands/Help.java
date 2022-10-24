package SetOfCommands;

import Server.ServerRO;

import static Server.ServerRO.addResponse;
import static Server.ServerRO.getResponse;
import static SetOfCommands.CommandsPack.*;

public class Help extends Command{

    public Help() {
        super("help", "вывести справку по доступным командам",false);
    }

    @Override
    public String go() {
        getMap().forEach((key, value) -> {
            if (value.getDefault())
                addResponse(key + " <element>" + " : " + value.getDescription() + "\n");
            else addResponse(key + " : " + value.getDescription() + "\n");
        });
        return coolEdit(getResponse());//косметика
    }
}
