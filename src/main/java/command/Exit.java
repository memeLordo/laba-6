package command;

import xml_processor.xmlWriter;

import static command.CommandsPack.sortPeopleData;
import static xml_processor.xmlData.getPath;

public class Exit extends Command{
    public Exit() {
        super("exit", "завершить программу (без сохранения в файл)",false);
    }

    @Override
    public void go() {
        CreateFile(getPath());
        sortPeopleData();
        xmlWriter.go();
        System.out.println("Данные сохранены.");
        System.exit(0);
    }
}
