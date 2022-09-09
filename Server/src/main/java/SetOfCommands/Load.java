package SetOfCommands;

import xmlFiles.xmlWriter;

import static SetOfCommands.CommandsPack.sortPeopleData;

public class Load extends Command{


    public Load() {
        super("load", "load previously saved file", true);
    }

    @Override
    public void go() {
        xmlWriter.setPath();
        sortPeopleData();
        xmlWriter.go();
        System.out.println("Data loaded.");
    }
}
