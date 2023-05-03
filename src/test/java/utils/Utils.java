package utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.TRUE;

public class Utils {

    public static String[] classNames = {"AppHdr", "CdtTrfTxInf", "ClrSys", "CreditTransfer", "FileAppHdr", "FinInstnId", "FIToFICstmrCdtTrf", "GrpHdr", "PmtId", "SttlmInf", "TtlIntrBkSttlmAmt"};

    public static <T> T unmarshalling(Class<T> pojoClass, File fileToUnmarshall) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(pojoClass);
        return pojoClass.cast(context.createUnmarshaller()
                .unmarshal(fileToUnmarshall));
    }

    public static <T> void marshalling(T pojoClass, File fileToMarshall) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(pojoClass.getClass());
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, TRUE);
        mar.setProperty(Marshaller.JAXB_FRAGMENT, TRUE);
        mar.marshal(pojoClass, fileToMarshall);
    }

    public static boolean areEquals(File file1, File file2) {
        Diff diff = DiffBuilder.compare(Input.fromFile(file1))
                .withTest(Input.fromFile(file2))
                .build();
        return !diff.hasDifferences();
    }

    public static <T, V> void replaceTagValue(T doc, String tagName, V newValue, int index) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException{
        for (Field f : doc.getClass().getDeclaredFields()) {
            String findTag = f.getName();
            if (findTag.equals(tagName)) {
                f.setAccessible(true);
                f.set(doc, newValue);
            } else if (Arrays.asList(classNames).contains(f.getType().getSimpleName())) {
                Method getObj = doc.getClass().getMethod("get" + findTag.substring(0, 1).toUpperCase() + findTag.substring(1));
                replaceTagValue(getObj.invoke(doc), tagName, newValue, index);
            } else if (f.getType().getSimpleName().equals("List")) {
                Method obj = doc.getClass().getMethod("get" + findTag.substring(0, 1).toUpperCase() + findTag.substring(1));
                replaceTagValue(((List<T>) obj.invoke(doc)).get(index), tagName, newValue, index);
            }
        }
    }
}