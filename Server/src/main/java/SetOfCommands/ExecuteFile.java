package SetOfCommands;

import ServerOperation.Message;
import xmlFiles.xmlData;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

import static Server.ServerRO.*;
import static ServerOperation.Message.mapFind;
import static SetOfCommands.CommandsPack.*;

public class ExecuteFile extends CommandInput{
    public ExecuteFile() {
        super("execute", "description");
    }

//    @Override
//    public String go() {
//
//        String filename  = Objects.equals(inputCommand, "") ?"commands.txt":inputCommand+".txt";
////        String directory = "executeFilesPack";
////        try {
////            xmlData.checkDirectory(directory);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        filename = directory +"/"+filename;
//        CreateFile(filename);
//        ScanFile(filename);
//        return coolEdit(getResponse());
//    }


    @Override
    public String go(Message message) {
        setArgument(message);
        String filename  = Objects.equals(argument, "") ?"commands.txt":argument+".txt";
        String directory = "executeFilesPack";
        try {
            xmlData.checkDirectory(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
        filename = directory +"/"+filename;
        CreateFile(filename);
        ScanFile(filename);
        return coolEdit(getResponse());
    }

    private void ScanFile(String text){
        Scanner console = null;
//        String path, argument, err;
        try {
            console = new Scanner(Path.of(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert console != null;
        console.useDelimiter(System.getProperty("line.separator"));
        while(console.hasNext()){
            try {
                Message message = mapFind(console.nextLine());

                addResponse(startCommand(message)+"\n");    //вызов команды

            }catch (Exception ignored){}    //игнорирует неправильные команды

        }
    }


}
