package de.kaikarren.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * Reads given resource file as a string.
     *
     * @param fileName      The path to the resource file
     * @return              The file's contents as String
     * @throws IOException  If read fails for any reason
     *
     * Based on https://stackoverflow.com/questions/6068197/read-resource-text-file-to-string-in-java
     */
    public static String getResourceFileAsString(String fileName) throws IOException {

        var classLoader = ClassLoader.getSystemClassLoader();

        try (InputStream is = classLoader.getResourceAsStream(fileName)) {

            if (is == null) return null;

            try (
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader reader = new BufferedReader(isr)
            ) {
                 return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }

        }

    }

}
