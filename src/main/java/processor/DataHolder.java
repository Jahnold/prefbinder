package processor;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by matthewarnold on 07/03/2016.
 *
 */
public class DataHolder {

    private Set<String> annotatedClassNames;
    private Map<String, ClickMethodHolder> clickMethods;

    public DataHolder() {
        annotatedClassNames = new HashSet<>();
        clickMethods = new LinkedHashMap<>();
    }

    public void addClickMethod(ClickMethod method) throws ProcessingException {

        annotatedClassNames.add(method.getContainingClassName());

        ClickMethodHolder holder = clickMethods.get(method.getContainingClassName());
        if (holder == null) holder = new ClickMethodHolder();
        holder.add(method);
        clickMethods.put(method.getContainingClassName(), holder);
    }

    public void generateCode() {

        for (String annotatedClassName : annotatedClassNames) {

        }
    }
}
