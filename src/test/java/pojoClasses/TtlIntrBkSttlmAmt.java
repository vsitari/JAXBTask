package pojoClasses;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"value"})
public class TtlIntrBkSttlmAmt {
    @XmlValue
    private String value;

    @XmlAttribute(name = "Ccy")
    private String ccy;
}