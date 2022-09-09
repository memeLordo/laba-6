package SetOfCommands;


import xmlFiles.xmlWriter;

import static SetOfCommands.CommandsPack.sortPeopleData;
import static xmlFiles.xmlData.setPath;

public class Save extends Command {
    public Save() {
        super("save", "сохранить коллекцию в файл",false);
    }



    @Override
    public void go() {

        CreateFile(setPath());
        sortPeopleData();
        xmlWriter.go();
        System.out.println("Данные сохранены.");
    }



}
