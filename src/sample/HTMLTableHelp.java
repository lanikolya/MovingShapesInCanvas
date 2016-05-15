package sample;

import javax.swing.*;

public class HTMLTableHelp {
    HTMLTableHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><table border=1>");

        sb.append("<tr>");
        for ( String columnName : columnNames ) {
            sb.append("<th>");
            sb.append(columnName);
            sb.append("</th>");
        }
        sb.append("</tr>");
        for (Object[] row : data) {
            sb.append("<tr>");
            for (Object value : row) {
                sb.append("<td>");
                sb.append(value);
                sb.append("</td>");

            }
            sb.append("</tr>");
        }
        sb.append("</table>");
        JLabel html = new JLabel(sb.toString());

        JOptionPane.showMessageDialog(null, html);
    }

    public static void main(String[] args) {
        Runnable r = HTMLTableHelp::new;
        SwingUtilities.invokeLater(r);
    }

    String[] columnNames = {
            "Function",
            "Key"
    };

    Object[][] data = {
            {"Rectangle", "1"},
            {"Triangle", "2"},
            {"Oval", "3"},
            {"Rhombus", "4"},
            {"Star", "5"},
            {"Combine in group", "CTRL+CLICK ON SHAPES"},
            {"Clean", "C"},
            {"Help", "H"},
            {"Move up", "Up arrow"},
            {"Move down", "Down arrow"},
            {"Move right", "Right arrow"},
            {"Move left", "Left arrow"},
            {"Previous figure", "M"},
            {"Next figure", "P"},
            {"C", "Clean"},
    };
}