package components;

import generer.ColorerSource;
import generer.Generateur;
import generer.MotAvecCouleur;
import grammaire.lgParser.SystemContext;
import ihm.swing.SwingBuilder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import model.erreur.ErreurModule;
import model.erreur.ErreurSemantique;
import model.semantique.Univers;
import test.A;
import test.B;
import test.U;

import org.xml.sax.SAXException;

public class Terminal extends JFrame implements KeyListener, ActionListener, ListSelectionListener {
	JTextPane input;

	JTextPane output;
	// public static String chemin = "F:\\workspaces\\Lg";
	public static String chemin = "F:\\GitHub\\Lg";
	Map<Color, AttributeSet> asets = new HashMap<>();
	public List<Class> api = new ArrayList<>();

	/**
	 * @param args
	 */
	TextAreaOutputStream streamOutput;
	JList<String> list;
	JList<ErreurSemantique> listErreurSemantique;
	JButton nouveau;

	public Terminal() {
		api.add(A.class);
		api.add(B.class);
		api.add(U.class);

		SwingBuilder sb = new SwingBuilder(this);

		output = new JTextPane();
		streamOutput = new TextAreaOutputStream(output);
		// System.setOut(new PrintStream(streamOutput));
		// System.setErr(new PrintStream(streamOutput));
		JScrollPane outputScrollPane = new JScrollPane(output);
		input = new JTextPane();

		JScrollPane inputScrollPane = new JScrollPane(input);
		outputScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		list = new JList<String>();
		listErreurSemantique = new JList<ErreurSemantique>();
		this.chargerList();
		JScrollPane listScrollPane = new JScrollPane(list);
		nouveau = new JButton("Nouveau");
		nouveau.addActionListener(this);

		sb.beginX();
		sb.beginY();
		sb.setSize(1600, 700);
		sb.add(inputScrollPane);
		sb.beginX();
		sb.setSize(600, 200);
		sb.add(outputScrollPane);
		sb.space(4);
		sb.setSize(996, 200);
		sb.add(listErreurSemantique);
		sb.end();
		sb.end();
		sb.space(4);
		sb.beginY();
		sb.setSize(300, 30);
		sb.add(nouveau);
		sb.setSize(300, 870);
		sb.add(listScrollPane);

		sb.end();
		sb.end();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		input.addKeyListener(this);
		list.addListSelectionListener(this);
		// list.addLis
		sb.open("Langage fonctionnel");

	}

	public void chargerList() {
		String ls[] = new File(".").list();
		Vector<String> vector = new Vector<String>();
		for (String s : ls) {
			if (s.endsWith(".mdl"))
				vector.add(s);
		}
		if (!this.api.isEmpty()) {
			vector.add("api.mdl");
		}
		list.setListData(vector);
	}

	AttributeSet attributeSet(Color c) {
		AttributeSet as = asets.get(c);
		if (as == null) {
			SimpleAttributeSet attributes = new SimpleAttributeSet();
			attributes = new SimpleAttributeSet();
			attributes.addAttribute(StyleConstants.CharacterConstants.Bold, Boolean.TRUE);
			attributes.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.FALSE);
			attributes.addAttribute(StyleConstants.CharacterConstants.Foreground, c);
			StyleConstants.setFontSize(attributes, 14);
			as = attributes;
			asets.put(c, as);
		}
		return as;

	}

	public static void main(String[] args)
			throws XPathExpressionException, SQLException, SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		if (args.length >= 1) {
			chemin = args[0];

		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Terminal().setVisible(true);
			}
		});

	}

	boolean colorer = false;

	public List<ErreurSemantique> erreurs = new ArrayList<>();


	Univers donnerUniversPourSource(String nom, String src, Univers courant) throws IOException {
		Generateur gen = new Generateur();
	   Map<String,String> sources = new HashMap<>();
		for(int i=0;i< this.list.getModel().getSize();i++) {
			String n =this.list.getModel().getElementAt(i);
			if (n.equals("api.mdl")) {
				sources.put(n,Generateur.genererTypes(api));
			} else {
				sources.put(n,  new String(Files.readAllBytes(Paths.get(chemin, n ))));
			}
		}
		Univers u= gen.donnerUniversPourSource(nom, src,courant, sources);
		u.erreurs.addAll(gen.erreurs);
		return u;
		

	}

	public void compiler() throws IOException{

		erreurs = new ArrayList<>();

		StyledDocument document = input.getStyledDocument();
		String src="";
		try {
			src = document.getText(0, document.getLength());
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String src = input.getText();
		Univers u = this.donnerUniversPourSource("courant", src, null);
		if (u != null) {
			erreurs = u.erreurs;

		}
		ErreurSemantique array[] = new ErreurSemantique[erreurs.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = erreurs.get(i);
		}
		this.listErreurSemantique.setListData(array);
		if (u == null) {
			return;
		}
		final ColorerSource cs = new ColorerSource();
		System.out.println(" compilation ok " + src);
		cs.lireSource(src);
		this.clearColor(Color.black);
		for (MotAvecCouleur m : cs.ls) {

			setColor(m.color, m.debut, m.taille);
		}

	}

	public void keyPressed(KeyEvent e) {

	}

	public void clearColor(Color color) {

		this.setColor(Color.black, 0, input.getStyledDocument().getLength());

	}

	String s = "";

	public void setColor(Color c, int idx, int l) {
	
		JTextPane tp = this.input;


		tp.getStyledDocument().setCharacterAttributes(idx , l, this.attributeSet(c), true);

	}

	boolean selection = false;

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		String sel = list.getSelectedValue();
		if (sel != null && sel.equals("api.mdl")) {
			return;
		}
		if (selection) {
			return;
		}
		this.output.setText("");
		try {
			compiler();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {

			Files.delete(Paths.get(".", sel));
			Files.write(Paths.get(".", sel), this.input.getText().getBytes(), StandardOpenOption.CREATE);
			// System.out.println(" "+sel);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.streamOutput.flush();

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == nouveau) {
			String nom = UI.request("nom ", this);
			for (int idx = 0; idx < this.list.getModel().getSize(); idx++) {
				String tmp = this.list.getModel().getElementAt(idx);
				if (tmp.equals(nom)) {
					UI.warning("nom existant", this);
					return;
				}
			}
			try {
				Files.write(Paths.get(chemin, nom), this.input.getText().getBytes(), StandardOpenOption.CREATE_NEW);
				this.chargerList();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			this.compiler();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		String sel = list.getSelectedValue();
		if (sel == null) {
			return;
		}
		try {
			selection = true;
			this.input.setText("");
			String src;
			if (sel.equals("api.mdl")) {
				src = Generateur.genererTypes(api);
				this.input.setEditable(false);
			} else {
				src = new String(Files.readAllBytes(Paths.get(chemin, sel)));
				this.input.setEditable(true);
			}
			this.input.setText(src);
			this.compiler();
			this.input.setCaretPosition(0);
			selection = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
