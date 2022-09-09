package command;

import xml_processor.xmlWriter;

import static command.CommandsPack.sortPeopleData;

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
