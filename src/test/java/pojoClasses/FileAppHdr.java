package pojoClasses;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"nbOfBtchs", "sttlmCycl"})
@Getter
@Setter
public class FileAppHdr {
    @XmlElement(name = "NbOfBtchs")
    private Integer nbOfBtchs;

    @XmlElement(name = "SttlmCycl")
    private Integer sttlmCycl;
}