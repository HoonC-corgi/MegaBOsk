
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.*;


public class MenuPanel extends JPanel{ //JPanel�� ��ӹ޾� �г����� Ŭ���� �����
	
	JPanel[]panel;//��ǰ �г� ���۷���
	JPanel[]label;//��ǰ �� ���۷���
	JLabel[] productname;//��ǰ �̸� ���۷���
	JLabel[] productprice;//��ǰ ���� ���۷���
	public JButton [] productbutton;//��ǰ ��ư ���۷���
	ImageIcon[] productimage;//��ư �̹��� ���۷���
    
	FileInputStream file_n; 
	FileInputStream file_p; 	
	public String []name;//��ǰ �̸� ���� �迭 
	String nametmp;
	int i =0;
	public String []price; //��ǰ ���� ���� �迭 
	String pricetmp;
	int j=0;
	
	//MenuOption[] dialog;
	
	
    public MenuPanel(int cnt, String namefile, String pricefile) {
    	//��ǰ �г� ����
    	panel = new JPanel[cnt];//��ǰ�� ������ŭ ��ǰ �г� ���۷��� ����
    	label=new JPanel[cnt];//��ǰ�� ���� ��ŭ ��ǰ�� �̸��� ������ ǥ���� �� ���۷��� ����
    	productname = new JLabel[cnt];//��ǰ�� ������ŭ ��ǰ �г��� �� ���۷��� ����
    	productprice = new JLabel[cnt];//��ǰ�� ������ŭ ��ǰ �г��� �� ���۷��� ����
    	productbutton = new JButton[cnt];//��ǰ�� ������ŭ ��ǰ �г��� ��ư ���۷��� ����
    	productimage = new ImageIcon[cnt];//��ǰ�� ������ŭ ��ư�� �̹��� ���۷��� ����
    	name = new String[cnt];//���Ͽ��� ��ǰ�� ������ŭ ��ǰ �̸��� ���� ��Ʈ��  �迭 ����
    	price = new String[cnt];//���Ͽ��� ��ǰ�� ������ŭ ��ǰ ������ ���� ��Ʈ�� �迭 ����
        
    	
    	setLayout(null);
        setBackground(Color.WHITE);//�г��� ���� ���
        
        try {
        	file_n = new FileInputStream("files/"+namefile+".txt");//��ǰ �̸� ������ ã�Ƽ� file_n��ü ����
        	InputStreamReader in = new InputStreamReader(file_n,"UTF-8");//file_n��ü�� ���� �� �ִ� in��ü�� ����
        	BufferedReader reader = new BufferedReader(in);//in��ü�� ���۽�Ʈ����ü�� ����
        	
        	//���� �����
        	while((nametmp = reader.readLine())!=null){
        		name[i]=nametmp;
        		i++;
        	}
        	in.close();
        }
        catch(IOException e) {
        	System.out.println(e);
        }
        
        try {
        	file_p = new FileInputStream("files/"+pricefile+".txt");//�����ڿ��� ���� ��ǰ ���� ������ ã�Ƽ� file_p��ü ����
        	InputStreamReader in = new InputStreamReader(file_p,"UTF-8");//file_p��ü�� ���� �� �ִ� in��ü�� ����
        	BufferedReader reader = new BufferedReader(in);//in��ü�� ���۽�Ʈ����ü�� ����
        	
        	//���Ͽ��� ������ ���������� ���پ� �������� pricetmp�� �Է�.
        	while((pricetmp=reader.readLine())!=null){
        		price[j]=pricetmp;
        		j++;
        	}
        	in.close();
        }
        catch(IOException e) {
        	System.out.println(e);
        }
    	
    	 for(int i=0; i<cnt; i++) {
    		panel[i]=new JPanel();//��ǰ �г� ��ü ����
    		panel[i].setLayout(new BorderLayout());//BorderLayout ����
         	
         	label[i]=new JPanel();//��ǰ �� �г� ����
         	label[i].setLayout(new GridLayout(1,2));//��ġ ����
         	label[i].setBackground(Color.WHITE);//������ �������
         	productname[i]=new JLabel(name[i]);//��ǰ �̸� ��
         	productprice[i]=new JLabel(price[i]+"��");//��ǰ ���� ��
         	label[i].add(productname[i]);//��ǰ �� �гο� �̸� �� �ֱ�
         	label[i].add(productprice[i]);//��ǰ �� �гο� ���� �� �ֱ�
         	productimage[i] = new ImageIcon("images/"+name[i]+".png");//images���Ͽ��� ��ǰ �̸��� �̹����� ã��
         
         	productbutton[i]=new JButton(productimage[i]);//��ǰ�� �̹����� �־ ��ư ��ü ����
         	productbutton[i].setBackground(Color.WHITE);//��ư�� ���
         	panel[i].add(productbutton[i],BorderLayout.CENTER);//CENTER�� ��ư ����
         	panel[i].add(label[i],BorderLayout.SOUTH);//SOUTH�� ��ǰ �� ����
         	panel[i].setBackground(Color.WHITE);//���� ���
         	panel[i].setBounds(350*(i%3),350*(i/3),350,350);
         	add(panel[i]);         	
     	}
    }
}