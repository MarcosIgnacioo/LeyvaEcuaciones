import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double m = 0;
        double mAnt = 0;
        double tolerancia = 0.001;
        double a = 1;
        double b = 2;
        double aE = 0;
        double bE = 0;
        double cE = 0;
        double dE = 0;
        //double fA = ecuacion(a);
        //double fb = ecuacion(b);
        System.out.println(ecuacion(1));
        System.out.println(ecuacion(2));
        Scanner read = new Scanner(System.in);
        double x = 0; double e = 0; double coef =0 ; double cons= 0; double ans= 0; double fA = 0; double fb = 0; double d = 0; double c = 0;
        System.out.println("Va a querer una ecuacion 1.- cuadratica o 2.- cubica");
        ans = read.nextInt();
        if (ans == 1){
            System.out.println("Ingresa a: ");
            a = read.nextDouble();
            System.out.println("Ingresa b: ");
            b = read.nextDouble();
            System.out.println("Ingresa e: ");
            e = read.nextDouble();
            System.out.println("Ingresa coef: ");
            coef = read.nextDouble();
            System.out.println("Ingresa cons: ");
            cons = read.nextDouble();
            fA = ecuacionCustom(a,e,coef,cons);
            fb = ecuacionCustom(b,e,coef,cons);
            System.out.println(fA);
            System.out.println(fb);
        }
        else{
            System.out.println("Ingresa a: ");
            a = read.nextDouble();
            System.out.println("Ingresa b: ");
            b = read.nextDouble();
            System.out.println("Ingresa c: ");
            c = read.nextDouble();
            System.out.println("Ingresa d: ");
            d = read.nextDouble();
            System.out.println("Ingresa parametro a: ");
            aE = read.nextDouble();
            System.out.println("Ingresa parametro b: ");
            bE = read.nextDouble();
            fA = ecuacionCustom(aE,a,b,c,d);
            fb = ecuacionCustom(bE,a,b,c,d);
            System.out.println(fA);
            System.out.println(fb);
        }
        int i = 0;
        double error = 1;
        do{
            if ((fA*fb) < 0){
                m = (a + b)/2;
                double fM = ecuacionCustom(m,e,coef,cons);;
                error = Math.abs((m-mAnt)/m);
                System.out.println("it: ["+(i++)+"] a: ["+a+"] b: ["+b+"] m: ["+m+"] f(a): ["+fA+"] f(b): ["+fb+"] f(m): ["+fM+"] f(a)*f(m) ["+ (fA*fM)+"]"+" Error:["+error+"]");

                if ((fA*fM) < 0){
                    b = m;
                    fb = ecuacionCustom(b,e,coef,cons);
                }
                else{
                    a = m;
                    fA = ecuacionCustom(b,e,coef,cons);
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


    public static double ecuacionCustom(double x, double e, double coef, double cons){
        return (Math.pow(x,e))+coef*x+cons;
    }
// ax 3 + bx 2 + cx + d
    public static double ecuacionCustom(double x,double a, double b, double c, double d){
        return (Math.pow(x,3))+(Math.pow(x,2)) + c*x + d;
    }


}