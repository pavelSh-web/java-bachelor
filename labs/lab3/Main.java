import java.lang.Math;

enum ShapeType {
    TRIANGLE,
    RECTANGLE,
    ELLIPSE,
    CIRCLE,
    SQUARE
}

interface Shape {
    double getArea();

    double getPerimeter();

    ShapeType getType();
}

class Triangle implements Shape {

    double a, b, c;

    Triangle() {
        a = 0;
        b = 0;
        c = 0;
    }

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {

        double S = 0;
        if (a + b > c && a + c > b && b + c > a) {
            double p = (a + b + c) / 2;
            S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return S;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.TRIANGLE;
    }
}

class Rectangle implements Shape {

    double a, b;

    Rectangle() {
        a = 0;
        b = 0;
    }

    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public double getPerimeter() {
        return 2 * (a + b);
    }

    @Override
    public ShapeType getType() {
        return ShapeType.RECTANGLE;
    }
}

class Ellipse implements Shape {
    double a, b;

    Ellipse() {
        a = 0;
        b = 0;
    }

    Ellipse(double a, double b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public double getArea() {
        return Math.PI * a * b;
    }

    @Override
    public double getPerimeter() {
        return 4 * (Math.PI * a * b + Math.pow((a - b), 2)) / (a + b);
    }

    @Override
    public ShapeType getType() {
        return ShapeType.ELLIPSE;
    }
}

interface WithRadius {
    /**
     * @return радиус
     */
    double getRadius();
}

class Circle extends Ellipse implements WithRadius {

    Circle() {
        a = 0;
        b = 0;
    }

    Circle(double r) {
        a = r;
        b = r;
    }

    @Override
    public double getRadius() {
        return a;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.CIRCLE;
    }

    static Circle fromArea(double area) {
        double r = Math.sqrt(area / Math.PI);
        return new Circle(r);
    }
}

class Square extends Rectangle {

    Square() {
        a = 0;
        b = 0;
    }

    Square(double a) {
        this.a = a;
        this.b = a;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.SQUARE;
    }

    public double getArea() {
        return super.getArea();
    }

    static Rectangle fromArea(double area) {
        double a = Math.sqrt(area);
        return new Rectangle(a, a);
    }
}

interface ShapeCalculator {
    /**
     * @param shapes массив геометрических фигур
     * @return суммарная площадь геометрических фигур shapes
     */
    double getArea(Shape[] shapes);
}

class ShapeSumAreas implements ShapeCalculator {

    @Override
    public double getArea(Shape[] shapes) {

        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.getArea();
        }
        return sum;
    }
}

public class Main {

    public static void main(String[] args) {
        // write your code here
    }
}

