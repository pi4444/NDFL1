package peoples;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class Prog extends JFrame{
private static final long serialVersionUID = 1L;
public static Prog frams = new Prog();

private JPanel panel, panel1;
private JButton calc;
private JLabel label_1,label_2,label_3, label_4,label_n,sum_n,sum;
public static JTextField sum_ok;
public static JRadioButton rad_13, rad_15, rad_30, rad_35;
public static float int_rad=13;
float result;
float rez;
public Prog() {
setTitle("Калькулятор НДФЛ");
setSize(320, 240);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
label_n = new JLabel("");
sum_n = new JLabel("", JLabel.CENTER);
sum = new JLabel("", JLabel.CENTER);
calc = new JButton("Рассчитать");
sum_ok = new JTextField();
sum_ok.setHorizontalAlignment(JTextField.CENTER);
sum_ok.setMargin(new Insets(2, 5, 2, 5));
ButtonGroup group = new ButtonGroup();
rad_13 = new JRadioButton("13%",true);
group.add(rad_13);
rad_13.setHorizontalAlignment(JRadioButton.CENTER);
rad_15 = new JRadioButton("15%", false);
group.add(rad_15);
rad_15.setHorizontalAlignment(JRadioButton.CENTER);
rad_30 = new JRadioButton("30%", false);
group.add(rad_30);
rad_30.setHorizontalAlignment(JRadioButton.CENTER);
rad_35 = new JRadioButton("35%", false);
group.add(rad_35);
rad_35.setBackground(new Color(182,234,131));
rad_35.setHorizontalAlignment(JRadioButton.CENTER);
panel.add(label_1);
panel.add(sum_ok);
panel.add(label_2);
panel.add(label_n);
panel.add(rad_13);
panel.add(rad_15);
panel.add(rad_30);
panel.add(rad_35);
panel.add(label_3);
panel.add(sum_n);
panel.add(label_4);
panel.add(sum);
panel1.add(calc);
panel.setBackground(new Color(182,234,131));
panel1.setBackground(new Color(182,234,131));
rad_13.setBackground(new Color(182,234,131));
rad_15.setBackground(new Color(182,234,131));
rad_30.setBackground(new Color(182,234,131));
rad_35.setBackground(new Color(182,234,131));
sum_ok.addKeyListener(new KeyAdapter() {
	   public void keyReleased(KeyEvent e) {
		      if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE|(e.getKeyCode() == KeyEvent.VK_PERIOD)) {
		    	  return;
		      }
		      char t = e.getKeyChar();
		      if ((t < '0') || (t > '9')){
		    	 final JPanel panel = new JPanel();
				 JOptionPane.showMessageDialog(panel,"Введен недопустимый символ!", "Ошибка", JOptionPane.ERROR_MESSAGE);
		         e.consume();  // игнорим введенные буквы и пробел
		         sum_ok.setText("");;
		      }
	   }});

rad_13.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
int_rad=13;
		sum_n.setText("");
		sum.setText("");
	}
});
rad_15.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		int_rad=15;
		sum_n.setText("");
		sum.setText("");
	}
});
rad_30.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		int_rad=30;
		sum_n.setText("");
		sum.setText("");
	}
});
rad_35.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		int_rad=35;
		sum_n.setText("");
		sum.setText("");
	}
});
calc.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
Float sumok = Float.parseFloat((sum_ok.getText( )));
sum_n.setText(""+ (result= Calculation.Calc_n(int_rad,sumok)));
sum.setText(""+ (rez= Calculation.Calc_nar(sumok,result)));
}
});}

}
