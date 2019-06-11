/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama.gantt;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author casa
 */
public class CambiarColor extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof String) {
            table.selectAll();
            String valor = (String) value;
            
            if (valor.equals("X")) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.RED); //color de la letra               
            } else if (valor.equals("E")) {
                cell.setBackground(Color.CYAN);
                cell.setForeground(Color.CYAN);
            } 
        }

        /*if (value instanceof String) {
         String valor = (String) value;
            
         }*/
        return cell;
    }
}
