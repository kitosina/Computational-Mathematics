public class Main {
    public static void main(String[] args) {
        SimpsonMethod simpsonMethod = new SimpsonMethod();
        TrapezoidMethod trapezoidMethod = new TrapezoidMethod();
        Double a = 0.0;
        Double b = Math.PI;
        Double headResult = (-Math.cos(b)-(-Math.cos(a)));
        Double simpsonResult = simpsonMethod.IntSimpson(a, b);
        Double trapezoidResult = trapezoidMethod.integralTrapec(a, b);

        System.out.println("headResult: " + headResult);
        System.out.println("simpsonResult: " + simpsonResult);
        System.out.println("trapezoidResult: " + trapezoidResult);
        System.out.println("Infelicity simpson: " + simpsonMethod.getInfelicity(a, b, 10000, (a + b) / 10000) + "\t|" + -simpsonMethod.getInfelicity(a, b, 10000, (a + b) / 10000));
        System.out.println("Infelicity trapezoid: " + trapezoidMethod.getInfelicity(a, b, 10000) + "\t|" + -trapezoidMethod.getInfelicity(a, b, 10000));

    }

}




