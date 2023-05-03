package pojoClasses;

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
@XmlRootElement(name = "Document")
@XmlType(propOrder = {"fileAppHdr", "appHdr", "creditTransfer"})
public class Document {
    @XmlElement(name = "FileAppHdr")
    private FileAppHdr fileAppHdr;

    @XmlElement(name = "AppHdr")
    private AppHdr appHdr;

    @XmlElement(name = "CreditTransfer")
    private CreditTransfer creditTransfer;
}