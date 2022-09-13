package SetOfCommands;

import xmlFiles.xmlWriter;

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
        xmlWriter.go();
        return "Data loaded.\n";
    }
}
