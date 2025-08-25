import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*This class demonstrates runtime annotation processing
 using Java Reflection to inspect and extract metadata from annotations applied to a class (AnnotatedClass).
 It checks for the custom @Author annotation at different levels (class, fields, constructors, methods).*/
public class AnnotationProcessor {
    public static void main(String[] args) {
        // Process class annotations
        Class<AnnotatedClass> clazz = AnnotatedClass.class;

        if (clazz.isAnnotationPresent(Author.class)) {
            Author classAuthor = clazz.getAnnotation(Author.class);
            System.out.println("Class Author: " + classAuthor.name());
            System.out.println("Date: " + classAuthor.date());
            System.out.println("Description: " + classAuthor.description());
            System.out.println();
        }

        // Process field annotations
        System.out.println("Field Annotations:");
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Author.class)) {
                Author author = field.getAnnotation(Author.class);
                System.out.println(field.getName() + ": " + author.name() +
                        " - " + author.description());
            }
        }
        System.out.println();

        // Process constructor annotations
        System.out.println("Constructor Annotations:");
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (constructor.isAnnotationPresent(Author.class)) {
                Author author = constructor.getAnnotation(Author.class);
                System.out.println("Constructor: " + author.name());
            }
        }
        System.out.println();

        // Process method annotations
        System.out.println("Method Annotations:");
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Author.class)) {
                Author author = method.getAnnotation(Author.class);
                System.out.println(method.getName() + ": " + author.name() +
                        " (" + author.date() + ")");
            }
        }
    }
}