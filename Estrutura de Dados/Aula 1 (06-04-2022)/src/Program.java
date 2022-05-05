import javax.swing.JOptionPane;

public class Program {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Digite seu nome:");
        JOptionPane.showMessageDialog(null, "Hello, " + name + "!");
    }
}
