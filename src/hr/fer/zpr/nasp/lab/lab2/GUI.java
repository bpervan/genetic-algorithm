package hr.fer.zpr.nasp.lab.lab2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 * 
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSelectionAlgo = new JLabel("Algoritam odabira");
		lblSelectionAlgo.setBounds(10, 10, 140, 14);
		frame.getContentPane().add(lblSelectionAlgo);
		
		JComboBox comboSelectionAlgo = new JComboBox();
		comboSelectionAlgo.setModel(new DefaultComboBoxModel(new String[] {"3 - Turnirski odabir", "Jednostavni generacijski odabir", "Jednostavni eliminacijski odabir"}));
		comboSelectionAlgo.setBounds(160, 7, 250, 20);
		frame.getContentPane().add(comboSelectionAlgo);
		
		JLabel lblCrossoverAlgo = new JLabel("Algoritam kri\u017Eanja");
		lblCrossoverAlgo.setBounds(10, 50, 140, 14);
		frame.getContentPane().add(lblCrossoverAlgo);
		
		JComboBox comboCrossoverAlgo = new JComboBox();
		comboCrossoverAlgo.setModel(new DefaultComboBoxModel(new String[] {"Kri\u017Eanje s jednom to\u010Dkom prekida", "Kri\u017Eanje s dvije to\u010Dke prekida", "Uniformno kri\u017Eanje"}));
		comboCrossoverAlgo.setBounds(160, 47, 250, 20);
		frame.getContentPane().add(comboCrossoverAlgo);
		
		JLabel lblMutationAlgo = new JLabel("Algoritam mutacije");
		lblMutationAlgo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMutationAlgo.setBounds(10, 90, 140, 14);
		frame.getContentPane().add(lblMutationAlgo);
		
		JComboBox comboMutationAlgo = new JComboBox();
		comboMutationAlgo.setModel(new DefaultComboBoxModel(new String[] {"Jednostavna mutacija", "Jednolika mutacija", "Nejednolika mutacija", "Grani\u010Dna mutacija"}));
		comboMutationAlgo.setBounds(160, 87, 250, 20);
		frame.getContentPane().add(comboMutationAlgo);
		
		JLabel lblNewLabel = new JLabel("Veli\u010Dina populacije");
		lblNewLabel.setBounds(10, 130, 140, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblVjerojatnostKrianja = new JLabel("Vjerojatnost kri\u017Eanja");
		lblVjerojatnostKrianja.setBounds(10, 170, 140, 14);
		frame.getContentPane().add(lblVjerojatnostKrianja);
		
		JLabel lblVjerojatnostMutacije = new JLabel("Vjerojatnost mutacije");
		lblVjerojatnostMutacije.setBounds(10, 210, 140, 14);
		frame.getContentPane().add(lblVjerojatnostMutacije);
		
		JButton btnIzvediAlgoritam = new JButton("Izvedi algoritam");
		btnIzvediAlgoritam.setBounds(10, 235, 140, 23);
		frame.getContentPane().add(btnIzvediAlgoritam);
		
		JButton btnNewButton = new JButton("Selja\u010Dki lonac");
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setBounds(10, 269, 140, 23);
		frame.getContentPane().add(btnNewButton);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 328, 988, 390);
		frame.getContentPane().add(editorPane);
		
		JLabel lblOutput = new JLabel("OUTPUT:");
		lblOutput.setBounds(10, 303, 140, 14);
		frame.getContentPane().add(lblOutput);
	}
}
