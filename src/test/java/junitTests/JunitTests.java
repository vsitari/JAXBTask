package junitTests;

import org.junit.jupiter.api.DisplayName;
import pojoClasses.Document;
import testDataUtils.Book;
import testDataUtils.Custom;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static utils.FilePaths.*;
import static utils.Utils.*;

public class JunitTests {

    @Test
    @DisplayName("Test unmarshalling and marshalling result in equal XML files")
    void testUnmarshallingAndMarshallingResultInEquaXmlFiles() throws JAXBException {
        Document doc = unmarshalling(Document.class, FILE_TO_COMPARE);
        marshalling(doc, FILE_TO_MARSHALL);
        assertTrue(areEquals(FILE_TO_COMPARE, FILE_TO_MARSHALL), "Failed Marshalling of XML file");
    }

    @Test
    @DisplayName("Test XML document fields values are not null after unmarshalling")
    void testXmlDocumentFieldsValuesAreNotNull() throws JAXBException {
        Document doc = unmarshalling(Document.class, FILE_TO_UNMARSHALL);
        assertAll(() -> {
            assertNotNull(doc.getFileAppHdr().getSttlmCycl());
            assertNotNull(doc.getFileAppHdr().getNbOfBtchs());
            assertNotNull(doc.getAppHdr().getFinInstnId().getBicfi());
            assertNotNull(doc.getAppHdr().getBizMsgIdr());
            assertNotNull(doc.getAppHdr().getCreDt());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getGrpHdr().getMsgId());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getGrpHdr().getCreDtTm());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getGrpHdr().getNbOfTxs());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getGrpHdr().getTtlIntrBkSttlmAmt().getValue());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getGrpHdr().getTtlIntrBkSttlmAmt().getCcy());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getGrpHdr().getIntrBkSttlmDt());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getGrpHdr().getSttlmInf().getSttlmMtd());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getPmtId().getInstrId());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getPmtId().getClrSysRef());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getPmtId().getEndToEndId());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getPmtId().getTxId());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(1).getPmtId().getInstrId());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(1).getPmtId().getClrSysRef());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(1).getPmtId().getEndToEndId());
            assertNotNull(doc.getCreditTransfer().getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(1).getPmtId().getTxId());
        });
    }

    @Test
    @DisplayName("Test unmarshalling with invalid class throws JAXBException")
    void testUnmarshallingWithInvalidClassThrowsJAXBException() {
        assertThrows(JAXBException.class, () -> unmarshalling(Custom.class, FILE_TO_UNMARSHALL));
    }

    @Test
    @DisplayName("Test XML tags values are updated successfully")
    void testXmlTagValueIsUpdatedSuccessfully() throws JAXBException, IllegalAccessException, IOException, InvocationTargetException, NoSuchMethodException {
        Document doc = unmarshalling(Document.class, FILE_TO_UNMARSHALL);
        replaceTagValue(doc, "nbOfBtchs", 556, 0);
        replaceTagValue(doc, "ccy", "newAttribute", 0);
        replaceTagValue(doc, "endToEndId", "firstList", 0);
        replaceTagValue(doc, "endToEndId", "secondList", 1);
        marshalling(doc, FILE_TO_MARSHALL);
        assertTrue(Files.readString(Path.of(String.valueOf(FILE_TO_MARSHALL))).contains("556"), "Field value update failed");
        assertTrue(Files.readString(Path.of(String.valueOf(FILE_TO_MARSHALL))).contains("newAttribute"), "Field value update failed");
        assertTrue(Files.readString(Path.of(String.valueOf(FILE_TO_MARSHALL))).contains("firstList"), "Field value update failed");
        assertTrue(Files.readString(Path.of(String.valueOf(FILE_TO_MARSHALL))).contains("secondList"), "Field value update failed");
    }

    @Test
    @DisplayName("Test Java Object marshalling is succeeded")
    void testJavaObjectMarshallingWorksSuccessfully() throws JAXBException {
        marshalling(new Book("William Shakespeare", "Romeo and Juliet"), FILE_TO_MARSHALL);
        assertTrue(FILE_TO_MARSHALL.length() != 0, "Failed Marshalling of Java Object to XML file");
    }

}