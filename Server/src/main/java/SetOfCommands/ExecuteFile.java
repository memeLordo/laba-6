package SetOfCommands;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import static SetOfCommands.CommandsPack.*;

public class ExecuteFile extends Command{
    public ExecuteFile() {
        super("execute", "description", true);
    }

    @Override
    public void go() {
        String filename  = inputCommand == null ?"commands.txt":inputCommand+".txt";
//        String directory = "executeFilesPack";
//        try {
//            xmlData.checkDirectory(directory);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        filename = directory +"/"+filename;
        CreateFile(filename);
        ScanFile(filename);
    }
    private void ScanFile(String text){
        Scanner console = null;
        String path, err;
        try {
            console = new Scanner(Path.of(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert console != null;
        console.useDelimiter(System.getProperty("line.separator"));
        while(console.hasNext()){
            try {
                path = mapFind(console.nextLine());
                getMap().get(path).go();    //вызов команды
            }catch (Exception ignored){}

        }
    }
}
