package processor;

import annotations.PrefBind;
import annotations.PrefChanged;
import annotations.PrefClick;
import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by matthewarnold on 04/03/2016.
 *
 */
@AutoService(Processor.class)
public class PrefProcessor extends AbstractProcessor {

    private Types typeUtils;
    private Elements elementUtils;
    private Filer filer;
    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {

        super.init(processingEnv);

        typeUtils = processingEnv.getTypeUtils();
        elementUtils = processingEnv.getElementUtils();
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {

        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(PrefBind.class.getCanonicalName());
        annotations.add(PrefChanged.class.getCanonicalName());
        annotations.add(PrefClick.class.getCanonicalName());

        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {

        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(PrefClick.class)) {

            if (annotatedElement.getKind() != ElementKind.METHOD) {

                error(annotatedElement, "Only methods can be annotated with @%s", PrefClick.class.getSimpleName());
                return true;
            }

            TypeElement typeElement = (TypeElement) annotatedElement;
            PrefClickAnnotatedMethod annotatedMethod = new PrefClickAnnotatedMethod(typeElement);
        }

        for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(PrefChanged.class)) {

        }

        for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(PrefBind.class)) {

        }

        return false;
    }

    private void error(Element element, String message, Object... args) {

        messager.printMessage(
                Diagnostic.Kind.ERROR,
                String.format(message, args),
                element
        );
    }
}
