package SetOfCommands;

import ServerOperation.Message;

public abstract class CommandInput extends Command implements Argumentable{

    protected Object argument;

    public CommandInput(String name, String description) {
        super(name, description);
    }

//    @Override
//    public String go(Message message) {
//        setArgument(message);
//        return null;
//    }
    @Override
    public void setArgument(Message request) {
        argument = request.getArgument();
    }
}
