package xin.wanwork;

/**
 * @author ShuningWan
 * @version 1.0
 * @date 2020-08-21 19:06
 */
public class Test {

    static double EPSINON = 0.0000000001;

    static double sqrt(int val) {
        double low = 1.4, high = 1.5;
        double mid = (low + high) / 2.0;

        while (high - low > EPSINON){
            if (mid * mid > 2) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (high + low) / 2.0;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(2));
    }



}
