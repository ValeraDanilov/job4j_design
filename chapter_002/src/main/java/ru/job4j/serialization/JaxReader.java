package ru.job4j.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class JaxReader {

    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Dog.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (BufferedReader reader = new BufferedReader(new FileReader("./dog.xml"))) {
            Dog dog = (Dog) unmarshaller.unmarshal(reader);
            System.out.println(dog);

        }
    }
}
