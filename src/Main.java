import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//JFrame�� ��ӹ޾� Ŭ���� �����
public class Main extends JFrame {

	Picture picture;// ��� ����

	JTabbedPane pane; // �޴� ���� ���۷���
	MenuPanel combomenu;// �޺� �г� ���۷���
	MenuPanel drinkmenu;// ���� �г� ���۷���
	MenuPanel popcornmenu;// ���� �г� ���۷���
	MenuPanel sidemenu;// ���̵� �г� ���۷���
	Request request;

	MenuOption[] combo = new MenuOption[6];// �޺� �޴� ���̾�α�
	MenuOption[] drink = new MenuOption[5];// ���� �޴� ���̾�α�
	MenuOption[] popcorn = new MenuOption[3];// ���� �޴� ���̾�α�
	MenuOption[] side = new MenuOption[5];// ���̵� �޴� ���̾�α�

	MenuOption receipt;// ������ ���̾�α�
	MenuOption nocheck_re;// ��ǰ�� �������� �ʾ��� �� ���̾�α�
	MenuOption payment; // ���� ���� ���̾�α�
	MenuOption text; // ����Ʈ ���� ���̾�α�

	public Main() {
		setTitle("MegaBOsk");// frame Ÿ��Ʋ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ������ �����츦 ������ ���α׷��� �����ϵ��� ����
		Container c = getContentPane();// ����Ʈ ��
		c.setLayout(null);
		c.setBackground(Color.WHITE);// ����Ʈ ���� ���� ���

		// ��
		picture = new Picture();// Picture ��ü�� ����
		picture.setBounds(0, 0, 150, 50);// picture�� ��ġ,ũ��
		c.add(picture);// picture�� ����Ʈ �ҿ� ����

		// �߰�
		pane = new JTabbedPane();
		pane.setBackground(new Color(178, 178, 178));// ���� ����
		pane.setBounds(0, 50, 1050, 500);// ������ ��ġ, ũ��

		combomenu = new MenuPanel(6, "comboname", "comboprice");
		combomenu.setPreferredSize(new Dimension(2000, 3000));// �޺� �޴� �г� ũ��
		pane.add("�޺�", new JScrollPane(combomenu));// �޺� �޴� �г��� ��ũ���гο� �ְ� ���ҿ� ����

		drinkmenu = new MenuPanel(5, "drinkname", "drinkprice");
		drinkmenu.setPreferredSize(new Dimension(2000, 3000));// ���� �޴� �г� ũ��
		pane.add("����", new JScrollPane(drinkmenu));// ���� �޴� �г��� ��ũ���гο� �������� ���ҿ� ����

		popcornmenu = new MenuPanel(3, "popcornname", "popcornprice");
		popcornmenu.setPreferredSize(new Dimension(2000, 3000));// ���� �޴� �г� ũ��
		pane.add("����", new JScrollPane(popcornmenu));// ���� �޴� �г��� ��ũ���гο� �������� ���ҿ� ����

		sidemenu = new MenuPanel(5, "sidename", "sideprice");
		sidemenu.setPreferredSize(new Dimension(1050, 700));// ���̵� �޴� �г� ũ��
		pane.add("���̵�", new JScrollPane(sidemenu));// ���̵� �޴� �г��� ��ũ���гο� �������� ���ҿ� ����
		c.add(pane);

		// �Ʒ�
		request = new Request();// Bottom ��ü ����
		request.setBounds(0, 550, 1050, 250);// bottompanel ��ġ,ũ��
		c.add(request);// ����

		// ���� ���̾�α�
		for (int i = 0; i < 6; i++) { // �޺�
			int j = i;
			combo[j] = new MenuOption(this, combomenu.name[j], combomenu.price[j]);// �޺� �� ���̾�α� ��ü
			combomenu.productbutton[j].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					combo[j].setVisible(true);
				}
			});
			combo[j].okbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (combo[j].count != 0) { // ������ 0�� �ƴϸ�
						String[] info = { combomenu.name[j], Integer.toString(combo[j].count),
								Integer.toString(Integer.parseInt(combomenu.price[j]) * combo[j].count) };
						request.table.addRow(info);// ���̺� ���� ���
						request.allprice = request.allprice
								+ Integer.parseInt(combomenu.price[j]) * combo[j].count;// ��ǰ �ݾ�*����
						request.paysum.setText(Integer.toString(request.allprice) + "��");// ��ǰ �ݾ�*����
						combo[j].count = 1;// ���� �ʱ�ȭ
						combo[j].cnt.setText(Integer.toString(combo[j].count));// �ʱ�ȭ�� ���� ǥ��
					}
					combo[j].setVisible(false);
				}
			});
		}

		for (int i = 0; i < 5; i++) { // ����
			int j = i;
			drink[j] = new MenuOption(drinkmenu.name[j], drinkmenu.price[j]);// ���� �� ���̾�α� ��ü ����
			drinkmenu.productbutton[j].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					drink[j].setVisible(true);
				}
			});
			drink[j].okbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (drink[j].count != 0) { // ������ 0�� �ƴϸ�
						String[] info = { drinkmenu.name[j], Integer.toString(drink[j].count),
								Integer.toString(Integer.parseInt(drinkmenu.price[j]) * drink[j].count) };
						request.table.addRow(info);// ���̺� ���� ���
						request.allprice = request.allprice
								+ Integer.parseInt(drinkmenu.price[j]) * drink[j].count;// �ݾ�*����
						request.paysum.setText(Integer.toString(request.allprice) + "��");// �ݾ�*���� ���
						drink[j].count = 1;// ���� �ʱ�ȭ
						drink[j].cnt.setText(Integer.toString(drink[j].count));// �ʱ�ȭ�� ���� ǥ��
					}
					drink[j].setVisible(false);
				}
			});
		}

		for (int i = 0; i < 3; i++) { // ����
			int j = i;
			popcorn[j] = new MenuOption(popcornmenu.name[j], popcornmenu.price[j]);// ���� �� ���̾�α� ��ü ����
			popcornmenu.productbutton[j].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					popcorn[j].setVisible(true);
				}
			});
			popcorn[j].okbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (popcorn[j].count != 0) { // ������ 0�� �ƴϸ�
						String[] info = { popcornmenu.name[j], Integer.toString(popcorn[j].count),
								Integer.toString(Integer.parseInt(popcornmenu.price[j]) * popcorn[j].count) };
						request.table.addRow(info);// ���̺� ���� ���
						request.allprice = request.allprice
								+ Integer.parseInt(popcornmenu.price[j]) * popcorn[j].count;// �ݾ�*����
						request.paysum.setText(Integer.toString(request.allprice) + "��");// �ݾ�*���� ���
						popcorn[j].count = 1;// ���� �ʱ�ȭ
						popcorn[j].cnt.setText(Integer.toString(popcorn[j].count));// �ʱ�ȭ�� ���� ǥ��
					}
					popcorn[j].setVisible(false);
				}
			});
		}
		for (int i = 0; i < 5; i++) { // ���̵�
			int j = i;
			side[j] = new MenuOption(sidemenu.name[j], sidemenu.price[j]);// ���̵� �� ���̾�α� ��ü ����
			sidemenu.productbutton[j].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					side[j].setVisible(true);
				}
			});
			side[j].okbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ������ 0�� �ƴ� ��
					if (side[j].count != 0) {
						String[] info = { sidemenu.name[j], Integer.toString(side[j].count),
								Integer.toString(Integer.parseInt(sidemenu.price[j]) * side[j].count) };
						request.table.addRow(info);// ���̺� ���� ���
						request.allprice = request.allprice
								+ Integer.parseInt(sidemenu.price[j]) * side[j].count;// �ݾ�*����
						request.paysum.setText(Integer.toString(request.allprice) + "��");// �ݾ�*���� ���
						side[j].count = 1;// ���� �ʱ�ȭ
						side[j].cnt.setText(Integer.toString(side[j].count));// �ʱ�ȭ�� ���� ǥ��
					}
					side[j].setVisible(false);// ���̾�α� �������ʰ� ����
				}
			});
		}

		receipt = new MenuOption(new JFrame(), "������");// ������ ���̾�α� ��ü
		nocheck_re = new MenuOption(new JFrame());// ��ǰ�� �������� �ʾ��� �� ���̾�α�
		payment = new MenuOption(); // ���� ���� ���̾�α�
		text = new MenuOption("����Ʈ"); // ����Ʈ ���� ���̾�α�

		request.menudelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ǰ�� �������� �ʾ��� ��
				if (request.cart.getSelectedRow() == -1) {
					return;
				}
				// ��ǰ�� �������� ��
				else {
					Object value = request.cart.getValueAt(request.cart.getSelectedRow(), 2);// ���̺��� ���õ� ����
																											// ���� �ҷ�����
					request.allprice = request.allprice - Integer.parseInt(value.toString());// �ҷ��� ������ �� �ݾ׿� ��
					request.paysum.setText(Integer.toString(request.allprice) + "��");// �� �ݾ��� �󺧿� �ֱ�
					request.table.removeRow(request.cart.getSelectedRow());// ���õ� �� �޴��� ����
				}
			}
		});

		request.order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ǰ�� �������� �ʾ��� ��
				if (request.allprice == 0) {
					nocheck_re.setVisible(true);
				} // ���õ� ���� ���� �� nocheck_re ǥ��
				// ��ǰ�� �������� ��
				else {
					receipt.setVisible(true);// receipt ���̾�α� ǥ��
					for (int i = 0; i < request.cart.getRowCount(); i++) {
						receipt.model_re.addRow(new Object[] { request.cart.getValueAt(i, 0),
								request.cart.getValueAt(i, 1), request.cart.getValueAt(i, 2) });// ��ٱ��� ���̺�
																											// ������ ������
																											// ���̺� �ű�
						receipt.paytext_re.setText(Integer.toString(request.allprice) + "��");// �������� �ѱݾ� ǥ��
						receipt.requesttext.setText(request.request_write.getText());// ��û���� �ؽ�Ʈ�� ������ �������� ������
					}
				}
			}
		});

		request.cancel.addActionListener(new ActionListener() { // �ֹ� ��ҹ�ư
			// ��ٱ��� ���̺�, �ݾ�, ��û���� �ʱ�ȭ
			public void actionPerformed(ActionEvent e) {
				request.table.setNumRows(0);
				request.allprice = 0;
				request.request_write.setText(null);
				request.paysum.setText(Integer.toString(request.allprice) + "��");
			}
		});

		request.choice_pay1.addActionListener(new ActionListener() { // ī�� ���� ��ư
			public void actionPerformed(ActionEvent e) {
				request.choice_pay1.setBackground(Color.GRAY); // �����ϸ� ���� GRAY�� �ٲ�
			}
		});

		request.choice_pay2.addActionListener(new ActionListener() { // ���� ���� ��ư
			public void actionPerformed(ActionEvent e) {
				payment.setVisible(true);
			}
		});

		text.savingbutton.addActionListener(new ActionListener() { // button2 ��ư
			public void actionPerformed(ActionEvent e) {
				// ����Ʈ �������� �������� �� �ʱ�ȭ�Ѵ�.
				request.table.setNumRows(0);
				receipt.model_re.setNumRows(0);
				request.allprice = 0;
				request.request_write.setText(null);
				receipt.requesttext.setText(null);
				request.paysum.setText(Integer.toString(request.allprice) + "��");
				receipt.paytext_re.setText(Integer.toString(request.allprice) + "��");
				text.phonetext.setText(null);
				receipt.setVisible(false);
				text.setVisible(false);
			}
		});

		receipt.okbutton_re.addActionListener(new ActionListener() { // ������ Ȯ�� ��ư�� ������
			public void actionPerformed(ActionEvent e) {
				text.setVisible(true); // ����Ʈ â ���̵���
			}
		});

		nocheck_re.button.addActionListener(new ActionListener() { // ��ǰ�� �������� �ʾ��� �� �ֹ� ��ư�� ������
			public void actionPerformed(ActionEvent e) {
				// ��û���� �ʱ�ȭ
				request.request_write.setText(null);
				receipt.requesttext.setText(null);
				nocheck_re.setVisible(false);
			}
		});

		payment.button1.addActionListener(new ActionListener() { // ���ݰ��� â�� �߰� Ȯ�� ��ư�� ������
			public void actionPerformed(ActionEvent e) {
				payment.setVisible(false); // â �ݱ�(�� ���̵���)
			}
		});

		setSize(1070, 900);// �������� ũ��
		setVisible(true);// ������ ���̰�
		setResizable(false);// ������ â�� �ִ�ȭ���� ���ϰ� ����
	}

	public static void main(String[] args) {
		new Main();
	}
}