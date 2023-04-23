public class Ecuacion {
    double Axe;
    double Bx;
    double c;
    double EcuacionResultado;
    public Ecuacion(AXe aX, BX bX, C c){
            this.Axe = aX.getAxe();
            this.Bx = bX.getBx();
            this.c = c.getC();
    }

    public double getAxe() {
        return Axe;
    }

    public void setAxe(double axe) {
        Axe = axe;
    }

    public double getBx() {
        return Bx;
    }

    public void setBx(double bx) {
        Bx = bx;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getEcuacionResultado() {
        return EcuacionResultado = Axe + Bx + c;
    }

    public void setEcuacionResultado(double ecuacionResultado) {
        EcuacionResultado = ecuacionResultado;
    }
}
