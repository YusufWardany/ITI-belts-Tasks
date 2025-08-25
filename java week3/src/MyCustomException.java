// Custom exception class
class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}

// Class with methods that throw the custom exception
class ExceptionThrower {
    public void method1() throws MyCustomException {
        throw new MyCustomException("Error in method1");
    }

    public void method2() throws MyCustomException {
        throw new MyCustomException("Error in method2");
    }

    public void method3() throws MyCustomException {
        throw new MyCustomException("Error in method3");
    }
}

// Class that calls the exception-throwing methods
class ExceptionTester {
    public static void main(String[] args) {
        ExceptionThrower thrower = new ExceptionThrower();

        try {
            thrower.method1();
        } catch (MyCustomException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Finished trying method1");
        }

        try {
            thrower.method2();
        } catch (MyCustomException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Finished trying method2");
        }

        try {
            thrower.method3();
        } catch (MyCustomException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Finished trying method3");
        }
    }
}