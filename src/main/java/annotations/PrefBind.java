package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Created by matthewarnold on 04/03/2016.
 *
 */
@Retention(CLASS) @Target(FIELD)
public @interface PrefBind {
    String value();
}
