package processor;

import annotations.PrefClick;
import org.apache.commons.lang3.StringUtils;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

/**
 * Created by matthewarnold on 07/03/2016.
 *
 */
public class PrefClickAnnotatedMethod {

    private ExecutableElement annotatedMethodElement;
    private String annotatedMethodName;
    private String containingClassName;
    private String prefName;

    public String getAnnotatedMethodName() {return annotatedMethodName;}
    public String getContainingClassName() {return containingClassName;}
    public String getPrefName() {return prefName;}
    public ExecutableElement getAnnotatedMethodElement() {return annotatedMethodElement;}

    public PrefClickAnnotatedMethod(TypeElement element) {

        this.annotatedMethodElement = (ExecutableElement) element;
        PrefClick annotation = element.getAnnotation(PrefClick.class);
        prefName = annotation.value();

        if (StringUtils.isEmpty(prefName)) {

            throw new IllegalArgumentException(
                    String.format(
                            "Preference name in @%s for method %s is missing",
                            PrefClick.class.getSimpleName(),
                            element.getQualifiedName().toString()
                    )
            );
        }

        annotatedMethodName = annotatedMethodElement.getSimpleName().toString();
        containingClassName = annotatedMethodElement.getEnclosingElement().getSimpleName().toString();
    }
}
