package org.zamasDev.utils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Decorations {

    public Border borderUtil(final Color color, int size, boolean rounded) {
        Border border = new LineBorder(Color.getColor("", color), size, rounded);

        return border;
    }

    public void setErrorText(JTextField txt) {
        txt.setForeground(Color.RED);
    }

    public void setErrorPass(JPasswordField txt) {
        txt.setForeground(Color.RED);
    }

    public void setSeparatorColor(JSeparator sp, Color color) {
        sp.setForeground(color);
    }

    public void Hover(JLabel lbl) {
        lbl.setForeground(Color.blue);
    }

    public void HoverOut(JLabel lbl) {
        lbl.setForeground(Color.black);
    }

}
