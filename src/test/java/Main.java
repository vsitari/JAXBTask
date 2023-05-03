import jakarta.xml.bind.JAXBException;
import pojoClasses.Document;
import java.lang.reflect.InvocationTargetException;

import static utils.FilePaths.FILE_TO_UNMARSHALL;
import static utils.Utils.unmarshalling;
import static utils.Utils.marshalling;
import static utils.Utils.replaceTagValue;

public class Main {

    public static void main(String[] args) throws JAXBException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Document doc = unmarshalling(Document.class, FILE_TO_UNMARSHALL);
        replaceTagValue(doc, "ccy", "attribute", 1);
        marshalling(doc, FILE_TO_UNMARSHALL);
    }

}