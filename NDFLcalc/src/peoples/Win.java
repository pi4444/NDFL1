package peoples;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Win extends JFrame{
public Win(){
super("Окно авторизации");//создаем окно
setBounds(800, 400, 400, 200);//определяем размеры окна
JPanel panel1=new JPanel();//объявляем панель
GridLayout layout = new GridLayout(5, 2, 5, 6);//определяем расположение элементов
JLabel text1=new JLabel("Введите логин:");
String right_login="User";
String right_password="1991";
String right_login_adm="Admin";
String right_password_adm="9119";
JLabel text2=new JLabel("Введите пароль:");//объявляем текстовые строки
JTextField box1=new JTextField();
JTextField box2=new JTextField();//объявляем поля для ввода
JRadioButton SW = new JRadioButton("Пользователь",true);
JRadioButton SW1 = new JRadioButton("Администратор",false);
JButton go=new JButton("Войти");//объявляем кнопки
panel1.setLayout(layout);//определяем расположение элементов для панели
//добавляем текстовые строки и поля для ввода
panel1.add(SW);panel1.add(SW1);
panel1.add(text1);panel1.add(box1);
panel1.add(text2);panel1.add(box2);
panel1.add(go);
SW.setBackground(new Color(182,234,131));
SW1.setBackground(new Color(182,234,131));
//определяем цвет панели
panel1.setBackground(new Color(182,234,131));
setContentPane(panel1);//устанавливаем панель содержимого для окна
setVisible(true);//делаем окно видимым
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//определяем способ закрытия
ButtonGroup group = new ButtonGroup();
group.add(SW);
group.add(SW1);
go.addActionListener(new ActionListener() {//добавляем слушателя на кнопку
public void actionPerformed(ActionEvent e) {
	if(SW.isSelected()) {
	
		if(box1.getText( ).equals(right_login)) {
		
			if(box2.getText( ).equals(right_password)) {
			Prog prog=new Prog();
			prog.show();
			setVisible(false);
			}else {final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel,"Логин или пароль введены неверно!", "Ошибка", JOptionPane.ERROR_MESSAGE);
			box1.setText("");
			box2.setText("");}
		}else {final JPanel panel = new JPanel();
		JOptionPane.showMessageDialog(panel,"Логин или пароль введены неверно!", "Ошибка", JOptionPane.ERROR_MESSAGE);
		box1.setText("");
		box2.setText("");}
}
	if(SW1.isSelected()) {
		
		if(box1.getText( ).equals(right_login_adm)) {
		
			if(box2.getText( ).equals(right_password_adm)) {
			ProgAdm progadm=new ProgAdm();
			progadm.show();
			setVisible(false);
			}else {final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel,"Логин или пароль введены неверно!", "Ошибка", JOptionPane.ERROR_MESSAGE);
			box1.setText("");
			box2.setText("");}
		}else {final JPanel panel = new JPanel();
		JOptionPane.showMessageDialog(panel,"Логин или пароль введены неверно!", "Ошибка", JOptionPane.ERROR_MESSAGE);
		box1.setText("");
		box2.setText("");}
}}
});
}

public static void main(String[] args) {
	Win s=new Win();
}
}