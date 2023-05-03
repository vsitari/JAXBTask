package pojoClasses;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"msgId", "creDtTm", "nbOfTxs", "ttlIntrBkSttlmAmt", "intrBkSttlmDt", "sttlmInf"})
public class GrpHdr {
    @XmlElement(name = "MsgId")
    private String msgId;

    @XmlElement(name = "CreDtTm")
    private String creDtTm;

    @XmlElement(name = "NbOfTxs")
    private Integer nbOfTxs;

    @XmlElement(name = "TtlIntrBkSttlmAmt")
    private TtlIntrBkSttlmAmt ttlIntrBkSttlmAmt;

    @XmlElement(name = "IntrBkSttlmDt")
    private String intrBkSttlmDt;

    @XmlElement(name = "SttlmInf")
    private SttlmInf sttlmInf;
}