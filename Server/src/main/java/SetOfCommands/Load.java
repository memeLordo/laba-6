package SetOfCommands;

import ServerOperation.Message;
import xmlFiles.xmlReader;
import xmlFiles.xmlWriter;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static Server.ServerRO.addResponse;
import static SetOfCommands.CommandsPack.setPeople_data;
import static SetOfCommands.CommandsPack.sortPeopleData;

public class Load extends CommandInput{


    public Load() {
        super("load", "load previously saved file");
    }

    @Override
    public String go(Message message) {
        setArgument(message);
        xmlWriter.setPath((String) argument);
        sortPeopleData();
        try {
            setPeople_data(xmlReader.go());
        } catch (IOException e) {
            return "There is no such file here.";
        }
        return "Data loaded.";
    }
}
