package SetOfCommands;

import static SetOfCommands.CommandsPack.*;

public class Help extends Command{

    public Help() {
        super("help", "вывести справку по доступным командам",false);
    }

    @Override
    public void go() {
        getMap().entrySet().stream()
                            .filter(p->p.getValue().getDefault())
                .forEachOrdered(p-> System.out.println(p.getKey()+" <element>"+" : " + p.getValue().getDescription()));
        getMap().entrySet().stream()
                .filter(p->!p.getValue().getDefault())
                .forEachOrdered(p-> System.out.println(p.getKey()+" : " + p.getValue().getDescription()));
    }
}
