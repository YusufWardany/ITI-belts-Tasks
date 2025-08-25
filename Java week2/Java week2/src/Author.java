import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  //This specifies how long the annotation should be retained (kept available):
@Target({ElementType.TYPE, ElementType.METHOD,
        ElementType.CONSTRUCTOR, ElementType.FIELD}) //This specifies where the annotation can be applied:
public @interface Author {
    String name();
    String date() default "";
    String description() default "";
}
/*Understanding @Retention and @Target Meta-Annotations
These are meta-annotations
(annotations that apply to other annotations) that control how your custom annotations behave.*/