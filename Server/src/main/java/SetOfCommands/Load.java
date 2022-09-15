package SetOfCommands;

import xmlFiles.xmlReader;
import xmlFiles.xmlWriter;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static Server.ServerRO.addResponse;
import static SetOfCommands.CommandsPack.setPeople_data;
import static SetOfCommands.CommandsPack.sortPeopleData;

public class Load extends Command{


    public Load() {
        super("load", "load previously saved file", false);
    }

    @Override
    public String go() {

        xmlWriter.setPath();
        sortPeopleData();
        try {
            setPeople_data(xmlReader.go());
        } catch (IOException e) {
            return "There is no such file here.";
        }
        return "Data loaded.";
    }
}
