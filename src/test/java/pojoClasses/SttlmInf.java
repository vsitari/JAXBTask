package pojoClasses;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"sttlmMtd", "clrSys"})
public class SttlmInf {
    @XmlElement(name = "SttlmMtd")
    private String sttlmMtd;

    @XmlElement(name = "ClrSys")
    private ClrSys clrSys;
}