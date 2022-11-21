package de.kaikarren.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SerializationUtilsTests {

    @Test
    void shouldSaveObjectAsFile() throws IOException {

        SerializationUtils.saveObjectAsFile(List.of("42", "Hello", "Test"), "list.object");

        assertTrue(Files.exists(Path.of("list.object")));

        OutputUtils.deleteFileIfExists("list.object");

    }

    @Test
    void shouldLoadObjectFromFile() throws IOException, ClassNotFoundException {

        SerializationUtils.saveObjectAsFile(List.of("42", "Hello", "Test"), "list.object");

        var list = SerializationUtils.loadObjectFromFile("list.object");

        assertNotNull(list);

        assertTrue(list instanceof List);

        var castedList = (List<String>) list;

        assertEquals(3, castedList.size());

        assertEquals("Test", castedList.get(2));

        OutputUtils.deleteFileIfExists("list.object");

    }

    @Test
    void convertObjectToString() throws IOException {

        var objectAsString = SerializationUtils.objectToString(List.of("42", "Hello", "Test"));

        assertNotNull(objectAsString);

    }

    @Test
    void createObjectFromObjectString() throws IOException, ClassNotFoundException {

        var objectAsString = SerializationUtils.objectToString(List.of("42", "Hello", "Test"));

        var listObject = SerializationUtils.objectFromString(objectAsString);

        assertNotNull(listObject);

        assertTrue(listObject instanceof List);

        var castedList = (List<String>) listObject;

        assertEquals(3, castedList.size());

        assertEquals("Hello", castedList.get(1));

    }


}