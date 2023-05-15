import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class teste extends JFrame {
    static JScrollPane tablaGod = TablaCrear.agregarTabla();

    static ArrayList<Double> elementosEcuacionArrayList = new ArrayList<>();
    static ArrayList<Double> ecuacionResultadoA = new ArrayList<>();
    static ArrayList<Double> ecuacionResultadoB = new ArrayList<>();
    static ArrayList<Double> ecuacionResultadoM = new ArrayList<>();
    static JFrame frame = new JFrame();
    public static void main(String[] args) {
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextField ecuacionTf = new JTextField("1x^3 - 3x + 1");
            frame.add(ecuacionTf, BorderLayout.NORTH);
        JButton ejecutarMetodo = new JButton("DALE");
            ejecutarMetodo.setBackground(Color.BLUE);
            frame.add(ejecutarMetodo, BorderLayout.WEST);

        frame.add(tablaGod, BorderLayout.CENTER);
        frame.repaint();
        frame.revalidate();
        final String[] ecuacionString = new String[1];
        ejecutarMetodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ejecutar los metodos pero sin que cargue la tabla, puro consola para ver q rollo
                // uno por uno pue
                ecuacionString[0] = ecuacionTf.getText();
                if (elementosEcuacionArrayList.size() != 0){
                    elementosEcuacionArrayList.clear();
                    ecuacionResultadoA.clear();
                    ecuacionResultadoB.clear();
                    ecuacionResultadoM.clear();
                }
                elementosEcuacionArrayList = separadorEcuacion(ecuacionString[0]);

                /*double fA = 0;
                double fB = 0;
                guardarEcuacion(elementosEcuacionArrayList,ecuacionResultadoB, 2);
                guardarEcuacion(elementosEcuacionArrayList,ecuacionResultadoA, 1);
                fB = ejecutarEcuacion(ecuacionResultadoB);
                fA = ejecutarEcuacion(ecuacionResultadoA);
                System.out.println(fA);
                System.out.println(fB);*/
                //metodoBiseccion();
                metodoFalso();
            }
        });

    }
    public static void metodoFalso(){
        if (TablaCrear.isVacia()){
            System.out.println("vaciando");
            TablaCrear.vaciarTabla();
        }
        double m = 0;
        double mAnt = 0;
        double tolerancia = 0.001;
        double a = 1;
        double b = 2;

        double fA = 0;
        double fB = 0;
        guardarEcuacion(elementosEcuacionArrayList,ecuacionResultadoB, b);
        guardarEcuacion(elementosEcuacionArrayList,ecuacionResultadoA, a);
        fB = ecuacionResultadoB.get(0) + ecuacionResultadoB.get(1) + ecuacionResultadoB.get(2);
        fA = ecuacionResultadoA.get(0) + ecuacionResultadoA.get(1) + ecuacionResultadoA.get(2);
        System.out.println(fA);
        System.out.println(fB);

        int i = 0;
        double error = 1;
        do{
            if ((fA*fB) < 0){
                m = (a - ((fA*(b-a))/(fB-fA)));
                guardarEcuacion(elementosEcuacionArrayList,ecuacionResultadoM, m);
                double fM = ejecutarEcuacion(ecuacionResultadoM);
                error = Math.abs((m-mAnt)/m);
                //System.out.println("it: ["+(i)+"] a: ["+a+"] b: ["+b+"] m: ["+m+"] f(a): ["+fA+"] f(b): ["+fB+"] f(m): ["+fM+"] f(a)*f(m) ["+ (fA*fM)+"]"+" Error:["+error+"]");
                Object [] row = {(i++), a, b, m, fA, fB, fM, (fA*fM), error};
                TablaCrear.actualizarTabla(row);
                if ((fA*fM) < 0){
                    b = m;
                    ecuacionResultadoM.clear();
                    ecuacionResultadoB.clear();
                }
                else{
                    a = m;
                    ecuacionResultadoA.clear();
                    ecuacionResultadoM.clear();
                }
                guardarEcuacion(elementosEcuacionArrayList,ecuacionResultadoB, b);
                guardarEcuacion(elementosEcuacionArrayList,ecuacionResultadoA, a);
                fB = ecuacionResultadoB.get(0) + ecuacionResultadoB.get(1) + ecuacionResultadoB.get(2);
                fA = ecuacionResultadoA.get(0) + ecuacionResultadoA.get(1) + ecuacionResultadoA.get(2);
            }
            mAnt = m;
        }while(error > tolerancia);
    }

    public static void metodoBiseccion(){
        if (TablaCrear.isVacia()){
            System.out.println("vaciando");
            TablaCrear.vaciarTabla();
        }
        double m = 0;
        double mAnt = 0;
        double tolerancia = 0.001;
        double a = 1;
        double b = 2;

        double fA = 0;
        double fB = 0;
        guardarEcuacion(elementosEcuacionArrayList,ecuacionResultadoB, b);
        guardarEcuacion(elementosEcuacionArrayList,ecuacionResultadoA, a);
        fB = ecuacionResultadoB.get(0) + ecuacionResultadoB.get(1) + ecuacionResultadoB.get(2);
        fA = ecuacionResultadoA.get(0) + ecuacionResultadoA.get(1) + ecuacionResultadoA.get(2);
        System.out.println(fA);
        System.out.println(fB);

        int i = 0;
        double error = 1;
        do{
            if ((fA*fB) < 0){
                m = (a + b)/2;
                guardarEcuacion(elementosEcuacionArrayList,ecuacionResultadoM, m);
                double fM = ejecutarEcuacion(ecuacionResultadoM);
                error = Math.abs((m-mAnt)/m);
                //System.out.println("it: ["+(i)+"] a: ["+a+"] b: ["+b+"] m: ["+m+"] f(a): ["+fA+"] f(b): ["+fB+"] f(m): ["+fM+"] f(a)*f(m) ["+ (fA*fM)+"]"+" Error:["+error+"]");
                Object [] row = {(i++), a, b, m, fA, fB, fM, (fA*fM), error};
                TablaCrear.actualizarTabla(row);
                if ((fA*fM) < 0){
                    b = m;
                    ecuacionResultadoM.clear();
                    ecuacionResultadoB.clear();
                }
                else{
                    a = m;
                    ecuacionResultadoA.clear();
                    ecuacionResultadoM.clear();
                }
                guardarEcuacion(elementosEcuacionArrayList,ecuacionResultadoB, b);
                guardarEcuacion(elementosEcuacionArrayList,ecuacionResultadoA, a);
                fB = ecuacionResultadoB.get(0) + ecuacionResultadoB.get(1) + ecuacionResultadoB.get(2);
                fA = ecuacionResultadoA.get(0) + ecuacionResultadoA.get(1) + ecuacionResultadoA.get(2);
            }
            mAnt = m;
        }while(error > tolerancia);
    }

    public static double ecuacion(double x){
        return (Math.pow(x,3))-3*x+1;
    }
    public static void guardarEcuacion(ArrayList<Double> elementosEcuacionArrayList, ArrayList<Double> ecuacionResultado, double x){
        int i = 0;
        while(i < (elementosEcuacionArrayList.size())){
            double coeficiente = elementosEcuacionArrayList.get(i);
            double exponente = elementosEcuacionArrayList.get(i+1);
            double incognita = elementosEcuacionArrayList.get(i+2);
            incognita = incognita == 1 ? x : 1;
            ecuacionResultado.add(coeficiente*(Math.pow(incognita,exponente)));
            i += 3;
        }
    }

    public static double ejecutarEcuacion(ArrayList<Double> ecuacionResultado){
        double fX = 0;
        for (int i = 0; i< ecuacionResultado.size(); i++){
            fX += ecuacionResultado.get(i);
        }
        return fX;
    }

    public static ArrayList<Double> separadorEcuacion(String ecuacion) {
        ArrayList<Double> coeficientesExponentes = new ArrayList<>();
        ecuacion = ecuacion.replaceAll("\\s+", ""); // Eliminar todos los espacios en blanco

        String[] terminos = ecuacion.split("(?=[+-])");
        Pattern patron = Pattern.compile("(-?\\d*\\.?\\d*)([a-zA-Z]\\^\\d+)?");

        for (String termino : terminos) {
            Matcher matcher = patron.matcher(termino);
            while (matcher.find()) {
                double coef = 0;
                String coeficiente = matcher.group(1);
                String exponente = matcher.group(2);
                String incognita = termino;
                exponente = exponente != null ? exponente.substring(2) : "1";
                incognita = incognita.contains("x") ? "1": "0";
                if (!coeficiente.isEmpty()) {
                    if (coeficiente.startsWith("-")) {
                        // Marcar el coeficiente como negativo
                        coeficiente = coeficiente.substring(1); // Eliminar el signo "-" del coeficiente
                        coef = -1.0*Double.parseDouble(coeficiente);
                    }
                    else{
                        coef = Double.parseDouble(coeficiente);
                    }
                }
                if (!coeficiente.isEmpty()){
                    coeficientesExponentes.add(coef);
                    coeficientesExponentes.add(Double.parseDouble(exponente));
                    coeficientesExponentes.add(Double.parseDouble(incognita));
                }
            }
        }
        return coeficientesExponentes;
    }
}
