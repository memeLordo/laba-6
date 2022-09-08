package command;
import static command.CommandsPack.inputCommand;

public class Contains extends Command {

    public Contains() {
        super("contains", "description",true);
    }
    @Override
    public void go() {
        this.findIn(inputCommand);
    }
}
