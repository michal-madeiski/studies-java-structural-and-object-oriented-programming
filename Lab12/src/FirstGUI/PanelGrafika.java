package FirstGUI;

import javax.swing.*;
import java.awt.*;

public class PanelGrafika extends JPanel {
    Image obrazek;
     public PanelGrafika(String sciezka) {
         setLayout(new BorderLayout());
         obrazek = new ImageIcon(sciezka).getImage();
     }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(obrazek, 0, 0, getWidth(), getHeight(), this);
    }
}
