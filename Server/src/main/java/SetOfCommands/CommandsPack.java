package SetOfCommands;

import Comparators.PersonIdComparator;
import Parameters.Person;
import ServerOperation.Message;
import xmlFiles.xmlReader;

import java.io.IOException;
import java.util.*;

public class CommandsPack {
    private static final Map<String, Command> map = new HashMap<>();
    private static final List<String> defCommandSet = new LinkedList<>();
    //public static String inputCommand = null;
    private static Stack<Person> people_data;

    static {
        try {
            people_data = xmlReader.go();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void go() {

        setCommand(new Help());
        setCommand(new InfoData());
        setCommand(new Show());
        setCommand(new Add());
        setCommand(new Clear());
        setCommand(new Contains());
        setCommand(new Exit());
        setCommand(new Head());
        setCommand(new Save());
        setCommand(new Load());
        setCommand(new ExecuteFile());
        setCommand(new UpdateID());
        setCommand(new Remove());
        setCommand(new RemoveID());
        setCommand(new RemoveFirst());
        setCommand(new RemoveLower());
        setCommand(new MaxElement());
        //type();

    }

    public static Map<String, Command> getMap() {
        return map;
    }

    public static Stack<Person> getPeople_data() {
        return people_data;
    }

    public static void setPeople_data(Stack<Person> people_data) {
        CommandsPack.people_data = people_data;
    }

    public static void isPeopleDataEmptyCheck() {
        if (people_data.empty()) throw new NoSuchElementException("В коллекции нет элементов.");
        //return !people_data.empty();
    }

    public static void sortPeopleData() {
        people_data.sort(new PersonIdComparator());
    }

    public static void putPeopleDataUp(int id) {
        Stack<Person> s1 = people_data;
        Stack<Person> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            Person temp = s1.pop();
            while (!s2.isEmpty() && s2.peek().getId() == id) {
                s1.push(s2.pop());
            }
            s2.push(temp);
        }
        people_data = s2;
    }


//    private static void type() {
//        Scanner console = new Scanner(System.in);
//        try {
//            System.out.print("~ ");
//            String command = mapFind(console.nextLine());
//            map.get(command).go();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Неверная команда. Введите 'help' для справки.");
//        } finally {
//            clearInputCommand();
//            type();
//        }
//    }

    private static void setCommand(CommandInput command) {
        map.put(command.getName(), command);
        //if (command.getDefault()) defCommandSet.add(command.getName());
    }

    private static void setCommand(Command command) {
        map.put(command.getName(), command);
        //if (command.getDefault()) defCommandSet.add(command.getName());
    }

    public static String startCommand(Message message) throws IOException {
        if(map.get(message.getCommand()) instanceof Argumentable)
        {
            return ((Argumentable) map.get(message.getCommand())).go(message);
        }
        else return map.get(message.getCommand()).go();
    }
//    public static String startCommand(Argumentable command, Message message) throws IOException {
//        return command.go(message);
//    }


}
