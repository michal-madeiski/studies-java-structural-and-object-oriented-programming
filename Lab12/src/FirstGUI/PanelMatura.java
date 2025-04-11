package FirstGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMatura extends JPanel {
    JPanel naglowekP;
    JPanel matmaP;
    JPanel polskiP;
    JPanel jezykP;
    JPanel obliczP;
    public PanelMatura() {
        super();
        setLayout(new GridLayout(6, 1));

        //NAGLOWEK
        naglowekP = new JPanel();
        naglowekP.setLayout(new LeftFlowLayout());

        JLabel naglowekL = new JLabel("WYNIKI Z EGZAMINU MATURALNEGO:     ");
        naglowekL.setFont(naglowekL.getFont().deriveFont(18f));
        naglowekL.setForeground(new Color(0, 0, 200));

        naglowekP.add(naglowekL);

        //MATMA
        matmaP = new JPanel();
        matmaP.setLayout(new LeftFlowLayout());

        JLabel matmaL = new JLabel("MATEMATYKA:  ");
        matmaL.setFont(matmaL.getFont().deriveFont(12f));

        JTextField matmaTF = new JTextField("", 4);
        matmaTF.setPreferredSize(new Dimension(4,20));

        matmaP.add(matmaL);
        matmaP.add(matmaTF);

        //POLSKI
        polskiP = new JPanel();
        polskiP.setLayout(new LeftFlowLayout());

        JLabel polskiL = new JLabel("JĘZYK POLSKI: ");
        polskiL.setFont(polskiL.getFont().deriveFont(12f));

        JTextField polskiTF = new JTextField("", 4);
        polskiTF.setPreferredSize(new Dimension(4,20));

        polskiP.add(polskiL);
        polskiP.add(polskiTF);

        //JEZYK
        jezykP = new JPanel();
        jezykP.setLayout(new LeftFlowLayout());

        JLabel jezykL = new JLabel("JĘZYK OBCY:    ");
        jezykL.setFont(jezykL.getFont().deriveFont(12f));

        JTextField jezykTF = new JTextField("", 4);
        jezykTF.setPreferredSize(new Dimension(4,20));

        jezykP.add(jezykL);
        jezykP.add(jezykTF);

        //OBLICZ
        obliczP = new JPanel();
        obliczP.setLayout(new LeftFlowLayout());

        JPanel infoP = new JPanel();
        infoP.setLayout(new LeftFlowLayout());
        JLabel infoL = new JLabel("");
        infoL.setFont(infoL.getFont().deriveFont(12f));
        infoP.add(infoL);

        JButton obliczB = new JButton("Oblicz punkty rekrutacyjne");
        obliczB.setPreferredSize(new Dimension(190,33));
        obliczB.setFocusable(false);
        obliczP.add(obliczB);

        obliczB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (matmaTF.getText().equals("")|| polskiTF.getText().equals("") || jezykTF.getText().equals("")) {
                    infoL.setForeground(new Color(0, 0, 200));
                    infoL.setText("Proszę uzupełnić wszystko!");
                } else {
                    if (Integer.parseInt(matmaTF.getText()) < 0 || Integer.parseInt(matmaTF.getText()) > 100 ||
                            Integer.parseInt(polskiTF.getText()) < 0 || Integer.parseInt(polskiTF.getText()) > 100 ||
                            Integer.parseInt(jezykTF.getText()) < 0 || Integer.parseInt(jezykTF.getText()) > 100) {
                        infoL.setForeground(new Color(140, 0, 0));
                        infoL.setText("Proszę wprowadzić poprawne wyniki!");
                    } else {
                        infoL.setForeground(new Color(0, 100, 0));
                        int mat = Integer.parseInt(matmaTF.getText());
                        int jp = Integer.parseInt(polskiTF.getText());
                        int j = Integer.parseInt(jezykTF.getText());
                        infoL.setText("Masz " + obliczWskaznik(mat, jp, j) + " punktów rekrutacyjnych!");
                    }
                }
            }
        });

        add(naglowekP);
        add(matmaP);
        add(polskiP);
        add(jezykP);
        add(obliczP);
        add(infoP);
    }

    public static double obliczWskaznik(int m, int jp, int j) {
        return 2*m + 0.5*jp + 1.5*j;
    }
}
