package pojoClasses;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"grpHdr", "cdtTrfTxInf"})
public class FIToFICstmrCdtTrf {
    @XmlElement(name = "GrpHdr")
    private GrpHdr grpHdr;

    @XmlElement(name = "CdtTrfTxInf")
    private List<CdtTrfTxInf> cdtTrfTxInf;
}