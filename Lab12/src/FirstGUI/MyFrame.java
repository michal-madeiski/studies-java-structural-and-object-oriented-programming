package FirstGUI;

import javax.swing.*;

public class MyFrame extends JFrame {
    JPanel gornyPanel;
    JPanel dolnyPanel;
    public MyFrame() {
        super("Rekrutacja na studia");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setLocation(350,100);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        gornyPanel = new JPanel();
        gornyPanel.setLayout(new BoxLayout(gornyPanel, BoxLayout.X_AXIS));

        dolnyPanel = new JPanel();
        dolnyPanel.setLayout(new BoxLayout(dolnyPanel, BoxLayout.X_AXIS));

        PanelDaneOsobowe panelDaneOsobowe = new PanelDaneOsobowe();
        PanelStudia panelStudia = new PanelStudia();
        PanelMatura panelMatura = new PanelMatura();
        PanelGrafika panelGrafika = new PanelGrafika("obrazek.jpg");

        gornyPanel.add(panelDaneOsobowe);
        gornyPanel.add(new JSeparator(SwingConstants.VERTICAL));
        gornyPanel.add(panelStudia);

        dolnyPanel.add(panelMatura);
        dolnyPanel.add(new JSeparator(SwingConstants.VERTICAL));
        dolnyPanel.add(panelGrafika);

        add(gornyPanel);
        add(new JSeparator(SwingConstants.HORIZONTAL));
        add(dolnyPanel);

        //pack();
        setVisible(true);
    }
}
