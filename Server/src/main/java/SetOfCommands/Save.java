package SetOfCommands;


import xmlFiles.xmlWriter;

import java.nio.file.NoSuchFileException;

import static SetOfCommands.CommandsPack.sortPeopleData;
import static xmlFiles.xmlData.setPath;

public class Save extends Command {
    public Save() {
        super("save", "сохранить коллекцию в файл",false);
    }



    @Override
    public String go() {

        CreateFile(setPath());
        sortPeopleData();
        try {
            xmlWriter.go();
        } catch (NoSuchFileException e) {
            return "Something goes wrong";
        }
        return "Data saved.";
    }



}