package minusXL_view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SaveBtnGui extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMyworkbook;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SaveBtnGui dialog = new SaveBtnGui();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SaveBtnGui() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{122, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblEnterFilename = new JLabel("Enter Filename :");
			lblEnterFilename.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEnterFilename.setForeground(Color.BLACK);
			GridBagConstraints gbc_lblEnterFilename = new GridBagConstraints();
			gbc_lblEnterFilename.insets = new Insets(0, 0, 5, 5);
			gbc_lblEnterFilename.anchor = GridBagConstraints.EAST;
			gbc_lblEnterFilename.gridx = 0;
			gbc_lblEnterFilename.gridy = 3;
			contentPanel.add(lblEnterFilename, gbc_lblEnterFilename);
		}
		{
			txtMyworkbook = new JTextField();
			txtMyworkbook.setHorizontalAlignment(SwingConstants.CENTER);
			txtMyworkbook.setText("MyWorkbook1");
			GridBagConstraints gbc_txtMyworkbook = new GridBagConstraints();
			gbc_txtMyworkbook.insets = new Insets(0, 0, 5, 0);
			gbc_txtMyworkbook.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtMyworkbook.gridx = 1;
			gbc_txtMyworkbook.gridy = 3;
			contentPanel.add(txtMyworkbook, gbc_txtMyworkbook);
			txtMyworkbook.setColumns(10);
		}
		{
			JLabel lblPressOkTo = new JLabel("Press OK to save or cancel to abort");
			lblPressOkTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GridBagConstraints gbc_lblPressOkTo = new GridBagConstraints();
			gbc_lblPressOkTo.gridx = 1;
			gbc_lblPressOkTo.gridy = 6;
			contentPanel.add(lblPressOkTo, gbc_lblPressOkTo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						JOptionPane.showMessageDialog(null,"Save completed");
					}
				});
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
