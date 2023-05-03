package pojoClasses;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditTransfer {
    @XmlElement(name = "FIToFICstmrCdtTrf")
    private FIToFICstmrCdtTrf fIToFICstmrCdtTrf;
}