@Author(name = "John Doe", date = "2023-08-07", description = "Sample annotated class")
public class AnnotatedClass {
    @Author(name = "John Doe", description = "Sample field")
    private String sampleField;

    @Author(name = "John Doe")
    public AnnotatedClass() {
        // Constructor
    }

    @Author(name = "Jane Smith", date = "2023-08-08")
    public void annotatedMethod() {
        System.out.println("This is an annotated method");
    }

    public void nonAnnotatedMethod() {
        System.out.println("This method has no annotation");
    }
}

/*An annotation in Java is a form of metadata
  that provides additional information about the code but does not directly affect its execution. */

/*Annotations are tags that can be applied to:

Classes (@Entity, @Service)

Methods (@Override, @Test)

Fields (@Autowired, @Column)

Parameters (@NotNull, @RequestParam)

Packages (@Deprecated on package-info.java)

They do not change program logic but influence:

Compile-time behavior (e.g., @Override enforces method overriding)

Runtime behavior (e.g., Spring’s @Transactional manages transactions)

Code generation (e.g., Lombok’s @Getter generates getters automatically)
*/
