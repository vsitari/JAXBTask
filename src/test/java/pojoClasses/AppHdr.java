package pojoClasses;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"finInstnId", "bizMsgIdr", "msgDefIdr", "creDt"})
@Setter
@Getter
public class AppHdr {
    @XmlElement(name = "FinInstnId")
    private FinInstnId finInstnId;

    @XmlElement(name = "BizMsgIdr")
    private String bizMsgIdr;

    @XmlElement(name = "MsgDefIdr")
    private String msgDefIdr;

    @XmlElement(name = "CreDt")
    private String creDt;
}