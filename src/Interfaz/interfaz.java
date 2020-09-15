package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class interfaz extends JFrame {

	private JPanel contentPane;

	/**
	 * Asosiacion a la clase Polar
	 */
	private Polar polar;

	/**
	 * Indica el tamaño de las filas de la contenedora de JButton.
	 */
	public final static int FILAS  = 4;

	/**
	 * Indica el tamaño columnas de la contenedora de JButton.
	 */	
	public final static int COLUMNAS  = 4;

	/**
	 * Contenedora de Jbutton 
	 */
	JButton[][] labelMatriz = new JButton[FILAS][COLUMNAS];
	Border border = BorderFactory.createLineBorder(Color.blue, 1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaz frame = new interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public interfaz() {

		polar= new Polar(1, 1, 1);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JPanel lblPanelMatriz = new JPanel();
		lblPanelMatriz.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPanelMatriz.setBounds(10, 11, 286, 296);
		contentPane.add(lblPanelMatriz);
		lblPanelMatriz.setLayout(new GridLayout(5, 5, 0, 0));

		JButton btnNewButton = new JButton("Sacar solucion en consola");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				polar.asignarValores();
				int[][] sks=polar.returnPrimerafila();
				for (int i = 0; i < FILAS; i++) 
				{
					for (int j = 0; j < COLUMNAS; j++) 
					{
						labelMatriz[i][j].setText(sks[i][j]+"");
					}
				}
			}
		});
		btnNewButton.setBounds(332, 11, 170, 38);
		contentPane.add(btnNewButton);

		/**
		 * Se muestra la matriz
		 */
		for (int i = 0; i < FILAS; i++) 
		{
			for (int j = 0; j < COLUMNAS; j++) 
			{
				labelMatriz[i][j] = new JButton(); 
				labelMatriz[i][j].setBounds(40, (i + j)*50, 40,30); 

				if(labelMatriz[i][j] == labelMatriz[0][0])
				{
					labelMatriz[i][j].setText(("7"));
				}
				else if (labelMatriz[i][j] == labelMatriz[0][3])
				{
					labelMatriz[i][j].setText(("15"));
				}
				else if (labelMatriz[i][j] == labelMatriz[1][3])
				{
					labelMatriz[i][j].setText(("12"));
				}
				else if (labelMatriz[i][j] == labelMatriz[2][3])
				{
					labelMatriz[i][j].setText(("18"));
				}
				else if (labelMatriz[i][j] == labelMatriz[3][3])
				{
					labelMatriz[i][j].setText(("18"));
				}
				else if (labelMatriz[i][j] == labelMatriz[3][2])
				{
					labelMatriz[i][j].setText(("19"));
				}
				else if (labelMatriz[i][j] == labelMatriz[3][1])
				{
					labelMatriz[i][j].setText(("14"));
				}
				else if (labelMatriz[i][j] == labelMatriz[3][0])
				{
					labelMatriz[i][j].setText(("12"));
				}
				lblPanelMatriz.add(labelMatriz[i][j]);
			}
		}
	}
}



