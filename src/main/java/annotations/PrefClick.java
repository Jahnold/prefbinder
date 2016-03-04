package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.ElementType.METHOD;

/**
 * Created by matthewarnold on 04/03/2016.
 *
 */
@Retention(CLASS) @Target(METHOD)
public @interface PrefClick {
    String value();
}
