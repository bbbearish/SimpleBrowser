package bearishBrowser;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class simpleWebBrowser extends JFrame {

	private JTextField addressBar;
	private JEditorPane display;

	//constructor

	public simpleWebBrowser (){
		super ("BEARISH");

		addressBar = new JTextField("Enter a URL hoss!!!");
		addressBar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						loadcrap(event.getActionCommand());

					}
				}

				);
		add(addressBar, BorderLayout.NORTH);

		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
				new HyperlinkListener() {

					public void hyperlinkUpdate(HyperlinkEvent event) {
						if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
							loadcrap(event.getURL().toString());

						}

					}
				}

				);
		add(new JScrollPane(display),BorderLayout.CENTER);
		setSize(500,400);
		setVisible(true);

	}
	private void loadcrap(String userText){
		try {
			display.setPage(userText);
			addressBar.setText(userText);
		} catch (Exception e) {
			System.out.println("crap!!!");
		}

	}

}
