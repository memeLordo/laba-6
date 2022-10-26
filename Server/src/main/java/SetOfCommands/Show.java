package SetOfCommands;

import Parameters.Person;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import static SetOfCommands.CommandsPack.getPeople_data;
import static SetOfCommands.CommandsPack.isPeopleDataEmptyCheck;

public class Show extends Command {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy H:mm:ss");
    private static String message;

    public Show() {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        Show.message = message;
    }

    public static void showPerson(Person person) {

        format(person.getId());
        message += "Имя: " + person.getName() + "\n";
        message += "Координаты: " + person.getCoordinates() + "\n";
        message += "Дата создания: " + dateFormat.format(person.getCreationDate()) + "\n";
        message += "Рост: " + person.getHeight() + " см\n";
        message += "Вес: " + person.getWeight() + " кг\n";
        message += "День рождения: " + person.getBirthday() + "\n";
        message += "Цвет глаз: " + person.getEyeColor().getName() + "\n";
        message += "Местоположение: " + person.getLocation() + "\n";
        message += "===========================\n";
    }

    private static void format(Object f) {
        message += "id: " + new DecimalFormat("000000000").format(f) + "\n";
    }

    @Override
    public String go() throws IOException {

        isPeopleDataEmptyCheck();
        message = "===========================\n";
        getPeople_data().forEach(Show::showPerson);
        return coolEdit(message);
    }

}