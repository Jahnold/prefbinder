package processor;

import javax.annotation.processing.Filer;
import javax.lang.model.util.Elements;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by matthewarnold on 07/03/2016.
 *
 */
public class PrefClickGroupedMethods {

    private Map<String, PrefClickAnnotatedMethod> items = new LinkedHashMap<>();

    public void add(PrefClickAnnotatedMethod toAdd) throws PrefAlreadyBoundException {

        if (items.containsKey(toAdd.getPrefName())) {
            throw new PrefAlreadyBoundException(
                    toAdd.getAnnotatedMethodElement(),
                    "Preference: %s already has a click method bound",
                    toAdd.getPrefName()
            );
        }

        items.put(toAdd.getPrefName(), toAdd);
    }

    public void generateCode(Elements utils, Filer filer) throws IOException {

    }
}
