package ServerOperation;

import java.io.Serializable;

public class Message<T extends Serializable> implements Serializable {
    private String command;
    private T argument;

    public Message(String command, T argument) {
        this.command = command;
        this.argument = argument;
    }

    public T getArgument() {
        return argument;
    }

    public void setArgument(T argument) {
        this.argument = argument;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
    public static Message<String> mapFind(String textLine) {
        String inputCommand = "";
        String[] setOfCommands = textLine.split(" ");
        try {

            inputCommand=setOfCommands[1];

        } catch (NullPointerException e1) {
            e1.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ignored) {}
        finally {
            return new Message<>(setOfCommands[0],inputCommand);
        }
    }

    @Override
    public String toString() {
        return  "command='" + command + '\'' +
                ", argument='" + argument + "'";
    }
    //    public static void clearInputCommand() {
//        inputCommand = "";
//    }
}
