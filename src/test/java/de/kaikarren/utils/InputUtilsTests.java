package de.kaikarren.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputUtilsTests {

    @Test
    void readFileAsString() throws IOException {

        var fileContentAsString = InputUtils.readFileAsString("test.txt");

        assertEquals("This is an example content.", fileContentAsString);

    }

    @Test
    void listAllFilesInAFolder() {

        var files = InputUtils.listAllFilesInAFolder("gradle");

        assertEquals(1, files.length);

        assertEquals("wrapper", files[0].getName());

    }

    @Test
    void listAllFilesRecursive() {

        var files = InputUtils.listAllFilesRecursive("gradle");

        assertEquals(2, files.size());

    }

    @Test
    void getResourceFileAsString() throws IOException {

        var fileAsString = InputUtils.getResourceFileAsString("test.txt");

        assertNotNull(fileAsString);

        assertTrue(fileAsString.startsWith("This is the content"));

    }
}