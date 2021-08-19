package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controller.DataPack;
import model.Book;
import model.BookInOut;
import model.User;

public class Viewer {

	private JFrame frame;
	private JTextField userInfoInsertID;
	private JTextField userInfoInsertName;
	private JTextField userInfoInsertPhoneNum;
	private JTextField userInfoDeleteID;
	private JTable userInfoTable;
	private JTextField userInfoSelectID;
	private JTextField userInfoUpdateUserID;
	private JTextField userInfoUpdateUserName;
	private JTextField userInfoUpdatePhoneNum;
	private JTextField bookInfoSelectID;
	private JTable bookInfoTable;
	private JTextField bookInfoInsertID;
	private JTextField bookInfoInsertTitle;
	private JTextField bookInfoInsertISBN;
	private JTextField bookInfoUpdateBookID;
	private JTextField bookInfoUpdateBookTitle;
	private JTextField bookInfoUpdateBookISBN;
	private JTextField bookInfoDeleteID;
	private JTable bookInOutTable;
	private JTextField bookInOutSelectName;
	private JTextField bookInInsertUserID;
	private JTextField bookInInsertUserName;
	private JTextField bookInInsertBookID;
	private JTextField bookInInsertBookTitle;
	private JTextField bookOutInsertUserID;
	private JTextField bookOutInsertUserName;
	private JTextField bookOutInsertBookTitle;
	private JTextField bookOutInsertBookID;
	private JTextField userInfoSelectName;
	private JTextField userInfoSelectPhoneNum;
	private JTextField bookInfoSelectTitle;
	private JTextField bookInfoSelectISBN;
	private JLabel lblResultOutput;
	private DefaultTableModel bookInfoTableModel;
	private DefaultTableModel bookInOutTableModel;
	private DefaultTableModel userInfoTableModel;
	private JTextField bookInOutSelectTitle;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewer window = new Viewer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Viewer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("도서 대여 관리");
		frame.setBounds(100, 100, 650, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel bookOutInsert = new JPanel();
		bookOutInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookOutInsert.setBounds(0, 0, 634, 335);
		frame.getContentPane().add(bookOutInsert);
		bookOutInsert.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("  [도서 반출 등록]");
		lblNewLabel_12.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(0, 0, 434, 15);
		bookOutInsert.add(lblNewLabel_12);
		
		JLabel lblNewLabel_20_2 = new JLabel("사용자ID");
		lblNewLabel_20_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_20_2.setBounds(35, 32, 67, 15);
		bookOutInsert.add(lblNewLabel_20_2);
		
		bookOutInsertUserID = new JTextField();
		bookOutInsertUserID.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookOutInsertUserID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String queryString = "	SELECT	UserName"
									+ "	FROM 	UserInfo"
									+ "	WHERE	UserID = ?";
		
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, bookOutInsertUserID.getText()));
				
				User user = new User();
				user.selectData(queryString, bookOutInsertUserName, dataPack);
				Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
			}
		});
		
		bookOutInsertUserID.setColumns(10);
		bookOutInsertUserID.setBounds(109, 29, 85, 21);
		bookOutInsert.add(bookOutInsertUserID);
		
		bookOutInsertUserName = new JTextField();
		bookOutInsertUserName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookOutInsertUserName.setEditable(false);
		bookOutInsertUserName.setColumns(10);
		bookOutInsertUserName.setBounds(109, 60, 85, 21);
		bookOutInsert.add(bookOutInsertUserName);
		
		JLabel lblNewLabel_20_1_4 = new JLabel("사용자성명");
		lblNewLabel_20_1_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_20_1_4.setBounds(35, 63, 67, 15);
		bookOutInsert.add(lblNewLabel_20_1_4);
		
		JLabel lblNewLabel_20_1_1_1 = new JLabel("도서ID");
		lblNewLabel_20_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_20_1_1_1.setBounds(35, 94, 67, 15);
		bookOutInsert.add(lblNewLabel_20_1_1_1);
		
		JLabel lblNewLabel_20_1_2_1 = new JLabel("도서제목");
		lblNewLabel_20_1_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_20_1_2_1.setBounds(35, 125, 67, 15);
		bookOutInsert.add(lblNewLabel_20_1_2_1);
		
		JLabel lblNewLabel_20_1_3_1 = new JLabel("일자");
		lblNewLabel_20_1_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_20_1_3_1.setBounds(35, 156, 67, 15);
		bookOutInsert.add(lblNewLabel_20_1_3_1);
		
		bookOutInsertBookTitle = new JTextField();
		bookOutInsertBookTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookOutInsertBookTitle.setEditable(false);
		bookOutInsertBookTitle.setColumns(10);
		bookOutInsertBookTitle.setBounds(109, 122, 233, 21);
		bookOutInsert.add(bookOutInsertBookTitle);
		
		bookOutInsertBookID = new JTextField();
		bookOutInsertBookID.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookOutInsertBookID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String queryString = "	SELECT	BookTitle"
									+ "	FROM 	BookInfo"
									+ "	WHERE	BookID = ?";
				
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, bookOutInsertBookID.getText()));
				
				Book book = new Book();
				book.selectData(queryString, bookOutInsertBookTitle, dataPack);
				Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
			}
		});
		bookOutInsertBookID.setColumns(10);
		bookOutInsertBookID.setBounds(109, 91, 85, 21);
		bookOutInsert.add(bookOutInsertBookID);
		
		JDateChooser bookOutInsertDate = new JDateChooser();
		bookOutInsertDate.setBounds(109, 153, 97, 21);
		bookOutInsertDate.setDateFormatString("yyyy-MM-dd");
		bookOutInsert.add(bookOutInsertDate);
		

		JButton btnNewButton_7_4_1 = new JButton("반출등록");
		btnNewButton_7_4_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_7_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String queryString = "	INSERT INTO BookInOut"
									+ "	("
									+ "		UserID,"
									+ "		UserName,"
									+ " 	BookID,"
									+ " 	BookTitle,"
									+ " 	InOutType,"
									+ " 	InOutDate"
									+ " )"
									+ " VALUES"
									+ " ("
									+ "		?,"
									+ "		?,"
									+ "		?,"
									+ "		?,"
									+ "		?,"
									+ "		?"
									+ " );";
				
				Date chooserDate = bookOutInsertDate.getDate();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = chooserDate == null ? "" : dateFormat.format(chooserDate);
				
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, bookOutInsertUserID.getText()));
				dataPack.add(new DataPack(2, bookOutInsertUserName.getText()));
				dataPack.add(new DataPack(3, bookOutInsertBookID.getText()));
				dataPack.add(new DataPack(4, bookOutInsertBookTitle.getText()));
				dataPack.add(new DataPack(5, "O"));
				dataPack.add(new DataPack(6, date));
				
				BookInOut bookInOut = new BookInOut();
				
				if (Tool.openAlert("처리하시겠습니까?") == 0) {
					bookInOut.insertData(queryString, dataPack);
					Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
				}
			}
		});
		btnNewButton_7_4_1.setBounds(109, 180, 97, 23);
		bookOutInsert.add(btnNewButton_7_4_1);
		
		
		JPanel bookInInsert = new JPanel();
		bookInInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInInsert.setBounds(0, 0, 634, 335);
		frame.getContentPane().add(bookInInsert);
		bookInInsert.setLayout(null);
		
		bookInInsertUserID = new JTextField();
		bookInInsertUserID.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInInsertUserID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String queryString = "	SELECT	UserName"
									+ "	FROM 	UserInfo"
									+ "	WHERE	UserID = ?";
			
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, bookInInsertUserID.getText()));
				
				User user = new User();
				user.selectData(queryString, bookInInsertUserName, dataPack);
				Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
			}
		});
		bookInInsertUserID.setBounds(114, 25, 85, 21);
		bookInInsert.add(bookInInsertUserID);
		bookInInsertUserID.setColumns(10);
		
		bookInInsertUserName = new JTextField();
		bookInInsertUserName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInInsertUserName.setEditable(false);
		bookInInsertUserName.setColumns(10);
		bookInInsertUserName.setBounds(114, 56, 85, 21);
		bookInInsert.add(bookInInsertUserName);
		
		bookInInsertBookID = new JTextField();
		bookInInsertBookID.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInInsertBookID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String queryString = "	SELECT	BookTitle"
									+ "	FROM 	BookInfo"
									+ "	WHERE	BookID = ?";
					
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, bookInInsertBookID.getText()));
				
				Book book = new Book();
				book.selectData(queryString, bookInInsertBookTitle, dataPack);
				Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
			}
		});
		
		bookInInsertBookID.setColumns(10);
		bookInInsertBookID.setBounds(114, 87, 85, 21);
		bookInInsert.add(bookInInsertBookID);
		
		bookInInsertBookTitle = new JTextField();
		bookInInsertBookTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInInsertBookTitle.setEditable(false);
		bookInInsertBookTitle.setColumns(10);
		bookInInsertBookTitle.setBounds(114, 118, 233, 21);
		bookInInsert.add(bookInInsertBookTitle);
		
		JLabel lblNewLabel_20 = new JLabel("사용자ID");
		lblNewLabel_20.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_20.setBounds(40, 28, 67, 15);
		bookInInsert.add(lblNewLabel_20);
		
		JLabel lblNewLabel_20_1 = new JLabel("사용자성명");
		lblNewLabel_20_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_20_1.setBounds(40, 59, 67, 15);
		bookInInsert.add(lblNewLabel_20_1);
		
		JLabel lblNewLabel_20_1_1 = new JLabel("도서ID");
		lblNewLabel_20_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_20_1_1.setBounds(40, 90, 67, 15);
		bookInInsert.add(lblNewLabel_20_1_1);
		
		JLabel lblNewLabel_20_1_2 = new JLabel("도서제목");
		lblNewLabel_20_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_20_1_2.setBounds(40, 121, 67, 15);
		bookInInsert.add(lblNewLabel_20_1_2);
		
		JLabel lblNewLabel_20_1_3 = new JLabel("일자");
		lblNewLabel_20_1_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_20_1_3.setBounds(40, 152, 67, 15);
		bookInInsert.add(lblNewLabel_20_1_3);
		
		JDateChooser bookInInsertDate = new JDateChooser();
		bookInInsertDate.setBounds(114, 149, 97, 21);
		bookInInsertDate.setDateFormatString("yyyy-MM-dd");
		bookInInsert.add(bookInInsertDate);
		
		JPanel bookInOutSelect = new JPanel();
		bookInOutSelect.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInOutSelect.setBounds(0, 0, 634, 335);
		frame.getContentPane().add(bookInOutSelect);
		bookInOutSelect.setLayout(null);
		
		JLabel lblNewLabel_14 = new JLabel("  [도서 대여 이력 조회]");
		lblNewLabel_14.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_14.setBounds(0, 0, 634, 15);
		bookInOutSelect.add(lblNewLabel_14);
		
		JDateChooser bookInOutSelectFr = new JDateChooser();
		bookInOutSelectFr.setBounds(410, 25, 100, 21);
		bookInOutSelectFr.setDateFormatString("yyyy-MM-dd");
		bookInOutSelect.add(bookInOutSelectFr);
		
		JDateChooser bookInOutSelectTo = new JDateChooser();
		bookInOutSelectTo.setBounds(522, 25, 100, 21);
		bookInOutSelectTo.setDateFormatString("yyyy-MM-dd");
		bookInOutSelect.add(bookInOutSelectTo);
		
		JButton btnNewButton_5_1 = new JButton("조회");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String queryString = "	SELECT	UserID,"
									+ "			UserName,"
									+ "			BookID,"
									+ "			BookTitle,"
									+ "			InOutType,"
									+ "			InOutDate"
									+ "	FROM 	BookInOut"
									+ "	WHERE	UserName = CASE WHEN ? = '' THEN UserName ELSE ? END"
									+ "			AND BookTitle LIKE ?"
									+ "         AND InOutDate >= CASE WHEN ? = '' THEN InOutDate ELSE ? END"
									+ "         AND InOutDate <= CASE WHEN ? = '' THEN InOutDate ELSE ? END";

				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, bookInOutSelectName.getText()));
				dataPack.add(new DataPack(2, bookInOutSelectName.getText()));
				dataPack.add(new DataPack(3, "%" + bookInOutSelectTitle.getText() + "%"));
				
				Date chooserDateFr = bookInOutSelectFr.getDate();
				Date chooserDateTo = bookInOutSelectTo.getDate();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dateFr = chooserDateFr == null ? "" : dateFormat.format(chooserDateFr);
				String dateTo = chooserDateTo == null ? "" : dateFormat.format(chooserDateTo);
				dataPack.add(new DataPack(4, dateFr));
				dataPack.add(new DataPack(5, dateFr));
				dataPack.add(new DataPack(6, dateTo));
				dataPack.add(new DataPack(7, dateTo));
				User user = new User();
				user.selectData(queryString, bookInOutTableModel, dataPack);
				Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
			}
		});
		btnNewButton_5_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_5_1.setBounds(10, 302, 97, 23);
		bookInOutSelect.add(btnNewButton_5_1);
		
		JLabel lblNewLabel_19_1 = new JLabel("사용자성명");
		lblNewLabel_19_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_19_1.setBounds(10, 25, 68, 15);
		bookInOutSelect.add(lblNewLabel_19_1);
		
		bookInOutSelectName = new JTextField();
		bookInOutSelectName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInOutSelectName.setColumns(10);
		bookInOutSelectName.setBounds(79, 25, 74, 21);
		bookInOutSelect.add(bookInOutSelectName);
		
		JPanel bookInfoSelect = new JPanel();
		bookInfoSelect.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoSelect.setBounds(0, 0, 634, 335);
		frame.getContentPane().add(bookInfoSelect);
		bookInfoSelect.setLayout(null);
		
		JPanel userInfoSelect = new JPanel();
		userInfoSelect.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoSelect.setBounds(0, 0, 634, 335);
		frame.getContentPane().add(userInfoSelect);
		userInfoSelect.setLayout(null);
		
		JPanel userInfoUpdate = new JPanel();
		userInfoUpdate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoUpdate.setBounds(0, 0, 634, 335);
		frame.getContentPane().add(userInfoUpdate);
		userInfoUpdate.setLayout(null);
		
		JPanel bookInfoUpdate = new JPanel();
		bookInfoUpdate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoUpdate.setBounds(0, 0, 634, 335);
		frame.getContentPane().add(bookInfoUpdate);
		bookInfoUpdate.setLayout(null);
		
		JPanel bookInfoDelete = new JPanel();
		bookInfoDelete.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoDelete.setBounds(0, 0, 634, 335);
		frame.getContentPane().add(bookInfoDelete);
		bookInfoDelete.setLayout(null);
		
		JPanel userInfoDelete = new JPanel();
		userInfoDelete.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoDelete.setBounds(0, 0, 634, 335);
		frame.getContentPane().add(userInfoDelete);
		userInfoDelete.setLayout(null);
		
		JPanel bookInfoInsert = new JPanel();
		bookInfoInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoInsert.setBounds(0, 0, 634, 335);
		frame.getContentPane().add(bookInfoInsert);
		bookInfoInsert.setLayout(null);
		
		JPanel userInfoInsert = new JPanel();
		userInfoInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoInsert.setBounds(0, 0, 634, 335);
		frame.getContentPane().add(userInfoInsert);
		userInfoInsert.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mainPanel.setBounds(0, 0, 634, 335);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("  [도서 정보 조회]");
		lblNewLabel_11.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(0, 0, 634, 15);
		bookInfoSelect.add(lblNewLabel_11);
		
		String[] userInfoTableColName = {"사용자ID","사용자성명","사용자전화번호"};
		userInfoTableModel = new DefaultTableModel(userInfoTableColName, 0);
		
		userInfoTable = new JTable(userInfoTableModel);
		userInfoTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoTable.setBounds(10, 50, 410, 155);
		
		JScrollPane userInfoScrollPane = new JScrollPane(userInfoTable);
		userInfoScrollPane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoScrollPane.setBounds(10,50,612,242);
		userInfoSelect.add(userInfoScrollPane);
		
		String[] bookInfoTableColName = {"도서ID","도서제목","도서ISBN"};
		bookInfoTableModel = new DefaultTableModel(bookInfoTableColName, 0);
		
		bookInfoTable = new JTable(bookInfoTableModel);
		bookInfoTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoTable.setBounds(10, 50, 410, 155);
		
		JScrollPane bookInfoScrollPane = new JScrollPane(bookInfoTable);
		bookInfoScrollPane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoScrollPane.setBounds(10,50,612,242);
		bookInfoSelect.add(bookInfoScrollPane);

		String[] bookInOutTableColName = {"사용자ID","사용자성명","도서ID","도서제목","상태","일자"};
		bookInOutTableModel = new DefaultTableModel(bookInOutTableColName, 0);
		
		bookInOutTable = new JTable(bookInOutTableModel);
		bookInOutTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInOutTable.setBounds(10, 50, 410, 155);
		
		JScrollPane bookInOutScrollPane = new JScrollPane(bookInOutTable);
		bookInOutScrollPane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInOutScrollPane.setBounds(10,50,612,242);
		bookInOutSelect.add(bookInOutScrollPane);
		
		JLabel lblNewLabel_21 = new JLabel("~");
		lblNewLabel_21.setBounds(511, 25, 15, 17);
		bookInOutSelect.add(lblNewLabel_21);
		
		bookInOutSelectTitle = new JTextField();
		bookInOutSelectTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInOutSelectTitle.setColumns(10);
		bookInOutSelectTitle.setBounds(210, 25, 163, 21);
		bookInOutSelect.add(bookInOutSelectTitle);
		
		JLabel lblNewLabel_19_1_1 = new JLabel("책제목");
		lblNewLabel_19_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_19_1_1.setBounds(165, 25, 40, 15);
		bookInOutSelect.add(lblNewLabel_19_1_1);
		
		JLabel lblNewLabel_19_1_1_1 = new JLabel("기간");
		lblNewLabel_19_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_19_1_1_1.setBounds(380, 25, 33, 15);
		bookInOutSelect.add(lblNewLabel_19_1_1_1);
		
		bookInfoSelectID = new JTextField();
		bookInfoSelectID.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoSelectID.setBounds(41, 25, 45, 21);
		bookInfoSelect.add(bookInfoSelectID);
		bookInfoSelectID.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("ID");
		lblNewLabel_19.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_19.setBounds(10, 25, 29, 15);
		bookInfoSelect.add(lblNewLabel_19);
		
		JLabel lblNewLabel_19_2 = new JLabel("책 제목");
		lblNewLabel_19_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_19_2.setBounds(98, 25, 69, 15);
		bookInfoSelect.add(lblNewLabel_19_2);
		
		bookInfoSelectTitle = new JTextField();
		bookInfoSelectTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoSelectTitle.setColumns(10);
		bookInfoSelectTitle.setBounds(168, 25, 97, 21);
		bookInfoSelect.add(bookInfoSelectTitle);
		
		JLabel lblNewLabel_19_3 = new JLabel("ISBN");
		lblNewLabel_19_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_19_3.setBounds(272, 25, 69, 15);
		bookInfoSelect.add(lblNewLabel_19_3);
		
		bookInfoSelectISBN = new JTextField();
		bookInfoSelectISBN.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoSelectISBN.setColumns(10);
		bookInfoSelectISBN.setBounds(342, 25, 153, 21);
		bookInfoSelect.add(bookInfoSelectISBN);
		
		JButton btnNewButton_5 = new JButton("조회");
		btnNewButton_5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String queryString = "	SELECT	BookID,"
									+ "			BookTitle,"
									+ "			BookISBN "
									+ "	FROM 	BookInfo"
									+ "	WHERE	BookID = CASE WHEN ? = '' THEN BookID ELSE ? END"
									+ " 		AND BookTitle LIKE ?"
									+ " 		AND BookISBN LIKE ?";
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, bookInfoSelectID.getText()));
				dataPack.add(new DataPack(2, bookInfoSelectID.getText()));
				dataPack.add(new DataPack(3, "%" + bookInfoSelectTitle.getText() + "%"));
				dataPack.add(new DataPack(4, "%" + bookInfoSelectISBN.getText() + "%"));
				Book book = new Book();
				book.selectData(queryString, bookInfoTableModel, dataPack);
				Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
			}
		});
		btnNewButton_5.setBounds(10, 302, 97, 23);
		bookInfoSelect.add(btnNewButton_5);
		
		
		JLabel lblNewLabel_13 = new JLabel("  [도서 반입 등록]");
		lblNewLabel_13.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(0, 0, 434, 15);
		bookInInsert.add(lblNewLabel_13);
		
		JButton btnNewButton_7_4 = new JButton("반입등록");
		btnNewButton_7_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_7_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String queryString = "	INSERT INTO BookInOut"
									+ "	("
									+ "		UserID,"
									+ "		UserName,"
									+ " 	BookID,"
									+ " 	BookTitle,"
									+ " 	InOutType,"
									+ " 	InOutDate"
									+ " )"
									+ " VALUES"
									+ " ("
									+ "		?,"
									+ "		?,"
									+ "		?,"
									+ "		?,"
									+ "		?,"
									+ "		?"
									+ " );";
				
				Date chooserDate = bookInInsertDate.getDate();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = chooserDate == null ? "" : dateFormat.format(chooserDate);
				
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, bookInInsertUserID.getText()));
				dataPack.add(new DataPack(2, bookInInsertUserName.getText()));
				dataPack.add(new DataPack(3, bookInInsertBookID.getText()));
				dataPack.add(new DataPack(4, bookInInsertBookTitle.getText()));
				dataPack.add(new DataPack(5, "I"));
				dataPack.add(new DataPack(6, date));
				
				BookInOut bookInOut = new BookInOut();
				
				if (Tool.openAlert("처리하시겠습니까?") == 0) {
					bookInOut.insertData(queryString, dataPack);
					Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
				}
			}
		});
		btnNewButton_7_4.setBounds(114, 176, 97, 23);
		bookInInsert.add(btnNewButton_7_4);

		
		lblResultOutput = new JLabel("");
		lblResultOutput.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblResultOutput.setBounds(0, 333, 634, 25);
		frame.getContentPane().add(lblResultOutput);
						
		JLabel lblNewLabel_6 = new JLabel("  [사용자 정보 조회]");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(0, 0, 634, 15);
		userInfoSelect.add(lblNewLabel_6);
		
		userInfoSelectID = new JTextField();
		userInfoSelectID.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoSelectID.setBounds(41, 25, 45, 21);
		userInfoSelect.add(userInfoSelectID);
		userInfoSelectID.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("ID");
		lblNewLabel_15.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_15.setBounds(10, 25, 29, 15);
		userInfoSelect.add(lblNewLabel_15);
		
		JButton btnNewButton = new JButton("조회");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String queryString = "	SELECT	UserID,"
									+ "			UserName,"
									+ "			UserPhoneNum "
									+ "	FROM 	UserInfo"
									+ "	WHERE	UserID = CASE WHEN ? = '' THEN UserID ELSE ? END"
									+ " 		AND UserName LIKE ?"
									+ " 		AND UserPhoneNum LIKE ?";
				
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, userInfoSelectID.getText()));
				dataPack.add(new DataPack(2, userInfoSelectID.getText()));
				dataPack.add(new DataPack(3, "%" + userInfoSelectName.getText() + "%"));
				dataPack.add(new DataPack(4, "%" + userInfoSelectPhoneNum.getText() + "%"));
				
				User user = new User();
				user.selectData(queryString, userInfoTableModel, dataPack);
				Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
			}
		});
		btnNewButton.setBounds(10, 302, 97, 23);
		userInfoSelect.add(btnNewButton);
		
		JLabel lblNewLabel_15_1 = new JLabel("사용자 성명");
		lblNewLabel_15_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_15_1.setBounds(98, 25, 69, 15);
		userInfoSelect.add(lblNewLabel_15_1);
		
		userInfoSelectName = new JTextField();
		userInfoSelectName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoSelectName.setColumns(10);
		userInfoSelectName.setBounds(168, 25, 97, 21);
		userInfoSelect.add(userInfoSelectName);
		
		JLabel lblNewLabel_15_1_1 = new JLabel("전화번호");
		lblNewLabel_15_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_15_1_1.setBounds(272, 25, 69, 15);
		userInfoSelect.add(lblNewLabel_15_1_1);
		
		userInfoSelectPhoneNum = new JTextField();
		userInfoSelectPhoneNum.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoSelectPhoneNum.setColumns(10);
		userInfoSelectPhoneNum.setBounds(342, 25, 153, 21);
		userInfoSelect.add(userInfoSelectPhoneNum);
				
		JLabel lblNewLabel_5 = new JLabel("  [사용자 정보 수정]");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(0, 0, 634, 15);
		userInfoUpdate.add(lblNewLabel_5);
		
		userInfoUpdateUserID = new JTextField();
		userInfoUpdateUserID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String queryString = "	SELECT	UserName,"
									+ " 		UserPhoneNUm"		
									+ "	FROM 	UserInfo"
									+ "	WHERE	UserID = ?";
			
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, userInfoUpdateUserID.getText()));
				
				User user = new User();
				user.selectData(queryString, userInfoUpdateUserName, dataPack, 1);
				user.selectData(queryString, userInfoUpdatePhoneNum, dataPack, 2);
				Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
			}
		});
		
		userInfoUpdateUserID.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoUpdateUserID.setBounds(84, 40, 116, 21);
		userInfoUpdate.add(userInfoUpdateUserID);
		userInfoUpdateUserID.setColumns(10);
		
		userInfoUpdateUserName = new JTextField();
		userInfoUpdateUserName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoUpdateUserName.setBounds(84, 71, 116, 21);
		userInfoUpdate.add(userInfoUpdateUserName);
		userInfoUpdateUserName.setColumns(10);
		
		userInfoUpdatePhoneNum = new JTextField();
		userInfoUpdatePhoneNum.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoUpdatePhoneNum.setBounds(84, 101, 116, 21);
		userInfoUpdate.add(userInfoUpdatePhoneNum);
		userInfoUpdatePhoneNum.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("ID");
		lblNewLabel_16.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_16.setBounds(15, 43, 57, 15);
		userInfoUpdate.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("이름");
		lblNewLabel_17.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_17.setBounds(15, 74, 57, 15);
		userInfoUpdate.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("전화번호");
		lblNewLabel_18.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_18.setBounds(15, 104, 57, 15);
		userInfoUpdate.add(lblNewLabel_18);
		
		JButton btnNewButton_4 = new JButton("수정");
		btnNewButton_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String queryString = "	UPDATE	UserInfo "
									+ " SET 	UserName = ?,"
									+ "			UserPhoneNum = ?"
									+ "	WHERE	UserID = ?;";
		
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, userInfoUpdateUserName.getText()));
				dataPack.add(new DataPack(2, userInfoUpdatePhoneNum.getText()));
				dataPack.add(new DataPack(3, userInfoUpdateUserID.getText()));
				
				User user = new User();
				
				if (Tool.openAlert("처리하시겠습니까?") == 0) {
					user.updateData(queryString, dataPack);
					Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
				}
			}
		});
		btnNewButton_4.setBounds(15, 149, 97, 23);
		userInfoUpdate.add(btnNewButton_4);
		
		JLabel lblNewLabel_9 = new JLabel("  [도서 정보 수정]");
		lblNewLabel_9.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(0, 0, 434, 15);
		bookInfoUpdate.add(lblNewLabel_9);
		
		bookInfoUpdateBookID = new JTextField();
		bookInfoUpdateBookID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String queryString = "	SELECT	BookTitle,"
									+ " 		BookISBN"		
									+ "	FROM 	BookInfo"
									+ "	WHERE	BookID = ?";

				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, bookInfoUpdateBookID.getText()));
				
				User user = new User();
				user.selectData(queryString, bookInfoUpdateBookTitle, dataPack, 1);
				user.selectData(queryString, bookInfoUpdateBookISBN, dataPack, 2);
				Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
			}
		});
		bookInfoUpdateBookID.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoUpdateBookID.setColumns(10);
		bookInfoUpdateBookID.setBounds(80, 39, 116, 21);
		bookInfoUpdate.add(bookInfoUpdateBookID);
		
		bookInfoUpdateBookTitle = new JTextField();
		bookInfoUpdateBookTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoUpdateBookTitle.setColumns(10);
		bookInfoUpdateBookTitle.setBounds(80, 68, 116, 21);
		bookInfoUpdate.add(bookInfoUpdateBookTitle);
		
		bookInfoUpdateBookISBN = new JTextField();
		bookInfoUpdateBookISBN.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoUpdateBookISBN.setColumns(10);
		bookInfoUpdateBookISBN.setBounds(80, 99, 116, 21);
		bookInfoUpdate.add(bookInfoUpdateBookISBN);
		
		JButton btnNewButton_2_1_1 = new JButton("수정");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String queryString = "	UPDATE	BookInfo "
									+ " SET 	BookTitle = ?,"
									+ "			BookISBN = ?"
									+ "	WHERE	BookID = ?;";
			
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, bookInfoUpdateBookTitle.getText()));
				dataPack.add(new DataPack(2, bookInfoUpdateBookISBN.getText()));
				dataPack.add(new DataPack(3, bookInfoUpdateBookID.getText()));
				
				Book book = new Book();
				
				if (Tool.openAlert("처리하시겠습니까?") == 0) {
					book.updateData(queryString, dataPack);
					Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
				}
			}
		});
		btnNewButton_2_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_2_1_1.setBounds(38, 143, 97, 23);
		bookInfoUpdate.add(btnNewButton_2_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("ISBN");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_4_1_1.setBounds(24, 102, 57, 15);
		bookInfoUpdate.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("제목");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_1_1.setBounds(24, 71, 57, 15);
		bookInfoUpdate.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("ID");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2_2_1.setBounds(24, 42, 57, 15);
		bookInfoUpdate.add(lblNewLabel_2_2_1);
				
		JLabel lblNewLabel_10 = new JLabel("  [도서 정보 삭제]");
		lblNewLabel_10.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(0, 0, 434, 15);
		bookInfoDelete.add(lblNewLabel_10);
		
		bookInfoDeleteID = new JTextField();
		bookInfoDeleteID.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoDeleteID.setColumns(10);
		bookInfoDeleteID.setBounds(66, 26, 116, 21);
		bookInfoDelete.add(bookInfoDeleteID);
		
		JButton btnNewButton_3_1 = new JButton("삭제");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String queryString = "	DELETE "
									+ " FROM 	BookInfo"
									+ "	WHERE	BookID = ?;";
				
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, bookInfoDeleteID.getText()));
				
				Book book = new Book();
				
				if (Tool.openAlert("처리하시겠습니까?") == 0) {
					book.deleteData(queryString, dataPack);
					Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
				}
			}
		});		
		btnNewButton_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_3_1.setBounds(20, 57, 97, 23);
		bookInfoDelete.add(btnNewButton_3_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("ID");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2_1_1.setBounds(10, 29, 57, 15);
		bookInfoDelete.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel = new JLabel("  [사용자 정보 삭제]");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(0, 0, 434, 15);
		userInfoDelete.add(lblNewLabel);
		
		userInfoDeleteID = new JTextField();
		userInfoDeleteID.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoDeleteID.setColumns(10);
		userInfoDeleteID.setBounds(59, 25, 116, 21);
		userInfoDelete.add(userInfoDeleteID);
		
		JLabel lblNewLabel_2_1 = new JLabel("ID");
		lblNewLabel_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(3, 28, 57, 15);
		userInfoDelete.add(lblNewLabel_2_1);
		
		JButton btnNewButton_3 = new JButton("삭제");
		btnNewButton_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String queryString = "	DELETE "
									+ " FROM 	UserInfo"
									+ "	WHERE	UserID = ?;";
				
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, userInfoDeleteID.getText()));
				
				User user = new User();
				
				if (Tool.openAlert("처리하시겠습니까?") == 0) {
					user.deleteData(queryString, dataPack);
					Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
				}
			}
		});
		btnNewButton_3.setBounds(13, 56, 97, 23);
		userInfoDelete.add(btnNewButton_3);
				
		JLabel lblNewLabel_8 = new JLabel("  [도서 정보 등록]");
		lblNewLabel_8.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(0, 0, 434, 15);
		bookInfoInsert.add(lblNewLabel_8);
		
		bookInfoInsertID = new JTextField();
		bookInfoInsertID.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoInsertID.setColumns(10);
		bookInfoInsertID.setBounds(66, 32, 116, 21);
		bookInfoInsert.add(bookInfoInsertID);
		
		JLabel lblNewLabel_2_2 = new JLabel("ID");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(10, 35, 57, 15);
		bookInfoInsert.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("제목");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(10, 64, 57, 15);
		bookInfoInsert.add(lblNewLabel_3_1);
		
		bookInfoInsertTitle = new JTextField();
		bookInfoInsertTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoInsertTitle.setColumns(10);
		bookInfoInsertTitle.setBounds(66, 61, 116, 21);
		bookInfoInsert.add(bookInfoInsertTitle);
		
		bookInfoInsertISBN = new JTextField();
		bookInfoInsertISBN.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bookInfoInsertISBN.setColumns(10);
		bookInfoInsertISBN.setBounds(66, 92, 116, 21);
		bookInfoInsert.add(bookInfoInsertISBN);
		
		JLabel lblNewLabel_4_1 = new JLabel("ISBN");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(10, 95, 57, 15);
		bookInfoInsert.add(lblNewLabel_4_1);
		
		JButton btnNewButton_2_1 = new JButton("등록");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String queryString = "	INSERT INTO BookInfo"
									+ "	("
									+ "		BookID,"
									+ "		BookTitle,"
									+ " 	BookISBN"
									+ " )"
									+ " VALUES"
									+ " ("
									+ "		?,"
									+ "		?,"
									+ "		?"
									+ " );";
				
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, bookInfoInsertID.getText()));
				dataPack.add(new DataPack(2, bookInfoInsertTitle.getText()));
				dataPack.add(new DataPack(3, bookInfoInsertISBN.getText()));
				
				Book book = new Book();
				
				if (Tool.openAlert("처리하시겠습니까?") == 0) {
					book.insertData(queryString, dataPack);
					Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
				}
			}
		});
		btnNewButton_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_2_1.setBounds(24, 136, 97, 23);
		bookInfoInsert.add(btnNewButton_2_1);
				
		JLabel lblNewLabel_1 = new JLabel("  [사용자 정보 등록]");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(0, 0, 434, 15);
		userInfoInsert.add(lblNewLabel_1);
		
		userInfoInsertID = new JTextField();
		userInfoInsertID.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoInsertID.setBounds(68, 40, 116, 21);
		userInfoInsert.add(userInfoInsertID);
		userInfoInsertID.setColumns(10);
		
		userInfoInsertName = new JTextField();
		userInfoInsertName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoInsertName.setBounds(68, 69, 116, 21);
		userInfoInsert.add(userInfoInsertName);
		userInfoInsertName.setColumns(10);
		
		userInfoInsertPhoneNum = new JTextField();
		userInfoInsertPhoneNum.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userInfoInsertPhoneNum.setBounds(68, 100, 116, 21);
		userInfoInsert.add(userInfoInsertPhoneNum);
		userInfoInsertPhoneNum.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 43, 57, 15);
		userInfoInsert.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 72, 57, 15);
		userInfoInsert.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("전화번호");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(12, 103, 57, 15);
		userInfoInsert.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("등록");
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String queryString = "	INSERT INTO UserInfo"
									+ "	("
									+ "		UserID,"
									+ "		UserName,"
									+ " 	UserPhoneNum"
									+ " )"
									+ " VALUES"
									+ " ("
									+ "		?,"
									+ "		?,"
									+ "		?"
									+ " );";
						
				ArrayList<DataPack> dataPack = new ArrayList<DataPack>();
				dataPack.add(new DataPack(1, userInfoInsertID.getText()));
				dataPack.add(new DataPack(2, userInfoInsertName.getText()));
				dataPack.add(new DataPack(3, userInfoInsertPhoneNum.getText()));
				
				User user = new User();
				
				if (Tool.openAlert("처리하시겠습니까?") == 0) {
					user.insertData(queryString, dataPack);
					Tool.setText(lblResultOutput, "처리 완료", 3, Tool.messageType.SUCCESS);
				}
			}
		});
		btnNewButton_2.setBounds(26, 144, 97, 23);
		userInfoInsert.add(btnNewButton_2);
		
		JLabel lblNewLabel_7 = new JLabel("도서 대여 관리 프로그램");
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(0, 0, 634, 335);
		mainPanel.add(lblNewLabel_7);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("파일");
		mnNewMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("종료");
		mntmNewMenuItem.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("홈");
		mntmNewMenuItem_12.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				//사용자 정보 관리 패널 세팅
				userInfoInsert.setVisible(false);
				userInfoDelete.setVisible(false);
				userInfoSelect.setVisible(false);
				userInfoUpdate.setVisible(false);
				//도서 정보 관리 패널 세팅
				bookInfoInsert.setVisible(false);
				bookInfoDelete.setVisible(false);
				bookInfoSelect.setVisible(false);
				bookInfoUpdate.setVisible(false);
				//도서 대여 관리 패널 세팅
				bookInInsert.setVisible(false);
				bookOutInsert.setVisible(false);
				bookInOutSelect.setVisible(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_12);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("사용자 정보 관리");
		mnNewMenu_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("사용자 정보 등록");
		mntmNewMenuItem_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				//사용자 정보 관리 패널 세팅
				userInfoInsert.setVisible(true);
				userInfoDelete.setVisible(false);
				userInfoSelect.setVisible(false);
				userInfoUpdate.setVisible(false);
				//도서 정보 관리 패널 세팅
				bookInfoInsert.setVisible(false);
				bookInfoDelete.setVisible(false);
				bookInfoSelect.setVisible(false);
				bookInfoUpdate.setVisible(false);
				//도서 대여 관리 패널 세팅
				bookInInsert.setVisible(false);
				bookOutInsert.setVisible(false);
				bookInOutSelect.setVisible(false);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("사용자 정보 삭제");
		mntmNewMenuItem_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				//사용자 정보 관리 패널 세팅
				userInfoInsert.setVisible(false);
				userInfoDelete.setVisible(true);
				userInfoSelect.setVisible(false);
				userInfoUpdate.setVisible(false);
				//도서 정보 관리 패널 세팅
				bookInfoInsert.setVisible(false);
				bookInfoDelete.setVisible(false);
				bookInfoSelect.setVisible(false);
				bookInfoUpdate.setVisible(false);
				//도서 대여 관리 패널 세팅
				bookInInsert.setVisible(false);
				bookOutInsert.setVisible(false);
				bookInOutSelect.setVisible(false);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("사용자 정보 수정");
		mntmNewMenuItem_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				//사용자 정보 관리 패널 세팅
				userInfoInsert.setVisible(false);
				userInfoDelete.setVisible(false);
				userInfoSelect.setVisible(false);
				userInfoUpdate.setVisible(true);
				//도서 정보 관리 패널 세팅
				bookInfoInsert.setVisible(false);
				bookInfoDelete.setVisible(false);
				bookInfoSelect.setVisible(false);
				bookInfoUpdate.setVisible(false);
				//도서 대여 관리 패널 세팅
				bookInInsert.setVisible(false);
				bookOutInsert.setVisible(false);
				bookInOutSelect.setVisible(false);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("사용자 정보 조회");
		mntmNewMenuItem_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				//사용자 정보 관리 패널 세팅
				userInfoInsert.setVisible(false);
				userInfoDelete.setVisible(false);
				userInfoSelect.setVisible(true);
				userInfoUpdate.setVisible(false);
				//도서 정보 관리 패널 세팅
				bookInfoInsert.setVisible(false);
				bookInfoDelete.setVisible(false);
				bookInfoSelect.setVisible(false);
				bookInfoUpdate.setVisible(false);
				//도서 대여 관리 패널 세팅
				bookInInsert.setVisible(false);
				bookOutInsert.setVisible(false);
				bookInOutSelect.setVisible(false);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("도서 정보 관리");
		mnNewMenu_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("도서 정보 등록");
		mntmNewMenuItem_6.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				//사용자 정보 관리 패널 세팅
				userInfoInsert.setVisible(false);
				userInfoDelete.setVisible(false);
				userInfoSelect.setVisible(false);
				userInfoUpdate.setVisible(false);
				//도서 정보 관리 패널 세팅
				bookInfoInsert.setVisible(true);
				bookInfoDelete.setVisible(false);
				bookInfoSelect.setVisible(false);
				bookInfoUpdate.setVisible(false);
				//도서 대여 관리 패널 세팅
				bookInInsert.setVisible(false);
				bookOutInsert.setVisible(false);
				bookInOutSelect.setVisible(false);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("도서 정보 삭제");
		mntmNewMenuItem_7.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				//사용자 정보 관리 패널 세팅
				userInfoInsert.setVisible(false);
				userInfoDelete.setVisible(false);
				userInfoSelect.setVisible(false);
				userInfoUpdate.setVisible(false);
				//도서 정보 관리 패널 세팅
				bookInfoInsert.setVisible(false);
				bookInfoDelete.setVisible(true);
				bookInfoSelect.setVisible(false);
				bookInfoUpdate.setVisible(false);
				//도서 대여 관리 패널 세팅
				bookInInsert.setVisible(false);
				bookOutInsert.setVisible(false);
				bookInOutSelect.setVisible(false);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("도서 정보 수정");
		mntmNewMenuItem_5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				//사용자 정보 관리 패널 세팅
				userInfoInsert.setVisible(false);
				userInfoDelete.setVisible(false);
				userInfoSelect.setVisible(false);
				userInfoUpdate.setVisible(false);
				//도서 정보 관리 패널 세팅
				bookInfoInsert.setVisible(false);
				bookInfoDelete.setVisible(false);
				bookInfoSelect.setVisible(false);
				bookInfoUpdate.setVisible(true);
				//도서 대여 관리 패널 세팅
				bookInInsert.setVisible(false);
				bookOutInsert.setVisible(false);
				bookInOutSelect.setVisible(false);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("도서 정보 조회");
		mntmNewMenuItem_8.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				//사용자 정보 관리 패널 세팅
				userInfoInsert.setVisible(false);
				userInfoDelete.setVisible(false);
				userInfoSelect.setVisible(false);
				userInfoUpdate.setVisible(false);
				//도서 정보 관리 패널 세팅
				bookInfoInsert.setVisible(false);
				bookInfoDelete.setVisible(false);
				bookInfoSelect.setVisible(true);
				bookInfoUpdate.setVisible(false);
				//도서 대여 관리 패널 세팅
				bookInInsert.setVisible(false);
				bookOutInsert.setVisible(false);
				bookInOutSelect.setVisible(false);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_3 = new JMenu("도서 대여 관리");
		mnNewMenu_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("도서 반출 등록");
		mntmNewMenuItem_9.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				//사용자 정보 관리 패널 세팅
				userInfoInsert.setVisible(false);
				userInfoDelete.setVisible(false);
				userInfoSelect.setVisible(false);
				userInfoUpdate.setVisible(false);
				//도서 정보 관리 패널 세팅
				bookInfoInsert.setVisible(false);
				bookInfoDelete.setVisible(false);
				bookInfoSelect.setVisible(false);
				bookInfoUpdate.setVisible(false);
				//도서 대여 관리 패널 세팅
				bookInInsert.setVisible(false);
				bookOutInsert.setVisible(true);
				bookInOutSelect.setVisible(false);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("도서 반입 등록");
		mntmNewMenuItem_10.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				//사용자 정보 관리 패널 세팅
				userInfoInsert.setVisible(false);
				userInfoDelete.setVisible(false);
				userInfoSelect.setVisible(false);
				userInfoUpdate.setVisible(false);
				//도서 정보 관리 패널 세팅
				bookInfoInsert.setVisible(false);
				bookInfoDelete.setVisible(false);
				bookInfoSelect.setVisible(false);
				bookInfoUpdate.setVisible(false);
				//도서 대여 관리 패널 세팅
				bookInInsert.setVisible(true);
				bookOutInsert.setVisible(false);
				bookInOutSelect.setVisible(false);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("도서 대여 이력 조회");
		mntmNewMenuItem_11.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				//사용자 정보 관리 패널 세팅
				userInfoInsert.setVisible(false);
				userInfoDelete.setVisible(false);
				userInfoSelect.setVisible(false);
				userInfoUpdate.setVisible(false);
				//도서 정보 관리 패널 세팅
				bookInfoInsert.setVisible(false);
				bookInfoDelete.setVisible(false);
				bookInfoSelect.setVisible(false);
				bookInfoUpdate.setVisible(false);
				//도서 대여 관리 패널 세팅
				bookInInsert.setVisible(false);
				bookOutInsert.setVisible(false);
				bookInOutSelect.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_4 = new JMenu("도움말");
		mnNewMenu_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_4);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				mainPanel.setVisible(true);
				//사용자 정보 관리 패널 세팅
				userInfoInsert.setVisible(false);
				userInfoDelete.setVisible(false);
				userInfoSelect.setVisible(false);
				userInfoUpdate.setVisible(false);
				//도서 정보 관리 패널 세팅
				bookInfoInsert.setVisible(false);
				bookInfoDelete.setVisible(false);
				bookInfoSelect.setVisible(false);
				bookInfoUpdate.setVisible(false);
				//도서 대여 관리 패널 세팅
				bookInInsert.setVisible(false);
				bookOutInsert.setVisible(false);
				bookInOutSelect.setVisible(false);
			}
		});
	}
}
