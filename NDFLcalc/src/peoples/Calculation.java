package peoples;

public class Calculation {
    public static float Calc_n(float rad, float sumok) {
        float sum_n;
        sum_n=(sumok/100)*rad;
        return sum_n;
    }
    public static float Calc_nar(float oklad, float sum_n) {
        float sum_nar;
        sum_nar=oklad-sum_n;
        return sum_nar;
    }
}
