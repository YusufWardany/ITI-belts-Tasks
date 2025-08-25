import java.util.ArrayList;
import java.util.List;

// Base abstract class
abstract class Shape {
    public abstract void draw();
}

// Concrete classes
class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

// Test class
class ShapeTest {
    public static void drawAllShapes(List<? extends Shape> shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public static void main(String[] args) {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle());
        rectangles.add(new Rectangle());

        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle());
        circles.add(new Circle());

        System.out.println("Drawing rectangles:");
        drawAllShapes(rectangles);

        System.out.println("\nDrawing circles:");
        drawAllShapes(circles);
    }
}