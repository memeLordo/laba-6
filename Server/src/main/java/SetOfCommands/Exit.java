package SetOfCommands;

import xmlFiles.xmlWriter;

import static SetOfCommands.CommandsPack.sortPeopleData;
import static xmlFiles.xmlData.getPath;

public class Exit extends Command{
    public Exit() {
        super("exit", "завершить программу (без сохранения в файл)",false);
    }

    @Override
    public String go() {
        CreateFile(getPath());
        sortPeopleData();
        xmlWriter.go();
        return "Данные сохранены.\n";
        //TODO разобраться с выходом из клиента
        //System.exit(0);
    }
}
