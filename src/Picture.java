
import javax.swing.*;
import java.awt.*;

//JPanel�� ��ӹ޾� �г��������� Ŭ���� �ۼ�
public class Picture extends JPanel {
		
	    private ImageIcon icon = new ImageIcon("images/picture.png");//�̹��� ������ ã�� ImageIcon��ü ����
		private Image img = icon.getImage(); //ImageIcon�� �̹����� �ҷ��� Image��ü ���� 
		
		public void paintComponent(Graphics p) { //paintComponent�޼ҵ带 �������̵�
			super.paintComponent(p);
			p.drawImage(img, 0, 0, getWidth(), getHeight(), this);//�г� â�� �°� �̹��� ũ�� ����
		}
}