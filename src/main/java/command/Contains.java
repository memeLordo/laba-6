package command;
import static command.CommandsPack.getPeople_data;
import static command.CommandsPack.inputCommand;

public class Contains extends Command {

    public Contains() {
        super("contains", "description",true);
    }
    @Override
    public void go() {
        try {
            getPeople_data().stream().filter(inputCommand::equals).forEach(Show::showPerson);
//            this.findIn(inputCommand);
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
