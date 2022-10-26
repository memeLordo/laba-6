package ServerOperation;

import Parameters.Person;

public class ServerRequestClass {
    String command;
    Person PersonData;
    public ServerRequestClass(String command, Person person) {
        super(command,person);
    }
}
