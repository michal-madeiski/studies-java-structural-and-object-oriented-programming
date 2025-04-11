package FirstGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDaneOsobowe extends JPanel {
    JPanel gornyPanel;
    JPanel dolnyPanel;
    public PanelDaneOsobowe() {
        super();
        setPreferredSize(new Dimension(400,450));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        gornyPanel = new JPanel();
        gornyPanel.setPreferredSize(new Dimension(400, 350));
        gornyPanel.setLayout(new GridLayout(4, 1));

        dolnyPanel = new JPanel();
        dolnyPanel.setPreferredSize(new Dimension(400, 100));
        dolnyPanel.setLayout(new BoxLayout(dolnyPanel, BoxLayout.Y_AXIS));

        //NAGŁÓWEK
        JPanel naglowekP = new JPanel();
        naglowekP.setLayout(new FlowLayout());

        JLabel naglowekL = new JLabel("DANE OSOBOWE: ");
        naglowekL.setFont(naglowekL.getFont().deriveFont(18f));
        naglowekL.setForeground(new Color(0, 0, 200));

        naglowekP.add(naglowekL);

        //IMIE
        JPanel imieP = new JPanel();
        imieP.setLayout(new LeftFlowLayout());

        JLabel imieL = new JLabel("IMIĘ:             ");
        imieL.setFont(imieL.getFont().deriveFont(12f));

        JTextField imieTF = new JTextField("", 20);
        imieTF.setPreferredSize(new Dimension(20,20));

        imieP.add(imieL);
        imieP.add(imieTF);

        //NAZWISKO
        JPanel nazwiskoP = new JPanel();
        nazwiskoP.setLayout(new LeftFlowLayout());

        JLabel nazwiskoL = new JLabel("NAZWISKO: ");
        nazwiskoL.setFont(nazwiskoL.getFont().deriveFont(12f));
        JTextField nazwiskoTF = new JTextField("", 20);
        nazwiskoTF.setPreferredSize(new Dimension(20,20));

        nazwiskoP.add(nazwiskoL);
        nazwiskoP.add(nazwiskoTF);

        //EMAIL
        JPanel emailP = new JPanel();
        emailP.setLayout(new LeftFlowLayout());

        JLabel emailL = new JLabel("E-MAIL:        ");
        JTextField emailTF = new JTextField("", 20);
        emailTF.setPreferredSize(new Dimension(20,20));

        emailP.add(emailL);
        emailP.add(emailTF);

        //ZGODY
        JPanel zgodyP = new JPanel();
        zgodyP.setLayout(new LeftFlowLayout());

        JCheckBox zgodyCHB = new JCheckBox("Wyrażam zgodę na przetwarzanie moich danych osobowych");
        zgodyCHB.setFont(zgodyCHB.getFont().deriveFont(9f));
        zgodyCHB.setFocusable(false);
        zgodyP.add(zgodyCHB);

        //ZATWIERDZ
        JPanel zatwierdzP = new JPanel();
        zatwierdzP.setLayout(new FlowLayout());

        JPanel infoP = new JPanel();
        infoP.setLayout(new LeftFlowLayout());
        JLabel infoL = new JLabel("");
        infoL.setFont(infoL.getFont().deriveFont(10f));
        infoP.add(infoL);

        JButton zatwierdzB = new JButton("Zatwierdź dane osobowe");
        zatwierdzB.setPreferredSize(new Dimension(175,25));
        zatwierdzB.setFocusable(false);
        zatwierdzP.add(zatwierdzB);

        zatwierdzB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imieTF.getText().equals("")|| nazwiskoTF.getText().equals("") || emailTF.getText().equals("")) {
                    infoL.setForeground(new Color(0, 0, 200));
                    infoL.setText("Proszę uzupełnić wszystko!");
                } else {
                    if (zgodyCHB.isSelected()) {
                        infoL.setForeground(new Color(0, 100, 0));
                        infoL.setText("Pomyślnie zatwierdzono dane osobowe!");
                    } else {
                        infoL.setForeground(new Color(140, 0, 0));
                        infoL.setText("Proszę wyraźić zgodę na przetwarzanie danych osobowych!");
                    }
                }
            }
        });

        gornyPanel.add(naglowekP);
        gornyPanel.add(imieP);
        gornyPanel.add(nazwiskoP);
        gornyPanel.add(emailP);

        dolnyPanel.add(zgodyP);
        dolnyPanel.add(zatwierdzP);
        dolnyPanel.add(infoP);

        add(gornyPanel);
        add(dolnyPanel);
    }
}
