package SetOfCommands;

import xmlFiles.xmlWriter;

import java.nio.file.NoSuchFileException;

import static Server.ServerRO.addResponse;
import static SetOfCommands.CommandsPack.sortPeopleData;

public class Load extends Command{


    public Load() {
        super("load", "load previously saved file", true);
    }

    @Override
    public String go() {
        //TODO разобраться с отправкой
        xmlWriter.setPath();
        sortPeopleData();
        try {
            xmlWriter.go();
        } catch (NoSuchFileException e) {
            return "Baka! The file isn't exist.";
        }
        return "Data loaded.";
    }
}
