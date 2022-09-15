package xmlFiles;

import Exceptions.EmptyLineException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static Server.ServerRO.*;
import static SetOfCommands.Command.CreateFile;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Paths.get;

public abstract class xmlData {


    protected static String directory = "xmlFilesPack";
    protected static String path = directory + "/autosave.xml";

    public static String getPath() {
        return path;
    }

    public static String setPath() {
        try {
            addResponse("Введите название файла: ");
            sendResponse();
            path = getRequest(false);
            if (path.equals("")) throw new EmptyLineException("Имя файла");
        } catch (EmptyLineException e1) {
            addResponse(e1.getMessage());
            try {
                sendResponse();
            } catch (IOException e) {
                System.err.println("lol, server stops working");
            }
            setPath();
        } catch (IOException | ClassNotFoundException e2) {
            System.err.println("lol, server stops working again");
        }
        path = directory + "/" + path + ".xml";
        return path; //xml-files with directory
//        return path + ".xml"; //xml-files without directory
    }


    static void write(String text) throws NoSuchFileException {
        File f = new File(path);
        if (f.exists() && !f.isDirectory()){
            try (Writer translator = new OutputStreamWriter(new FileOutputStream(path), UTF_8)) {
                translator.write(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else throw new NoSuchFileException(path);
    }

    static String read() throws IOException { //
        StringBuilder line = new StringBuilder();
        try {
            checkDirectory(directory);
            //path = directory + "/" + path;
            Scanner fr = new Scanner(get(path));
            do {
                line.append(fr.nextLine()).append("\n");
            } while (fr.hasNext());
        } catch (NoSuchFileException e1) {
//            TODO создать обработку
            CreateFile(path);
        } catch (NoSuchElementException ignored) {
        }
        return line.toString();
    }

    public static void checkDirectory(String directory) throws IOException {
        if (!Files.exists(get(directory))) Files.createDirectory(get(directory));
        //Files.exists(get(directory));
    }
}
