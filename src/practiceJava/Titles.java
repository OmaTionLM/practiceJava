package practiceJava;

import javax.swing.*;
import java.awt.*;

public class Titles extends JLabel
{
    /*
        Constructor
     */
    public Titles(String titles, Color background)
    {
        this.setText(titles);
        this.setBackground(background);
        this.setForeground(Color.WHITE);
        this.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }
}
