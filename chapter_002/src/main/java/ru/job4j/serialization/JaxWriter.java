package ru.job4j.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;

public class JaxWriter {

    public static void main(String[] args) throws JAXBException {
        Dog person = new Dog(false, 3, "Мурзик", new SerialNumber("384511"), "11.08.20");

        JAXBContext context = JAXBContext.newInstance(Dog.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(person, new File("./dog.xml"));
        marshaller.marshal(person, System.out);

//        try (StringWriter writer = new StringWriter()) {
//            marshaller.marshal(person, writer);
//             String xml = writer.getBuffer().toString();
//            System.out.println(xml);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
