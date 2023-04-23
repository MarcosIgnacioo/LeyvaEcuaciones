public class AXe {
    double A;
    double X;
    double e;
    double Axe;
    public AXe(double A, double X, double e){
        this.A = A;
        this.X = X;
        this.e = e;
    }

    public double getA() {
        return A;
    }

    public void setA(double a) {
        A = a;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    public double getAxe() {
        return Axe = A*(Math.pow(X,e));
    }

    public void setAxe(double axe) {
        Axe = axe;
    }
}
