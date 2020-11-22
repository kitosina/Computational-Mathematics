public class Fouier {
    public static void main(String[] args) {
        Double a = -0.5;
        Double b = 0.5;
        Double c = Math.PI*(-8);
        Double d = Math.PI*8;
        Double hx = (b-a)/1024;
        Double hw = (d-c)/1024;
        Double[] omega = new Double[1024];
        Double[] FRect = new Double[1024];
        for(int k = 0; k < 1024; k++){
            omega[k] = c+k*hw;
            FRect[k] = 0.0;
            for(int j = 0; j < 1024; j++){
                FRect[k]+=Math.cos(omega[k]*(a+j*hx));
            }
            FRect[k]*=hw;
            System.out.println(omega[k] + "\t\t\t\t" + FRect[k]);
        }
    }
}
