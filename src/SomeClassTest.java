import java.lang.annotation.Annotation;



public class SomeClassTest {

    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        SomeAnnotation annotation = someClass.getClass().getAnnotation(SomeAnnotation.class);
        Class<?> value = annotation.value();
        Annotation[] annotations = value.getAnnotations();
        for(Annotation a : annotations) {
            System.out.println(a);
        }
    }

}
