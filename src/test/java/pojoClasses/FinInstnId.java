package pojoClasses;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter

public class FinInstnId {
    @XmlElement(name="BICFI")
    private String bicfi;
}