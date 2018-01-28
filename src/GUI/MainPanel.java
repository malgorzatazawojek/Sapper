package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
<<<<<<< Upstream, based on origin/master
=======
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
>>>>>>> e4ece6b sample changes
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



import calc.BombField;




public class MainPanel extends JFrame implements ActionListener, ChangeListener, AdjustmentListener{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JPanel p =new JPanel(), l=new JPanel();
	static JFrame frame;
	int mh=700, mw=900, h=100, w=150, panelSize=10, fw=40, fh=fw, time=0, score=0, numberOfBombs=15;
    JButton fields[][] = new JButton[panelSize][panelSize];
    JLabel numbers[][] = new JLabel[panelSize][panelSize];
    ImageIcon icon = new ImageIcon("smile.png"); 
    JLabel iconLabel = new JLabel();
    
    BombField bf= new BombField(panelSize,numberOfBombs);
	
	public MainPanel() throws HeadlessException{
		/**
		*Here we are describing the atributes of main frame
		*/
		setVisible(true);
        setLocation(100,100);
        setTitle("Sapper");
        setResizable(false);
        /**
         * Here we are defining the components of the top panel.
         * */

        JPanel  numerical[] = new JPanel[2];
        JLabel label[]=new JLabel[2];
        iconLabel.setIcon(icon);
 
        for(int j=0; j<2; j++) {
        	numerical[j]=new JPanel();
        	numerical[j].setVisible(true);
        	numerical[j].setBackground(Color.BLACK);
        	label[j]=new JLabel("000");
        	label[j].setForeground(Color.RED);
        	label[j].setFont(new Font("Serif", Font.BOLD, 18));
        	numerical[j].add(label[j]);
        }
        /**
         * Here we are defining the panel with buttons
         */
        p.setVisible(true);
		p.setLayout(new GridLayout(panelSize,panelSize));
		p.setPreferredSize(new Dimension(panelSize*fh+10,panelSize*fw+10));
        for(int j=0; j<panelSize;j++) {
        	for(int k=0;k<panelSize;k++) {
        		JButton tmp=new JButton();
        		tmp.addMouseListener(
        				new MouseAdapter() {
        					boolean pressed;
        					
        		            @Override
        		            public void mousePressed(MouseEvent e) {
        		            	tmp.getModel().setArmed(true);
        		            	tmp.getModel().setPressed(true);
        		                pressed = true;
        		            }

        		            @Override
        		            public void mouseReleased(MouseEvent e) {
        		            	int X=0;
       			        	 	int Y=0;
 			        	 
       			             	for (int i = 0; i < fields.length; i++) { 
       			             	    for (int j = 0; j < fields[i].length; j++) { 
       			             	        if (fields[i][j] == tmp) { 
       			             	        	X=j;
       			             	        	Y=i;
       			             	        }
       			             	    }    
       			             	}
        		            	
        		                //if(isRightButtonPressed) {underlyingButton.getModel().setPressed(true));
        		            	tmp.getModel().setArmed(false);
        		            	tmp.getModel().setPressed(false);

        		                if (pressed) {
        		                    if (SwingUtilities.isRightMouseButton(e)) {
        		                    	if(bf.getField(X, Y).getFlag()) {
        		                    	tmp.setBackground(Color.GREEN);
        		                    	System.out.println("Flag is on!'");
        		                    	}else {
            		                    	tmp.setBackground(null);
        		                    	}bf.getField(X,Y).setFlag();
        		                    	System.out.println("Flag is off!");
        		                    	}
        		                    else {

                			            if(!bf.getField(X,Y).getOpen()&&!bf.getField(X,Y).getFlag()){ 	
                			             	if(bf.getField(X, Y).getMine()) {
                    			             	tmp.setBackground(Color.RED);
                			             		icon=new ImageIcon("looser.png");  
                			             	    iconLabel.setIcon(icon);
                			             	    //System.out.println("Mine!");
                			             	    
                			             	}else if(bf.getField(X, Y).getCount()>0) {
                			             		String s=""+bf.getField(X, Y).getCount();
                			             		tmp.setFont(new Font("Arial", Font.BOLD, 12));
                			             		tmp.setText(s);
                			             		tmp.setBackground(Color.LIGHT_GRAY);
                			             		//System.out.println(s);
                			             	}else {tmp.setBackground(Color.DARK_GRAY);}
                			             	
                			         }
                			            if(!bf.getField(X,Y).getFlag()) {
            			             	bf.getField(X, Y).setOpen(); }  
                			         }
        		                    }
        		                
        		                pressed = false;

        		            }

        		            @Override
        		            public void mouseExited(MouseEvent e) {
        		                pressed = false;
        		            }

        		            @Override
        		            public void mouseEntered(MouseEvent e) {
        		                pressed = true;
        		            } 
        					
        					
        				});
        		
        		tmp.addActionListener(
        				new ActionListener(){
        			         @Override
        			         public void actionPerformed(ActionEvent e) {
//        			        	 int X=0;
//        			        	 int Y=0;
//  			        	 
//        			             	for (int i = 0; i < fields.length; i++) { 
//        			             	    for (int j = 0; j < fields[i].length; j++) { 
//        			             	        if (fields[i][j] == tmp) { 
//        			             	        	X=j;
//        			             	        	Y=i;
//        			             	        }
//        			             	    }    
//        			             	}
//        			            if(!bf.getField(X,Y).getOpen()&&!bf.getField(X,Y).getFlag()){ 	
//        			             	if(bf.getField(X, Y).getMine()) {
//            			             	tmp.setBackground(Color.RED);
//        			             		icon=new ImageIcon("looser.png");  
//        			             	    iconLabel.setIcon(icon);
//        			             	    System.out.println("Mine!");
//        			             	    
//        			             	}else if(bf.getField(X, Y).getCount()>0) {
//        			             		String s=""+bf.getField(X, Y).getCount();
//        			             		tmp.setFont(new Font("Arial", Font.BOLD, 12));
//        			             		tmp.setText(s);
//        			             		tmp.setBackground(Color.LIGHT_GRAY);
//        			             		System.out.println(s);
//        			             	}else {tmp.setBackground(Color.DARK_GRAY);}
//        			             	
//        			         }
//        			            if(!bf.getField(X,Y).getFlag()) {
//    			             	bf.getField(X, Y).setOpen(); }  
//        			         
        			         }}
        				);
        		fields[j][k]=tmp;
        		fields[j][k].setVisible(true);
        		fields[j][k].setPreferredSize(new Dimension(fh,fw));
                p.add(fields[j][k]);
        	}
        }    
        /**
         * and here we are placing all of it on the board
         */
		l.setVisible(true);
        l.add(numerical[0]);
        l.add(iconLabel);
        l.add(numerical[1]);
        
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 1;
		add(p,c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;

		add(l,c);
		
	    pack();

	}
	
@Override
public void adjustmentValueChanged(AdjustmentEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void stateChanged(ChangeEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void actionPerformed(ActionEvent arg0 ) {
	// TODO Auto-generated method stub

if(arg0.getSource() instanceof JButton){
	//(JButton) arg0.getSource()
	fields[1][1].setBackground(Color.WHITE);
}else {
	
}
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	MainPanel f=new MainPanel(); 
	  f.setVisible(true);
	  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  

}
}