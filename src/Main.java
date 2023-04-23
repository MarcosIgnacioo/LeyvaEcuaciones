public class Main {

    public static void main(String[] args) {

        double m = 0;
        double mAnt = 0;
        double tolerancia = 0.001;
        double aVar = 1;
        double bVar = 2;

        AXe Ma = new AXe(1,m,3);
        BX Mb = new BX(-3,m);
        C Mc = new C(1);

        AXe Aa = new AXe(1,aVar,3);
        BX Ab = new BX(-3,aVar);
        C Ac = new C(1);
        Ecuacion eA = new Ecuacion(Aa,Ab,Ac);

        AXe Ba = new AXe(1,bVar,3);
        BX Bb = new BX(-3,bVar);
        C Bc = new C(1);
        Ecuacion eB = new Ecuacion(Ba,Bb,Bc);
        double valorA = eA.getEcuacionResultado();
        double valorB = eB.getEcuacionResultado();
        Ecuacion eM;
        
        /*
        do{
            if ((valorA*valorB) < 0){
                mAnt = m;
                m = (aVar + bVar)/2;
                eM = new Ecuacion(Ma, Mb, Mc);
                double valorM = eM.getEcuacionResultado();
                System.out.println(valorM*valorA);
                if ((valorA*valorM) < 0){
                    bVar = m;
                    eB = ejecutar(eB,bVar, Ba, Bb, Bc);
                    valorB = eB.getEcuacionResultado();
                    System.out.println(eB.getEcuacionResultado());
                }
                else{
                    aVar = m;
                    eA = ejecutar(eA,aVar, Aa, Ab, Ac);
                    valorA = eA.getEcuacionResultado();
                    System.out.println(eA.getEcuacionResultado());
                }
            }

        }
        while(m>tolerancia);*/
    }

    public static Ecuacion ejecutar(Ecuacion eX, double x, AXe aTmp, BX bTmp, C cTmp){
        aTmp.setX(x);
        bTmp.setX(x);
        eX.setAxe(aTmp.getAxe());
        eX.setAxe(bTmp.getBx());
        eX.setAxe(cTmp.getC());
        Ecuacion eN = new Ecuacion(aTmp,bTmp,cTmp);
        return eN;
    }
}