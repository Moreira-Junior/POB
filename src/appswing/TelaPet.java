package appswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Pet;
import regras_negocio.Fachada;

public class TelaPet {

	private JFrame frame;
	private JLabel labelPets;
	private JButton buttonListar;
	private JTable tablePets;
	private JScrollPane scrollPane;
	private JLabel labelRodape;
	private JTextField textFieldNome;
	private JLabel labelNome;
	private JTextField textFieldEspecie;
	private JTextField textFieldRaca;
	private JTextField textFieldCpfTutor;
	private JTextField textFieldData;
	private JTextField textFieldModalidade;
	private JTextField textFieldCooparticipacao;
	private JLabel labelEspecie;
	private JLabel labelRaca;
	private JLabel labelCpfTutor;
	private JLabel labelData;
	private JLabel labelModalidade;
	private JLabel labelCooparticipacao;
	private JButton buttonAdicionarPet;
	private JTextField textFieldSexo;
	private JLabel labelSexo;
	private JButton buttonDeletar;
	private JTextField textFieldNovaModalidade;
	private JTextField textFieldNovaCooparticipacao;
	private JLabel labelNovaModalidade;
	private JLabel labelNovaCooparticipacao;
	private JButton buttonAtualizar;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaPet window = new TelaPet();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TelaPet() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 823, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				listagem();
			}
		});
		
		labelPets = new JLabel("Pets");
		labelPets.setBounds(12, 0, 70, 15);
		frame.getContentPane().add(labelPets);
		
		buttonListar = new JButton("Listar");
		buttonListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listagem();
			}
		});
		buttonListar.setBounds(62, -5, 117, 25);
		frame.getContentPane().add(buttonListar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 39, 788, 136);
		frame.getContentPane().add(scrollPane);
		
		tablePets = new JTable();
		scrollPane.setViewportView(tablePets);
		
		labelRodape = new JLabel("");
		labelRodape.setBounds(12, 409, 788, 15);
		frame.getContentPane().add(labelRodape);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(30, 220, 114, 19);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		labelNome = new JLabel("Nome");
		labelNome.setBounds(35, 187, 70, 15);
		frame.getContentPane().add(labelNome);
		
		textFieldEspecie = new JTextField();
		textFieldEspecie.setBounds(161, 220, 129, 19);
		frame.getContentPane().add(textFieldEspecie);
		textFieldEspecie.setColumns(10);
		
		textFieldRaca = new JTextField();
		textFieldRaca.setBounds(302, 220, 114, 19);
		frame.getContentPane().add(textFieldRaca);
		textFieldRaca.setColumns(10);
		
		textFieldCpfTutor = new JTextField();
		textFieldCpfTutor.setBounds(428, 220, 114, 19);
		frame.getContentPane().add(textFieldCpfTutor);
		textFieldCpfTutor.setColumns(10);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(563, 220, 114, 19);
		frame.getContentPane().add(textFieldData);
		textFieldData.setColumns(10);
		
		textFieldModalidade = new JTextField();
		textFieldModalidade.setBounds(35, 263, 114, 19);
		frame.getContentPane().add(textFieldModalidade);
		textFieldModalidade.setColumns(10);
		
		textFieldCooparticipacao = new JTextField();
		textFieldCooparticipacao.setBounds(174, 263, 114, 19);
		frame.getContentPane().add(textFieldCooparticipacao);
		textFieldCooparticipacao.setColumns(10);
		
		labelEspecie = new JLabel("Especie");
		labelEspecie.setBounds(171, 187, 70, 15);
		frame.getContentPane().add(labelEspecie);
		
		labelRaca = new JLabel("Raca");
		labelRaca.setBounds(303, 187, 70, 15);
		frame.getContentPane().add(labelRaca);
		
		labelCpfTutor = new JLabel("Cpf Tutor");
		labelCpfTutor.setBounds(436, 187, 70, 15);
		frame.getContentPane().add(labelCpfTutor);
		
		labelData = new JLabel("Data");
		labelData.setBounds(563, 187, 70, 15);
		frame.getContentPane().add(labelData);
		
		labelModalidade = new JLabel("Modalidade");
		labelModalidade.setBounds(40, 239, 70, 15);
		frame.getContentPane().add(labelModalidade);
		
		labelCooparticipacao = new JLabel("Cooparticipacao");
		labelCooparticipacao.setBounds(174, 236, 70, 15);
		frame.getContentPane().add(labelCooparticipacao);
		
		buttonAdicionarPet = new JButton("Adicionar Pet");
		buttonAdicionarPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionarPet();
			}
		});
		buttonAdicionarPet.setBounds(312, 260, 117, 25);
		frame.getContentPane().add(buttonAdicionarPet);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(689, 220, 114, 19);
		frame.getContentPane().add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		labelSexo = new JLabel("Sexo");
		labelSexo.setBounds(689, 187, 70, 15);
		frame.getContentPane().add(labelSexo);
		
		buttonDeletar = new JButton("Deletar");
		buttonDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deletar();
			}
		});
		buttonDeletar.setBounds(27, 373, 117, 25);
		frame.getContentPane().add(buttonDeletar);
		
		textFieldNovaModalidade = new JTextField();
		textFieldNovaModalidade.setBounds(353, 373, 114, 19);
		frame.getContentPane().add(textFieldNovaModalidade);
		textFieldNovaModalidade.setColumns(10);
		
		textFieldNovaCooparticipacao = new JTextField();
		textFieldNovaCooparticipacao.setBounds(506, 373, 114, 19);
		frame.getContentPane().add(textFieldNovaCooparticipacao);
		textFieldNovaCooparticipacao.setColumns(10);
		
		labelNovaModalidade = new JLabel("NovaModalidade");
		labelNovaModalidade.setBounds(353, 357, 129, 15);
		frame.getContentPane().add(labelNovaModalidade);
		
		labelNovaCooparticipacao = new JLabel("NovaCoop");
		labelNovaCooparticipacao.setBounds(506, 357, 171, 15);
		frame.getContentPane().add(labelNovaCooparticipacao);
		
		buttonAtualizar = new JButton("Atualizar");
		buttonAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizar();
			}
		});
		buttonAtualizar.setBounds(642, 370, 117, 25);
		frame.getContentPane().add(buttonAtualizar);
	}
	
	public void listagem () {
		try{
			Fachada.inicializar();
			List<Pet> pets = Fachada.listarPets();

			//model contem todas as linhas e colunas da tabela
			DefaultTableModel model = new DefaultTableModel();
			//colunas
			model.addColumn("id");
			model.addColumn("nome");
			model.addColumn("raca");
			model.addColumn("sexo");
			model.addColumn("tutor");
			model.addColumn("contrato");
			//linhas
			String nomeTutor;
			for(Pet pet : pets) {
				if(pet.getTutor() == null) {
					nomeTutor = "null";
				} else {
					nomeTutor = pet.getTutor().getNome();
				}
				model.addRow(new Object[]{pet.getId(), pet.getNome(), pet.getRaca(), pet.getSexo(), nomeTutor, pet.getContrato().getModalidade().getNome()});
			}

			tablePets.setModel(model);
			labelRodape.setText("resultados: "+pets.size()+ " pets  - selecione uma linha");
		}
		catch(Exception erro){
			labelRodape.setText(erro.getMessage());
		} finally {
			Fachada.finalizar();
		}
	}
	
	public void adicionarPet() {
		try {
			Fachada.inicializar();
			String nome, especie, raca, cpfTutor, data, modalidade, sexo;
			boolean cooparticipacao;
			nome = textFieldNome.getText();
			especie = textFieldEspecie.getText();
			raca = textFieldRaca.getText();
			cpfTutor = textFieldCpfTutor.getText();
			data = textFieldData.getText();
			modalidade = textFieldModalidade.getText();
			sexo = textFieldSexo.getText();
			if (textFieldCooparticipacao.equals("true")) {
				cooparticipacao = true;
			} else {
				cooparticipacao = false;
			}
			Fachada.criarPet(nome, especie, raca, cpfTutor, sexo, data, modalidade, cooparticipacao);
			listagem();
			textFieldNome.setText("");
			textFieldEspecie.setText("");
			textFieldRaca.setText("");
			textFieldCpfTutor.setText("");
			textFieldData.setText("");
			textFieldModalidade.setText("");
			textFieldSexo.setText("");
		} catch(Exception erro){
			labelRodape.setText(erro.getMessage());
		} finally {
			Fachada.finalizar();
		}
	}
	
	public void deletar() {
		try {
			Fachada.inicializar();
			if (tablePets.getSelectedRow() >= 0){
				int id = (Integer) tablePets.getValueAt( tablePets.getSelectedRow(), 0);
				Fachada.deletarPet(id);
				listagem();
			}
		} catch(Exception erro){
			labelRodape.setText(erro.getMessage());
		} finally {
			Fachada.finalizar();
		}
	}
	
	public void atualizar() {
		try {
			Fachada.inicializar();
			String novaModalidade;
			boolean novaCooparticipacao;
			novaModalidade = textFieldNovaModalidade.getText();
			if (textFieldNovaCooparticipacao.equals("true")) {
				novaCooparticipacao = true;
			} else {
				novaCooparticipacao = false;
			}
			if (tablePets.getSelectedRow() >= 0){
				int id = (Integer) tablePets.getValueAt( tablePets.getSelectedRow(), 0);
				Fachada.alterarContratoDoPet(id, novaModalidade, novaCooparticipacao);
				listagem();
				textFieldNovaModalidade.setText("");
				textFieldNovaCooparticipacao.setText("");
			}
		} catch(Exception erro){
			labelRodape.setText(erro.getMessage());
		} finally {
			Fachada.finalizar();
		}
	}
}