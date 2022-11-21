package de.kaikarren.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InputUtils {

    public static String readFileAsString(String filePath) throws IOException {

        return Files.readString(Path.of(filePath));

    }

    public static File[] listAllFilesInAFolder(String folderPath){

        File folder = new File(folderPath);

        return folder.listFiles();
    }

    public static List<File> listAllFilesRecursive(String rootPath){

        var filesPerDirectory = new ArrayList<File>();

        var files = listAllFilesInAFolder(rootPath);

        for(var file : files){

            if(file.isDirectory()){

                filesPerDirectory.addAll(listAllFilesRecursive(file.getAbsolutePath()));

            } else {
                filesPerDirectory.add(file);
            }

        }

        return filesPerDirectory;

    }

    public static InputStream getInputStreamFromString(String content){

        return new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));

    }

}
