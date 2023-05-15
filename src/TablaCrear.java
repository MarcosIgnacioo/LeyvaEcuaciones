import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TablaCrear extends JTable {

    static DefaultTableModel dtm;
    public static JScrollPane agregarTabla(){
        String[] nombresColumnas = {"i", "a", "b", "m", "f(a)","f(b)", "f(m)", "f(a)*f(m)", "Error"};
        Object[][] datos = new Object[0][];//
        dtm = new DefaultTableModel(datos, nombresColumnas);
        JTable tablatest = new JTable(dtm);
        JScrollPane jsc = new JScrollPane(tablatest);
       return jsc;
    };

    public static void actualizarTabla(Object [] row){
        dtm.addRow(row);
    };
    public static void vaciarTabla(){
        dtm.setRowCount(0);
    };
    public static boolean isVacia(){
        return dtm.getRowCount() > 0;
    }
}
