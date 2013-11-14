import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.JFileChooser.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.*;

public class aTunes extends Applet implements ActionListener{
	private JButton bPlay, bPause, bF, bB, bAbrir;
	private JFrame f;
	private JTable tabla;
	private JList canciones;
	private String filePath;

	public aTunes(){
		init();
		start();
		//Boton abrir
		bAbrir = new JButton("Abrir");
		add(bAbrir);
		bAbrir.addActionListener(this);
		//Boton abrir
		bPlay = new JButton("Reproducir");
		add(bPlay);
		bPlay.addActionListener(this);
		//Frame
		f = new JFrame("aTunes ");
		f.add("Center", this);
		f.setSize(700, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		//Accion de oir enter
		/*entry.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
            	int key=e.getKeyCode();
		        if (key==KeyEvent.VK_ENTER)
		            doit(); 
            }
        });*/
	}

	public void actionPerformed(ActionEvent e){
		JButton source = (JButton)e.getSource();
		if (source == bAbrir){
			JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Archivos de Musica", "mp3", "wav");
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(f);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       System.out.println("You chose to open this file: " +
		            chooser.getSelectedFile().getName());
		    }
		    filePath = chooser.getSelectedFile().getName();
		}
		if (source == bPlay){
			 SoundJLayer soundToPlay = new SoundJLayer(filePath);
			 soundToPlay.play();
		}
	}

	public static void main(String[] args) {
		new aTunes();
	}
}