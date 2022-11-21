package de.kaikarren.utils;

import java.io.*;
import java.util.Base64;

public class SerializationUtils {

    /**
     * Stores an object that implements the Serializable interface as a file.
     * @param o         The object to save
     * @param filename  The filename of the file
     */
    public static void saveObjectAsFile(Object o, String filename) throws IOException {

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))){

            outputStream.writeObject(o);

        }

    }

    /**
     * Loads an object from the given filename.
     * @param filename  The name of the file to load
     * @return          The object that has been loaded from the given filename
     */
    public static Object loadObjectFromFile(String filename) throws IOException, ClassNotFoundException{

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))){

            return inputStream.readObject();

        }

    }

    /**
     * Converts a (serializable) object to a String.
     * @param object    The object that should be converted into a String.
     * @return          The String representation of the object.
     * @throws IOException If something goes wrong.
     *
     * Based on https://stackoverflow.com/questions/69446440/how-to-write-serializable-object-to-string-without-writing-to-file
     */
    public static String objectToString(Object object) throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();

        return Base64.getEncoder().encodeToString(outputStream.toByteArray());

    }

    /**
     * Creates an object from a given String.
     * @param s The String to create the Object from.
     * @return  The object that has been created from the String.
     * @throws IOException  If something goes wrong.
     * @throws ClassNotFoundException  If not matching class could be found.
     *
     * Based on https://stackoverflow.com/questions/69446440/how-to-write-serializable-object-to-string-without-writing-to-file
     */
    public static Object objectFromString(String s) throws IOException, ClassNotFoundException {

        byte [] data = Base64.getDecoder().decode(s);

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))){
            return objectInputStream.readObject();
        }

    }

}
