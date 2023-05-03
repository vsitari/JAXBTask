package testDataUtils;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@XmlRootElement(name = "Book")
@XmlType(propOrder = {"author", "name"})
public class Book {
    public Book() {
    }

    public Book(String author, String name) {
        this.author = author;
        this.name = name;
    }

    @XmlElement(name = "Author")
    private String author;

    @XmlElement(name = "Name")
    private String name;
}