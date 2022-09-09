package command;

import comparator.PersonIdComparator;
import parameter.Person;
import xml_processor.xmlReader;

import java.util.*;

public class CommandsPack {
    private static final Map<String, Command> map = new HashMap<>();
    private static final List<String> defCommandSet = new LinkedList<>();
    public static Integer inputID = 0;
    public static String inputCommand = null;
    private static Stack<Person> people_data = xmlReader.go();

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
        setCommand(new ExecuteFile());
        setCommand(new UpdateID());
        setCommand(new Remove());
        setCommand(new RemoveID());
        setCommand(new RemoveFirst());
        setCommand(new RemoveLower());
        setCommand(new MaxElement());

        type();

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

    public static boolean isPeopleDataEmpty() {
        if (people_data.empty()) System.out.println("В коллекции нет элементов.");
        return !people_data.empty();
    }

    public static void sortPeopleData() {
//        Stack<Person> s1 = people_data;
//        Stack<Person> s2 = new Stack<>();
//        while (!s1.isEmpty()) {
//            Person temp = s1.pop();
//
//
//            while (!s2.isEmpty() && s2.peek().getId() <= temp.getId()) {
//                if (s2.peek().getId().equals(temp.getId())) temp.setId(temp.getId() + 1);//если одинаковые id
//                s1.push(s2.pop());
//            }
//            s2.push(temp);
//        }
//        people_data = s2;
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

    //    public static String mapFind(String textLine) {
//        String command = null;
//        String[] setOfCommands = textLine.split(" ");
//        for (int i = 0; i < setOfCommands.length; i++) {
//            String check = setOfCommands[i];
//            for (Map.Entry<String, Command> set : CommandsPack.map.entrySet()) {
//                command = check.equals(set.getKey()) ? check : command;
//                isDefaultCommand = check.equals("def") || isDefaultCommand;
//            }
//            try {
//                inputID = Integer.parseInt(setOfCommands[i + 1]);
//                inputCommand = setOfCommands[i + 1];
//            } catch (ArrayIndexOutOfBoundsException ignored) {
//                return command;
//            }
//        }
//        return command;
//    }
    public static String mapFind(String textLine) {

        String[] setOfCommands = textLine.split(" ");

        try {
            inputCommand = setOfCommands[1];
            inputID = Integer.parseInt(inputCommand);

        } catch (NullPointerException e1) {
            e1.printStackTrace();
        }
        //}
        catch (ArrayIndexOutOfBoundsException | NumberFormatException ignored) {
        } finally {
            return setOfCommands[0];
        }
    }

    private static void type() {
        Scanner console = new Scanner(System.in);
        try {
            System.out.print("~ ");
            String command = mapFind(console.nextLine());
            map.get(command).go();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Неверная команда. Введите 'help' для справки.");
        } finally {
            clearInputCommand();
            type();
        }
    }

    private static void setCommand(Command command) {
        map.put(command.getName(), command);
        if (command.getDefault()) defCommandSet.add(command.getName());
    }

    private static void clearInputCommand() {
        inputCommand = "";
        inputID = 0;
    }
}
