package SetOfCommands;

import xmlFiles.xmlWriter;

import java.nio.file.NoSuchFileException;

import static SetOfCommands.CommandsPack.sortPeopleData;
import static xmlFiles.xmlData.getPath;

public class Exit extends Command{
    public Exit() {
        super("exit", "завершить программу (без сохранения в файл)",false);
    }

    @Override
    public String go() throws NoSuchFileException {
        CreateFile(getPath());
        sortPeopleData();
        xmlWriter.go();
        return "Данные сохранены.";
        //TODO разобраться с выходом из клиента
        //System.exit(0);
    }
}
