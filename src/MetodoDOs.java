import javax.swing.*;

public class MetodoDOs {

    public static void main(String[] args) {

        double m = 0;
        double mAnt = 0;
        double tolerancia = 0.001;
        double a = 1;
        double b = 2;
        double fA = ecuacion(a);
        double fb = ecuacion(b);
        System.out.println(ecuacion(1));
        System.out.println(ecuacion(2));
        int i = 0;
        double error = 1;
        do{
            if ((fA*fb) < 0){
                m = (a - ((fA*(b-a))/(fb-fA)));
                double fM = ecuacion(m);;
                error = Math.abs((m-mAnt)/m);
                System.out.println("it: ["+(i++)+"] a: ["+a+"] b: ["+b+"] m: ["+m+"] f(a): ["+fA+"] f(b): ["+fb+"] f(m): ["+fM+"] f(a)*f(m) ["+ (fA*fM)+"]"+" Error:["+error+"]");

                if ((fA*fM) < 0){
                    b = m;
                    fb = ecuacion(b);
                }
                else{
                    a = m;
                    fA = ecuacion(a);
                }
            }
            mAnt = m;
        }while(error>tolerancia);

    }
    public static Ecuacion ejecutar(Ecuacion eX, double x, AXe aTmp, BX bTmp, C cTmp){
        aTmp.setX(x);
        bTmp.setX(x);
        eX.setAxe(aTmp.getAxe());
        eX.setAxe(bTmp.getBx());
        eX.setAxe(cTmp.getC());
        eX.getEcuacionResultado();
        Ecuacion eN = new Ecuacion(aTmp,bTmp,cTmp);
        return eN;
    }

    public static double ecuacion(double x){
        return (Math.pow(x,3))-3*x+1;
    }
}