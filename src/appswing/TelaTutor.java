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

import model.Tutor;
import regras_negocio.Fachada;

public class TelaTutor {

	private JFrame frame;
	private JLabel labelTutores;
	private JButton buttonListar;
	private JTable tableTutores;
	private JScrollPane scrollPane;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JTextField textFieldTelefone;
	private JLabel labelNome;
	private JLabel labelCpf;
	private JLabel labelRua;
	private JLabel labelBairro;
	private JLabel labelCidade;
	private JLabel labelEstado;
	private JLabel labelTelefone;
	private JButton buttonAdicionar;
	private JLabel labelRodape;
	private JButton buttonDeletar;
	private JTextField textFieldNomePet;
	private JTextField textFieldEspecie;
	private JTextField textFieldRaca;
	private JTextField textFieldSexo;
	private JTextField textFieldData;
	private JTextField textFieldModalidade;
	private JTextField textFieldCooparticipacao;
	private JButton buttonAdicionarPet;
	private JLabel labelNomePet;
	private JLabel labelEspecie;
	private JLabel labelRaca;
	private JLabel labelSexo;
	private JLabel labelData;
	private JLabel labelModalidade;
	private JLabel labelCoop;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaTutor window = new TelaTutor();
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
	public TelaTutor() {
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
		
		labelTutores = new JLabel("Tutores");
		labelTutores.setBounds(12, 12, 70, 15);
		frame.getContentPane().add(labelTutores);
		
		buttonListar = new JButton("Listar");
		buttonListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listagem();
			}
		});
		buttonListar.setBounds(100, 7, 117, 25);
		frame.getContentPane().add(buttonListar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 39, 772, 209);
		frame.getContentPane().add(scrollPane);
		
		tableTutores = new JTable();
		scrollPane.setViewportView(tableTutores);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(31, 271, 114, 19);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(157, 271, 114, 19);
		frame.getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(283, 271, 114, 19);
		frame.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(409, 271, 114, 19);
		frame.getContentPane().add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(535, 271, 114, 19);
		frame.getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(661, 271, 114, 19);
		frame.getContentPane().add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(31, 330, 114, 19);
		frame.getContentPane().add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		labelNome = new JLabel("Nome");
		labelNome.setBounds(32, 255, 70, 15);
		frame.getContentPane().add(labelNome);
		
		labelCpf = new JLabel("Cpf");
		labelCpf.setBounds(157, 255, 70, 15);
		frame.getContentPane().add(labelCpf);
		
		labelRua = new JLabel("Rua");
		labelRua.setBounds(283, 255, 70, 15);
		frame.getContentPane().add(labelRua);
		
		labelBairro = new JLabel("Bairro");
		labelBairro.setBounds(409, 255, 70, 15);
		frame.getContentPane().add(labelBairro);
		
		labelCidade = new JLabel("Cidade");
		labelCidade.setBounds(535, 255, 70, 15);
		frame.getContentPane().add(labelCidade);
		
		labelEstado = new JLabel("Estado");
		labelEstado.setBounds(661, 255, 70, 15);
		frame.getContentPane().add(labelEstado);
		
		labelTelefone = new JLabel("Telefone");
		labelTelefone.setBounds(32, 315, 70, 15);
		frame.getContentPane().add(labelTelefone);
		
		labelRodape = new JLabel("");
		labelRodape.setBounds(12, 409, 788, 15);
		frame.getContentPane().add(labelRodape);
		
		buttonAdicionar = new JButton("Adicionar Tutor");
		buttonAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionar();
			}
		});
		buttonAdicionar.setBounds(157, 327, 142, 25);
		frame.getContentPane().add(buttonAdicionar);
		
		buttonDeletar = new JButton("Deletar");
		buttonDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deletar();
			}
		});
		buttonDeletar.setBounds(27, 373, 117, 25);
		frame.getContentPane().add(buttonDeletar);
		
		textFieldNomePet = new JTextField();
		textFieldNomePet.setBounds(385, 340, 114, 19);
		frame.getContentPane().add(textFieldNomePet);
		textFieldNomePet.setColumns(10);
		
		textFieldEspecie = new JTextField();
		textFieldEspecie.setBounds(511, 340, 114, 19);
		frame.getContentPane().add(textFieldEspecie);
		textFieldEspecie.setColumns(10);
		
		textFieldRaca = new JTextField();
		textFieldRaca.setBounds(634, 340, 114, 19);
		frame.getContentPane().add(textFieldRaca);
		textFieldRaca.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(385, 376, 114, 19);
		frame.getContentPane().add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(521, 378, 114, 19);
		frame.getContentPane().add(textFieldData);
		textFieldData.setColumns(10);
		
		textFieldModalidade = new JTextField();
		textFieldModalidade.setBounds(644, 378, 114, 19);
		frame.getContentPane().add(textFieldModalidade);
		textFieldModalidade.setColumns(10);
		
		textFieldCooparticipacao = new JTextField();
		textFieldCooparticipacao.setBounds(385, 409, 114, 19);
		frame.getContentPane().add(textFieldCooparticipacao);
		textFieldCooparticipacao.setColumns(10);
		
		buttonAdicionarPet = new JButton("AdicionarPet");
		buttonAdicionarPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionarPet();
			}
		});
		buttonAdicionarPet.setBounds(511, 409, 155, 25);
		frame.getContentPane().add(buttonAdicionarPet);
		
		labelNomePet = new JLabel("Nome Pet");
		labelNomePet.setBounds(385, 315, 70, 15);
		frame.getContentPane().add(labelNomePet);
		
		labelEspecie = new JLabel("Especie");
		labelEspecie.setBounds(511, 315, 70, 15);
		frame.getContentPane().add(labelEspecie);
		
		labelRaca = new JLabel("Raca");
		labelRaca.setBounds(634, 315, 70, 15);
		frame.getContentPane().add(labelRaca);
		
		labelSexo = new JLabel("Sexo");
		labelSexo.setBounds(385, 359, 70, 15);
		frame.getContentPane().add(labelSexo);
		
		labelData = new JLabel("Data");
		labelData.setBounds(521, 359, 70, 15);
		frame.getContentPane().add(labelData);
		
		labelModalidade = new JLabel("Modalidade");
		labelModalidade.setBounds(644, 359, 70, 15);
		frame.getContentPane().add(labelModalidade);
		
		labelCoop = new JLabel("Coop");
		labelCoop.setBounds(385, 394, 70, 15);
		frame.getContentPane().add(labelCoop);
	}
	
	public void listagem() {
		try{
			Fachada.inicializar();
			List<Tutor> tutores = Fachada.listarTutores();

			//model contem todas as linhas e colunas da tabela
			DefaultTableModel model = new DefaultTableModel();
			//colunas
			model.addColumn("nome");
			model.addColumn("cpf");
			model.addColumn("pets");
			model.addColumn("telefone");
			model.addColumn("rua");
			model.addColumn("bairro");
			model.addColumn("cidade");
			model.addColumn("estado");
			//linhas
			for(Tutor tutor : tutores) {
				model.addRow(new Object[]{tutor.getNome(), tutor.getCpf(), tutor.getPets().size(), tutor.getTelefone(),tutor.getEndereco().getRua(), 
						tutor.getEndereco().getBairro(), tutor.getEndereco().getCidade(), tutor.getEndereco().getEstado()});
			}

			tableTutores.setModel(model);
			labelRodape.setText("resultados: "+tutores.size()+ " tutores  - selecione uma linha");
		}
		catch(Exception erro){
			labelRodape.setText(erro.getMessage());
		} finally {
			Fachada.finalizar();
		}
	}
	
	public void adicionar() {
		try {
			Fachada.inicializar();
//			(String nome, String cpf, String rua, String bairro, 
//					String cidade, String estado, int telefone) 
			String nome, cpf, rua, bairro, cidade, estado;
			int telefone;
			nome = textFieldNome.getText();
			cpf = textFieldCpf.getText();
			rua = textFieldRua.getText();
			bairro = textFieldBairro.getText();
			cidade = textFieldCidade.getText();
			estado = textFieldEstado.getText();
			telefone = Integer.parseInt(textFieldTelefone.getText());
			Fachada.criarTutor(nome, cpf, rua, bairro, cidade, estado, telefone);
			listagem();
			textFieldNome.setText("");
			textFieldCpf.setText("");
			textFieldRua.setText("");
			textFieldBairro.setText("");
			textFieldCidade.setText("");
			textFieldEstado.setText("");
			textFieldTelefone.setText("");
		} catch(Exception erro){
			labelRodape.setText(erro.getMessage());
		} finally {
			Fachada.finalizar();
		}
	}
	
	public void deletar() {
		try {
			Fachada.inicializar();
			if (tableTutores.getSelectedRow() >= 0){
				String cpf = (String)tableTutores.getValueAt( tableTutores.getSelectedRow(), 1);
				Fachada.deletarTutor(cpf);
				listagem();
			}
		} catch(Exception erro){
			labelRodape.setText(erro.getMessage());
		} finally {
			Fachada.finalizar();
		}
	}
	
	public void adicionarPet() {
		try {
			Fachada.inicializar();
			String nomePet, especie, raca, sexo, data, modalidade;
			boolean cooparticipacao;
			nomePet = textFieldNomePet.getText();
			especie = textFieldEspecie.getText();
			raca = textFieldRaca.getText();
			data = textFieldData.getText();
			modalidade = textFieldModalidade.getText();
			sexo = textFieldSexo.getText();
			if (textFieldCooparticipacao.equals("true")) {
				cooparticipacao = true;
			} else {
				cooparticipacao = false;
			}
			if (tableTutores.getSelectedRow() >= 0){
				String cpf = (String)tableTutores.getValueAt( tableTutores.getSelectedRow(), 1);
				Fachada.adicionarPet(nomePet, especie, raca, cpf, sexo, data, modalidade, cooparticipacao);
				listagem();
				textFieldNomePet.setText("");
				textFieldEspecie.setText("");
				textFieldRaca.setText("");
				textFieldData.setText("");
				textFieldModalidade.setText("");
				textFieldSexo.setText("");
			}
		} catch(Exception erro){
			labelRodape.setText(erro.getMessage());
		} finally {
			Fachada.finalizar();
			
		}
	}

}