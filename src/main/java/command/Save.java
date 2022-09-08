package command;


import xml_processor.xmlWriter;

import static command.CommandsPack.sortPeopleData;

public class Save extends Command {
    public Save() {
        super("save", "сохранить коллекцию в файл",true);
    }



    @Override
    public void go() {
        CreateFile(xmlWriter.setPath());
        sortPeopleData();
        xmlWriter.go();
        System.out.println("Данные сохранены.");
    }



}
