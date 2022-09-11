package SetOfCommands;

import xmlFiles.xmlWriter;

import static Server.ServerClass.setResponse;
import static SetOfCommands.CommandsPack.sortPeopleData;
import static xmlFiles.xmlData.getPath;

public class Exit extends Command{
    public Exit() {
        super("exit", "завершить программу (без сохранения в файл)",false);
    }

    @Override
    public void go() {
        CreateFile(getPath());
        sortPeopleData();
        xmlWriter.go();
        setResponse("Данные сохранены.");
        System.exit(0);
    }
}
