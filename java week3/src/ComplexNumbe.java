class ComplexNumber<T extends Number> {
    private T real;
    private T imaginary;

    public ComplexNumber(T real, T imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber<Double> add(ComplexNumber<T> other) {
        double newReal = this.real.doubleValue() + other.real.doubleValue();
        double newImaginary = this.imaginary.doubleValue() + other.imaginary.doubleValue();
        return new ComplexNumber<>(newReal, newImaginary);
    }

    public ComplexNumber<Double> subtract(ComplexNumber<T> other) {
        double newReal = this.real.doubleValue() - other.real.doubleValue();
        double newImaginary = this.imaginary.doubleValue() - other.imaginary.doubleValue();
        return new ComplexNumber<>(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }

    // You can add more operations like multiply, divide, etc.
}

class ComplexTest {
    public static void main(String[] args) {
        ComplexNumber<Double> c1 = new ComplexNumber<Double>(3.0, 4.0);
        ComplexNumber<Double> c2 = new ComplexNumber<>(2.5, 1.5);

        ComplexNumber<Double> sum = c1.add(c2);
        ComplexNumber<Double> difference = c1.subtract(c2);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
    }
}