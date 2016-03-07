package processor;

import javax.lang.model.element.Element;

/**
 * Created by matthewarnold on 07/03/2016.
 *
 */
public class ProcessingException extends Exception {

    Element element;

    public ProcessingException(Element element, String message, Object... args) {

        super(String.format(message, args));
        this.element = element;
    }

    public Element getElement() {return element;}
}
