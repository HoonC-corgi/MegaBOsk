
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Request extends JPanel{
	
	String []head = {"��ǰ��", "����", "����"};//���̺� ���
	String [][]data= {};//���̺� ����
	
	public DefaultTableModel table = new DefaultTableModel(data,head);//���̺� �� ����
	public JTable cart = new JTable(table);//��ٱ��� ���̺� ��ü ����
	public JButton menudelete = new JButton("������ �޴� ����");//��ٱ��� ���� ��ư
    
    JLabel paylabel = new JLabel("���� �ݾ�");//���� �ݾ� �� ��ü ����
    public JLabel paysum = new JLabel(" ");//�ݾ��� ǥ�õ� �� ��ü ����
      
    JLabel request_lab = new JLabel("��û ����");//"��û ���� �� 
    public JTextArea request_write = new JTextArea(); //��û ���� �ؽ�Ʈ
    
    public JButton order = new JButton("�ֹ�");//�ֹ� ��ư
    public JButton cancel = new JButton("���");//��� ��ư
    
    public JButton choice_pay1 = new JButton("ī�� ����");//ī�� ���� ��ư
    public JButton choice_pay2 = new JButton("���� ����");//���� ���� ��ư
       
    public int allprice=0;//��ü �ݾ� 0���� �ʱ�ȭ
   
    public Request() {
    	setLayout(null);	
    	JScrollPane scrollbusket = new JScrollPane(cart);//��ٱ��� ��ũ��
    	scrollbusket.setBounds(0,0,525,135);//��ũ�� ��ġ,ũ��
    	add(scrollbusket);//��ũ�� �ֱ�
    	
        request_lab.setBounds(525,0,525,20);//��û���׶�
        add(request_lab);
        request_write.setFont(new Font("���� ���",Font.BOLD,22));
        JScrollPane scrollrequest = new JScrollPane(request_write);//��û ���� ��ũ�� ����
        scrollrequest.setBounds(525,20,525,110);//��ũ�� �ؽ�Ʈ ��ġ,ũ��
        add(scrollrequest);
                
        choice_pay1.setBounds(525,130,262,30);//ī�� ���� ��ư
        add(choice_pay1);
        choice_pay2.setBounds(788,130,262,30);//���� ���� ��ư
        add(choice_pay2);
        
        order.setFont(new Font("���� ���",Font.BOLD,50));//�ֹ� ���� ũ��
        order.setBackground(Color.RED);//�ֹ� ����
        order.setBounds(525,160,262,85);
        add(order);
         
        cancel.setFont(new Font("���� ���",Font.BOLD,50));//��� ���� ũ��
        cancel.setBackground(Color.GRAY);//��� ����
        cancel.setBounds(787,160,262,85);
        add(cancel);
    	
    	menudelete.setBounds(0,130,525,30);
    	add(menudelete);//���� ��ư ����
    	    	
    	paylabel.setBounds(0,150,150,100);//���� �ݾ� �� 
    	paylabel.setFont(new Font("���� ���",Font.BOLD,33));//���� ��Ʈ
        add(paylabel);
               
        paysum.setBounds(150,160,375,81);//�ݾ��� ǥ�õ� ��
        paysum.setFont(new Font("���� ���",Font.BOLD,57));//�ݾ� ���� ��Ʈ
        paysum.setBackground(Color.white);//���� ����
        paysum.setOpaque(true);
        add(paysum);
    }
}