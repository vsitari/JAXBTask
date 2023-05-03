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
@XmlType(propOrder = {"instrId", "endToEndId", "txId", "clrSysRef"})
public class PmtId {
    @XmlElement(name = "InstrId")
    private String instrId;

    @XmlElement(name = "EndToEndId")
    private String endToEndId;

    @XmlElement(name = "TxId")
    private String txId;

    @XmlElement(name = "ClrSysRef")
    private Integer clrSysRef;
}