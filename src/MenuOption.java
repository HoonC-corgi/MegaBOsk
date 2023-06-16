import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MenuOption extends JDialog {
	
	//����üũ ���̾�α� 
	public int count=1;//����
	public JLabel cnt = new JLabel(count+"");//���� ǥ�õ� ���� �� ��ư
	public JButton okbutton = new JButton("Ȯ��");//Ȯ�� ��ư
	JButton minusbutton = new JButton("-");//-��ư
	JButton plusbutton = new JButton("+");//+��ư
	JButton garlicpopcorn = new JButton("����");//���� ��ư
	JButton caramelpopcorn = new JButton("ī���");//ī��� ��ư
	JButton coke = new JButton("�ݶ�");//�ݶ� ��ư
	JButton cidar = new JButton("���̴�");//���̴� ��ư
	JButton tea = new JButton("���Ƽ");//���Ƽ ��ư
	JButton coffee = new JButton("Ŀ��");//������ Ŀ�� ��ư
	
	//����,����,���̵� ���� üũ ���̾�α�
	public MenuOption(String name, String price) {
		setTitle(name);
		setLayout(null);
		minusbutton.setBounds(50,30,60,60);//-��ư ��ġ,ũ��
		plusbutton.setBounds(200,30,60,60);//+��ư ��ġ,ũ��
		cnt.setBounds(150,30,60,60);//���� �� ��ġ,ũ��
		okbutton.setBounds(75,120,160,40);//Ȯ�� ��ư  ��ġ,ũ��
		setVisible(false);		
		
		//-��ư 
		minusbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(0<count) {
					count--;//���� -
					cnt.setText(count+"");//�����󺧿� ǥ��
					}}});		
		
		//+��ư
		plusbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(0<=count) {
					count++;//���� +
					cnt.setText(count+"");//�����󺧿� ǥ��
					}}});		
		
		add(minusbutton);
		add(cnt);
		add(plusbutton);
		add(okbutton);
   		setSize(320, 250);
		setLocation(500,500);
		setResizable(false);
	}
			
	//�޺� ���� üũ ���̾�α� 
	public MenuOption(JFrame frame, String name, String price) {
		setTitle(name);	
		setLayout(null);
		minusbutton.setBounds(142,30,60,60);//-��ư ��ġ,ũ��
		plusbutton.setBounds(282,30,60,60);//+��ư ��ġ,ũ��
		cnt.setBounds(242,30,60,60);//���� �� ��ġ,ũ��
		okbutton.setBounds(170,300,160,40);//Ȯ�� ��ư  ��ġ,ũ��
		garlicpopcorn.setBounds(42,130,80,60);//���� ��ư ��ġ,ũ��
		caramelpopcorn.setBounds(152,130,80,60);//ī��� ��ư ��ġ,ũ��
		coke.setBounds(42,215,80,60);//�ݶ� ��ư ��ġ,ũ��
		cidar.setBounds(152,215,80,60);//���̴� ��ư ��ġ,ũ��
		tea.setBounds(262,215,80,60);//���Ƽ ��ư ��ġ,ũ��
		coffee.setBounds(372,215,80,60);//������ Ŀ�� ��ư ��ġ,ũ��
		setVisible(false);//���̾�αװ� ������ �ʰ� ����
		
		//-��ư 
		minusbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(0<count) {
					count--;//���� -
					cnt.setText(count+"");//�����󺧿� ǥ��
					}}});		
		
		//+��ư
		plusbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(0<=count) {
					count++;//���� +
					cnt.setText(count+"");//�����󺧿� ǥ��
					}}});		
		//����
		garlicpopcorn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				garlicpopcorn.setBackground(Color.GRAY);
					}});	
		//ī���
		caramelpopcorn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caramelpopcorn.setBackground(Color.GRAY);
					}});	
		//�ݶ�
		coke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coke.setBackground(Color.GRAY);
					}});	
		//���̴�
		cidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cidar.setBackground(Color.GRAY);
					}});
		//���Ƽ
		tea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tea.setBackground(Color.GRAY);
					}});	
		//������Ŀ��
		coffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setBackground(Color.GRAY);
					}});	
		
		add(minusbutton);
		add(cnt);
		add(plusbutton);
		add(okbutton);
        add(garlicpopcorn);
        add(caramelpopcorn);
        add(coke);
        add(cidar);
        add(tea);
        add(coffee);
		setSize(500, 400);
		setLocation(500,500);
		setResizable(false);
	}
	
	//������ 
	JLabel detail = new JLabel("�ֹ� ����");
	String []head_re = {"��ǰ��", "����", "����"};//������ ���̺� ���
	String [][]data_re= {};//������ ������ 
	public DefaultTableModel model_re = new DefaultTableModel(data_re,head_re);//���̺� �� ����
	public JTable busket_re = new JTable(model_re);//��ٱ��� ���̺� ��ü ����
	
	JLabel pay_re= new JLabel("���� �ݾ�:");//������ ���� �ݾ�
	public JLabel paytext_re = new JLabel("0��");//�ݾ� ǥ�� ��

	JLabel requestlabel= new JLabel("��û ����");//������ ��û����
	public JTextArea requesttext = new JTextArea();//��û���� ���� �κ�
	
	public JButton okbutton_re=new JButton("Ȯ��");//Ȯ�� ��ư
	
	//������ ���̾�α� 
	public MenuOption(JFrame frame, String name) {
		super(frame,name);
		setLayout(null);
		
		detail.setBounds(150,40,200,45);//�ֹ� ���� �� ��ġ,ũ�� 
		detail.setFont(new Font("���� ���",Font.BOLD,40));//��Ʈ
		add(detail);//������ ���̾�α׿� �ֹ��Ϸ� �� ���� 
		
		JScrollPane scroll_busket_re=new JScrollPane(busket_re);//������ ��ũ�� 
		scroll_busket_re.setBounds(50,100,400,300);//��ũ�� ��ġ,ũ��
		add(scroll_busket_re);
		
		pay_re.setBounds(50,600,200,50);//���� �ݾ� �� ��ġ,ũ�� 
		pay_re.setFont(new Font("���� ���",Font.BOLD,35));// ��Ʈ
		add(pay_re);
		
		paytext_re.setBounds(250,600,200,50);//���� �ݾ��� ���� �� ��ġ,ũ�� 
		paytext_re.setFont(new Font("���� ���",Font.BOLD,35));// ��Ʈ
		add(paytext_re); 
		
		requestlabel.setBounds(50,415,400,25);//��û ���� �� ��ġ,ũ��
		add(requestlabel);

		requesttext.setBounds(50,435,400,150);//��û����  �ؽ�Ʈ ��ġ,ũ��
		requesttext.setFont(new Font("���� ���",Font.BOLD,25));//��Ʈ
		add(requesttext);
		
		okbutton_re.setBounds(200,680,100,50);//Ȯ�� ��ư
		add(okbutton_re); 
	
		setSize(500, 800);
		setLocation(500,0);
		setVisible(false);
		
	}
	

	JLabel label = new JLabel("��ǰ �������ּ���.");//��ǰ ���� ��
	public JButton button = new JButton("Ȯ��");//Ȯ�� ��ư
	public MenuOption(JFrame frame) {
		super(frame,"��ǰ ����");
        setLayout(null);       
        label.setBounds(0,0,500,100);  //��ǰ ���� �� ��ġ,ũ��
        label.setFont(new Font("���� ���",Font.BOLD,35));//��Ʈ       
        button.setBounds(200,100,100,50);
        add(label);
		add(button);
		
		setSize(500,200);
		setLocation(500,400);
        setVisible(false);
	}	
	
	
	public JButton button1 = new JButton("Ȯ��");//Ȯ�� ��ư
	public MenuOption() { //���� ����
	setTitle("���� ����"); 
	setLayout(null);
	JLabel c = new JLabel("���ݰ�����  ī���Ϳ��� �����մϴ�."); //���� ���� ��
	c.setBounds(0,0,500,100);//���� ���� �� ��ġ, ũ��
	c.setFont(new Font("���� ���",Font.BOLD,25));//��Ʈ
	button1.setBounds(150,100,100,50);
	add(c);
	add(button1);
	
	setSize(425,250);
	setLocation(500,400);
	setVisible(false);
	}
	
	public JTextField phonetext = new JTextField(20);
	public JButton savingbutton = new JButton("Ȯ��");//Ȯ�� ��ư
	public MenuOption(String name) {	 //����Ʈ ����
		setTitle("�ް��ڽ� ����Ʈ ����");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("��ȭ��ȣ�� �Է��� �� Ȯ�ι�ư�� �����ּ���")); //����Ʈ ���� ��
		c.add(new JLabel("������ ���Ͻ��� ������ Ȯ�ι�ư�� �����ּ���"));
		c.add(phonetext);
		c.add(savingbutton);
		savingbutton.setBounds(150,180,100,50);
	
		setSize(300,200);
		setLocation(500,400);
		setVisible(false);
		}

}