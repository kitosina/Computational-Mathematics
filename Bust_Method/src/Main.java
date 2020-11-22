public class Main {
    public static void main(String[] args) {
        Functions functions = new Functions();
        final Double EPS = 1e-2;    //точность
        Double intervalX1 = -1.0;  //X1<=x<=X2 X1,X2 границы x
        Double intervalX2 = -0.75;
        Double intervalY1 = 0.6;  //Y1<=y<=Y2 Y1,Y2 границы y
        Double intervalY2 = 0.8;
        int N = 1000;  //Число узлов для x
        int M = 1000;  //Число узлов для y
        Double x = intervalX1, y = intervalY1, result1 = 0.0, result2 = 1.0;
        boolean flag = false;
        for(int i = 1; i < N; i++) {
            x = intervalX1 + (i - 2) * (Math.abs(intervalX1 * intervalX2) / (N - 1));
            for(int j = 1; j < M; j++) {
                y = intervalY1 + (j - 2) * (Math.abs(intervalY1 * intervalY2) / (M - 1));
                result1 = functions.function1(x, y);
                result2 = functions.function2(x, y);
                if(Math.abs(result1)< EPS && Math.abs(result2) < EPS) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }
        if(flag){
            System.out.println("Result X = " + x + "\tResult Y = " + y);
        }
        else{
            System.out.println("Reduce the number of nodes (N, M)");
        }
    }
}
