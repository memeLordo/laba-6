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
        getMap().entrySet().stream()
                            .filter(p->p.getValue().getDefault())
                .forEachOrdered(p-> addResponse(p.getKey()+" <element>"+" : " + p.getValue().getDescription()+"\n"));
        getMap().entrySet().stream()
                .filter(p->!p.getValue().getDefault())
                .forEachOrdered(p-> addResponse(p.getKey()+" : " + p.getValue().getDescription()+"\n"));
        return coolEdit(getResponse());//косметика
    }
}
