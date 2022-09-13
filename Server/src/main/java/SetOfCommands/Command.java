package SetOfCommands;

import Parameters.Person;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

import static Server.ServerRO.addResponse;
import static SetOfCommands.CommandsPack.getPeople_data;

public abstract class Command {
    private final String name;
    private final String description;
    private final boolean isDefault;

    public Command(String name, String description, boolean isDefault) {
        this.name = name;
        this.description = description;
        this.isDefault = isDefault;
    }

    public static void CreateFile(String name) {
        try {
            File f = new File(name);
            if (f.createNewFile())
                addResponse("Инициализация файла...\n");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public boolean findIn(@NotNull Object obj) {//ненужная функция
        String line = obj.toString();
        boolean trigger = true;

        trigger=getPeople_data().stream().noneMatch(p-> ifPersonInCollection(p, line));

//        for (Person p : getPeople_data()) {
//            if (ifPerson(p, line)){
//                trigger = false;
//            }
//        }
        if (trigger) System.out.println("Нет такого элемента.");
        return !trigger;
    }

    public boolean ifPersonInCollection(@NotNull Person p, String inputText) {
        return p.getId().toString().equals(inputText) |
                p.getName().contains(inputText) |
                p.getCoordinates().contains(inputText) |
                p.getHeight().toString().equals(inputText) |
                p.getWeight().toString().equals(inputText) |
                p.getCreationDate().toString().equals(inputText) |
                p.getBirthday().toString().equals(inputText) |
                p.getEyeColor().toString().equals(inputText) |
                p.getLocation().contains(inputText);
    }



    public boolean getDefault() {
        return isDefault;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract String go() throws IOException;
}
