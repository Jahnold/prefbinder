package processor;

import annotations.PrefClick;
import org.apache.commons.lang3.StringUtils;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

/**
 * Created by matthewarnold on 07/03/2016.
 *
 */
public class ClickMethod {

    private ExecutableElement annotatedMethodElement;
    private String annotatedMethodName;
    private String containingClassName;
    private String prefName;

    public String getAnnotatedMethodName() {return annotatedMethodName;}
    public String getContainingClassName() {return containingClassName;}
    public String getPrefName() {return prefName;}
    public ExecutableElement getAnnotatedMethodElement() {return annotatedMethodElement;}

    public ClickMethod(ExecutableElement element) throws ProcessingException {

        this.annotatedMethodElement = element;
        PrefClick annotation = element.getAnnotation(PrefClick.class);
        prefName = annotation.value();

        if (StringUtils.isEmpty(prefName)) {

            throw new ProcessingException(
                    element,
                    "Preference name in @%s for method %s is missing",
                    PrefClick.class.getSimpleName(),
                    element.getSimpleName().toString()
            );
        }

        annotatedMethodName = annotatedMethodElement.getSimpleName().toString();
        containingClassName = annotatedMethodElement.getEnclosingElement().getSimpleName().toString();
    }
}
