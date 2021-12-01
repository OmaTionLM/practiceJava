package practiceJava;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GIU_STUDENT extends JFrame
{
    private JButton myPhoto, myHobbie, myExpects;
    private JPanel panelBotones, panelDatos;
    private JTextArea expectationsTexts;
    private Titles title;
    private ImageIcon image;
    private JLabel labelImage;
    private Listener listener;

    /*
        Constructor
     */
    public GIU_STUDENT()
    {
        initGIU();
        //Default window configuration
        this.setTitle("My window");
        this.setSize(600,540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {

            }
        });
        GIU_STUDENT miGUI=new GIU_STUDENT();
    }

    /*
        Metodo
     */
    private void initGIU()
    {
        //Set up Container and Layout
        //Create Listener and Control Object
        listener=new Listener();

        //Set up JComponents
        title=new Titles("Hi, i'm Alan, push the buttons.", Color.black);
        this.add(title, BorderLayout.NORTH);

        myPhoto=new JButton("This is me.");
        myPhoto.addActionListener(listener);
        myHobbie=new JButton("My hobby.");
        myHobbie.addActionListener(listener);
        myExpects=new JButton("More about me.");
        myExpects.addActionListener(listener);

        panelBotones=new JPanel();
        panelBotones.add(myPhoto);
        panelBotones.add(myHobbie);
        panelBotones.add(myExpects);

        this.add(panelBotones, BorderLayout.SOUTH);

        panelDatos=new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "More of me", TitledBorder.CENTER, TitledBorder.CENTER,
        new Font("Calibri", Font.BOLD+Font.ITALIC, 28), Color.BLUE));

        this.add(panelDatos, BorderLayout.CENTER);
        labelImage=new JLabel();
        expectationsTexts=new JTextArea(15, 20);
    }

    private class Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent objectEvent)
        {
            panelDatos.removeAll();
            if(objectEvent.getSource()==myPhoto)
            {
                image=new ImageIcon(getClass().getResource("/means/1637436572806.jpg"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
            }
            else if(objectEvent.getSource()==myHobbie)
            {
                //JOptionPane.showMessageDialog(myHobbie, "Diste click en mi Hobby");
                image=new ImageIcon(getClass().getResource("/means/1637437098464.jpg"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
            }
            else
            {
                //JOptionPane.showMessageDialog(myHobbie, "Diste click en mis expectativas");
                expectationsTexts.setText("No se mucho de Java, pero quiero aprender y ser uno de los mejores. \n" +
                                            "Mi meta en este semestre es manejar muy bien Java. \n" +
                                            "Quiero en el futuro ser un buen programador.");
                expectationsTexts.setBackground(null);
                expectationsTexts.setFont(new Font("arial", Font.PLAIN+Font.ITALIC, 27));
                panelDatos.add(expectationsTexts);
            }
            revalidate();
            repaint();
        }
    }
}
