package FirstGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelStudia extends JPanel {
    JPanel gornyPanel;
    JPanel dolnyPanel;
    public PanelStudia() {
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

        JLabel naglowekL = new JLabel("WYBÓR STUDIÓW:");
        naglowekL.setFont(naglowekL.getFont().deriveFont(18f));
        naglowekL.setForeground(new Color(0, 0, 200));

        naglowekP.add(naglowekL);

        //OPCJE
        JPanel opcjeP = new JPanel();
        opcjeP.setLayout(new GridLayout(2,1));

        JLabel opcjeL = new JLabel("WYBIERZ STOPIEŃ STUDIÓW: ");
        opcjeL.setFont(opcjeL.getFont().deriveFont(12f));

        JLabel pom = new JLabel();
        pom.setLayout(new LeftFlowLayout());
        JRadioButton opcjeB1 = new JRadioButton("Studia I stopnia");
        JRadioButton opcjeB2 = new JRadioButton("Studia II stopnia");
        ButtonGroup opcjeBG = new ButtonGroup();
        opcjeB1.setFocusable(false);
        opcjeB2.setFocusable(false);
        opcjeBG.add(opcjeB1);
        opcjeBG.add(opcjeB2);
        pom.add(opcjeB1);
        pom.add(opcjeB2);

        opcjeP.add(opcjeL);
        opcjeP.add(pom);

        //WYDZIAŁ
        JPanel wydzialP = new JPanel();
        wydzialP.setLayout(new LeftFlowLayout());

        JLabel wydzialL = new JLabel("WYBIERZ WYDZIAŁ: ");
        wydzialL.setFont(wydzialL.getFont().deriveFont(12f));

        String[] optionsW = new String[4];
        for (int i = 0; i < 4; i++) {
            optionsW[i] = "W" + (i + 1);
        }

        JComboBox wydzialCB = new JComboBox<>(optionsW);
        wydzialCB.setPreferredSize(new Dimension(45,20));
        wydzialCB.setFocusable(false);
        wydzialCB.setSelectedItem(null);

        String[] optionsK = new String[1];
        optionsK[0] = "Wybierz wydział";
        JComboBox kierunekCB = new JComboBox<>(optionsK);
        kierunekCB.setPreferredSize(new Dimension(165,20));
        kierunekCB.setFocusable(false);
        kierunekCB.setSelectedItem(null);

        wydzialCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wybor = (String) wydzialCB.getSelectedItem();
                String[] newOptionsK = new String[4];

                switch(wybor) {
                    case "W1":
                        newOptionsK = new String[]{"Informatyka Stosowana", "Inżynieria Systemów", "Cyberbezpieczeństwo"};
                        break;
                    case "W2":
                        newOptionsK = new String[]{"Matematyka", "Matematyka Stosowana", "Analiza Danych"};
                        break;
                    case "W3":
                        newOptionsK = new String[]{"Fizyka", "Fizyka Stosowana"};
                        break;
                    case "W4":
                        newOptionsK = new String[]{"Język Polski", "Język Obcy", "Sport", "Psychologia"};
                        break;
                    default:
                        break;
                }

                DefaultComboBoxModel<String> newKierunekCB = new DefaultComboBoxModel<>(newOptionsK);
                kierunekCB.setModel(newKierunekCB);
                kierunekCB.setSelectedItem(null);
            }
        });

        wydzialP.add(wydzialL);
        wydzialP.add(wydzialCB);

        //KIERUNEK
        JPanel kierunekP = new JPanel();
        kierunekP.setLayout(new LeftFlowLayout());

        JLabel kierunekL = new JLabel("WYBIERZ KIERUNEK: ");
        kierunekL.setFont(kierunekL.getFont().deriveFont(12f));

        kierunekP.add(kierunekL);
        kierunekP.add(kierunekCB);

        //ZATWIERDZ + INFO
        JPanel infoP = new JPanel();
        infoP.setLayout(new LeftFlowLayout());
        JLabel infoL = new JLabel("");
        infoL.setFont(infoL.getFont().deriveFont(10f));
        infoP.add(infoL);

        JPanel zatwierdzP = new JPanel();
        zatwierdzP.setLayout(new FlowLayout());

        JButton zatwierdzB = new JButton("Zatwierdź wybory");
        zatwierdzB.setPreferredSize(new Dimension(150,50));
        zatwierdzB.setFocusable(false);
        zatwierdzP.add(zatwierdzB);

        zatwierdzB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (opcjeBG.getSelection() == null || wydzialCB.getSelectedItem() == null || kierunekCB.getSelectedItem() == null) {
                    infoL.setForeground(new Color(0, 0, 200));
                    infoL.setText("Proszę uzupełnić wszystko!");
                } else {
                    infoL.setForeground(new Color(0, 100, 0));
                    infoL.setText("Pomyślnie zatwierdzono wybory!");
                }
            }
        });

        gornyPanel.add(naglowekP);
        gornyPanel.add(opcjeP);
        gornyPanel.add(wydzialP);
        gornyPanel.add(kierunekP);

        dolnyPanel.add(zatwierdzP);
        dolnyPanel.add(infoP);

        add(gornyPanel);
        add(dolnyPanel);
    }
}
