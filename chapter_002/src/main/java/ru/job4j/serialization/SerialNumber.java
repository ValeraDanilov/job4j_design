package ru.job4j.serialization;

import com.sun.xml.txw2.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "serialNumber")
public class SerialNumber {

    @XmlAttribute
    private String number;

    public SerialNumber() {
    }

    public SerialNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "SerialNumber{" +
                "number='" + number + '\'' +
                '}';
    }
}
