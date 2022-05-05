import javax.swing.*;
import java.awt.*;

public class testePanel {
    public static void main(String[] args) {
        JFrame myWindow;

        myWindow = new JFrame();
        myWindow.setSize(800, 600);

        myWindow.setTitle("COTUCA SOLITAIRE 2022");
        myWindow.getContentPane().setBackground(Color.BLACK);
        JOptionPane.showMessageDialog(null, "Você verá um Jframe aparece", "Mensagem", JOptionPane.WARNING_MESSAGE);

        myWindow.setVisible(true);
    }
}
