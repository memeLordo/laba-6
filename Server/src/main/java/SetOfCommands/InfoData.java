package SetOfCommands;

import Server.ServerRO;

import java.util.Arrays;

import static Server.ServerRO.addResponse;
import static Server.ServerRO.getResponse;

public class InfoData extends Command{

    public InfoData() {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)",false);
    }
    private static final String[] columns ={"id","name", "coordinates","creation_date", "height", "weight","birthday", "eyeColor", "location"};
    @Override
    public String go() {
        System.out.println("Поля:");
        Arrays.stream(columns).forEachOrdered(p->addResponse(p+"\n"));
        return coolEdit(getResponse());
    }

    public static String[] getColumns() {
        return columns;
    }
}
