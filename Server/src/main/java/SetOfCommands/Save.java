package SetOfCommands;


import xmlFiles.xmlWriter;

import static Server.ServerClass.addResponse;
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
        xmlWriter.go();
        return "Данные сохранены.\n";
    }



}