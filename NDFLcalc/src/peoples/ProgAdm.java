package peoples;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import peoples.Calculation;
public class ProgAdm extends JFrame{
private static final long serialVersionUID = 1L;
public static ProgAdm frame = new ProgAdm();
float result;
float rez;
private JPanel panel, panel1;
private JButton calc;
private JLabel label_1,label_2,label_3, label_4,sum_n,sum;
public static JTextField sum_ok;
public static JTextField sum_proc;
public static int int_rad;
public ProgAdm() {
setTitle("Калькулятор НДФЛ");
setSize(320, 240);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout (new BorderLayout()); 
panel = new JPanel();
panel1 = new JPanel();
add(panel, BorderLayout.CENTER);
add(panel1, BorderLayout.SOUTH);
panel.setBorder(new EmptyBorder(10,10,10,10));
panel1.setBorder(new EmptyBorder(10,10,10,10));
panel.setLayout(new GridLayout(6,2,15,0));
panel1.setLayout(new GridLayout(1,1));
label_1 = new JLabel("Сумма оклада, руб.", JLabel.LEFT);
label_2 = new JLabel("Налоговая ставка", JLabel.LEFT);
label_3 = new JLabel("Сумма налога, руб.", JLabel.LEFT);
label_4 = new JLabel("Сумма на руки, руб.", JLabel.LEFT);
sum_n = new JLabel("", JLabel.CENTER);
sum = new JLabel("", JLabel.CENTER);
calc = new JButton("Рассчитать");
sum_ok = new JTextField();
sum_ok.setHorizontalAlignment(JTextField.CENTER);
sum_ok.setMargin(new Insets(2, 5, 2, 5));
sum_proc = new JTextField();
sum_proc.setHorizontalAlignment(JTextField.CENTER);
sum_proc.setMargin(new Insets(2, 5, 2, 5));
panel.add(label_1);
panel.add(sum_ok);
panel.add(label_2);
panel.add(sum_proc);
panel.add(label_3);
panel.add(sum_n);
panel.add(label_4);
panel.add(sum);
panel1.add(calc);
panel.setBackground(new Color(182,234,131));
panel1.setBackground(new Color(182,234,131));
calc.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
Float sumok = Float.parseFloat((sum_ok.getText( )));
Float sumproc = Float.parseFloat((sum_proc.getText( )));
sum_n.setText(""+ (result=  Calculation.Calc_n(sumproc,sumok)));
sum.setText(""+ (rez=  Calculation.Calc_nar(sumok,result)));
}
});
sum_ok.addKeyListener(new KeyAdapter() {
	   public void keyReleased(KeyEvent e) {
		      if ((e.getKeyCode() == KeyEvent.VK_BACK_SPACE)|(e.getKeyCode() == KeyEvent.VK_PERIOD)) {
		    	  return;
		      }
		      char t = e.getKeyChar();
		      if ((t < '0') || (t > '9')){
		    	 final JPanel panel = new JPanel();
				 JOptionPane.showMessageDialog(panel,"Введен недопустимый символ!", "Ошибка", JOptionPane.ERROR_MESSAGE);
		         e.consume();  // игнорим введенные буквы и пробел
		         sum_ok.setText("");
		      }
	   }});
sum_proc.addKeyListener(new KeyAdapter() {
	   public void keyReleased(KeyEvent e) {
		      if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		    	  return;
		      }
		      char t = e.getKeyChar();
		      if ((t < '0') || (t > '9')){
		    	 final JPanel panel = new JPanel();
				 JOptionPane.showMessageDialog(panel,"Введен недопустимый символ!", "Ошибка", JOptionPane.ERROR_MESSAGE);
		         e.consume();  // игнорим введенные буквы и пробел
		         sum_proc.setText("");
		      }
	   }});}}
