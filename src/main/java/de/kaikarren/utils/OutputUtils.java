package de.kaikarren.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputUtils {

    public static void writeStringToFile(String filePath, String fileContent) throws IOException {

        try (var writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(fileContent);
        }

    }

    public static void appendStringToFile(String filePath, String contentToAppend) throws IOException {

        try (var writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(contentToAppend);
        }

    }

    public static void deleteFileIfExists(String path) throws IOException {

        Files.deleteIfExists(Path.of(path));

    }

    public static void writeByteArrayToFile(String filename, byte[] bytes) throws IOException {

        try (FileOutputStream outputStream = new FileOutputStream(filename)) {
            outputStream.write(bytes);
        }

    }

}
