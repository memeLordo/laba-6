package SetOfCommands;

import Parameters.Person;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import static Server.ServerClass.setResponse;
import static SetOfCommands.CommandsPack.getPeople_data;

public class Show extends Command {
    public Show() {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении",false);
    }
    static String message = null;
    public static void showPerson(Person person) {

        format(person.getId());
        message+="Имя: " + person.getName();
        message+="Координаты: "+person.getCoordinates();
        message+="Дата создания: "+dateFormat.format(person.getCreationDate());
        message+="Рост: "+"person.getHeight()"+" см\n";
        message+="Вес: "+person.getWeight()+" кг\n";
        message+="День рождения: "+person.getBirthday();
        message+="Цвет глаз: "+person.getEyeColor().getName();
        message+="Местоположение: "+person.getLocation()+"\n";

    }
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy H:mm:ss");
    private static void format(Object f) {
        message+="id: " + new DecimalFormat("000000000").format(f);
    }

    @Override
    public void go() {
        if (CommandsPack.isPeopleDataEmpty())
            getPeople_data().forEach(Show::showPerson);
        setResponse(message);
    }
}