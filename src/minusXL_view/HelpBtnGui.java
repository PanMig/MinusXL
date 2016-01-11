package minusXL_view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class HelpBtnGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpBtnGui frame = new HelpBtnGui();
					frame.setVisible(true);
					frame.setSize(700, 500);
					frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public HelpBtnGui() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JTextArea Area = new JTextArea();
		Area.setLineWrap(true);
		Area.setWrapStyleWord(true);

		BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/help.txt"),"windows-1253"));
		Area.read(br, null);
		br.close();
		Area.requestFocus();

		JScrollPane scroll = new JScrollPane(Area);
		contentPane.add(scroll, null);

	}

}
