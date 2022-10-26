package SetOfCommands;


import ServerOperation.Message;
import xmlFiles.xmlWriter;

import java.nio.file.NoSuchFileException;

import static SetOfCommands.CommandsPack.sortPeopleData;
import static xmlFiles.xmlData.setPath;

public class Save extends CommandInput {
    public Save() {
        super("save", "сохранить коллекцию в файл");
    }



    @Override
    public String go(Message message) {

        CreateFile(setPath((String) message.getArgument()));
        sortPeopleData();
        try {
            xmlWriter.go();
        } catch (NoSuchFileException e) {
            throw new RuntimeException("File isn't exist");
        }
        return "Data saved.";
    }



}