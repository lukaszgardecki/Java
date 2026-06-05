
package com.example.programowanie2.zadania_kolokwium;

import javax.swing.JOptionPane;

/**
 *
 * @author MBoryczka
 */
public class NWP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
	{      int x1, y1, x, y, NWW;
		
	
		x = Integer.parseInt(JOptionPane.showInputDialog("Podaj x..."));
		x1 = x;
		y = Integer.parseInt(JOptionPane.showInputDialog("Podaj y..."));
		y1 = y;
		while (x!=y)
			if (x>y) x = x - y;
                        else     y = y - x;
			
		NWW = x1 / x * y1;
                
		JOptionPane.showMessageDialog(null, "NWP = " + x);
		JOptionPane.showMessageDialog(null, "NWW = " + NWW);
	}
    
}
