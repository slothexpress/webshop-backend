package kodtest.omegapoint;

public class Rating {
    double rate;
    int count;

    public Rating() {
        this.rate = 2.5;
        this.count = 100;
    }

    public Rating(double rate, int count) {
        this.rate = rate;
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}