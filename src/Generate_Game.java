import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Generate_Game {

    public static void createSpace(int i, int k, JFrame frame, GridBagConstraints pin, java.util.List<JButton> space){
        pin.gridx = k;
        pin.gridy = i;
        //pin.ipadx = 50;
        //pin.ipady = 70;

        JButton button = new JButton();

        space.add(button);
        frame.add(button,pin);

        // set size
        Dimension size = new Dimension(80,80);
        button.setPreferredSize(size);
        button.setMinimumSize(size);
        button.setMaximumSize(size);
        // removes box around button text
        button.setFocusPainted(false);
        // makes button background transparent
        button.setBackground(new Color(255,0,0,0));
        // removes opaque background when the button is hovered
        button.setOpaque(false);

        button.addActionListener(event -> {
            System.out.printf("x: %d, y: %d\n",k,i);
            if(select == null){} // does nothing
            else{
                String numtext = Integer.toString(select);
                button.setText(numtext);
            }
        });
    }

    // creates the buttons that allow the user to pick a number
    public static void createNumButton(int num, JFrame frame, GridBagConstraints n, List<Integer> nums){
        n.gridx = num;
        n.gridy = 10;
        n.ipadx = 0;
        n.ipady = 0;

        JButton button = new JButton(String.format("%d",num));
        frame.add(button,n);

        // makes button background transparent
        button.setBackground(new Color(255,0,0,0));
        // removes opaque background when the button is hovered
        button.setOpaque(false);
        // removes button border
        button.setBorderPainted(false);
        // removes button text border
        button.setFocusPainted(false);

        button.addActionListener(e ->{
            System.out.printf("button %d clicked\n",num);
            setNum(num);
        });
    }

    public Generate_Game(){
        // add empty spaces
        for(int i = 1; i <= 9; i++){
            for(int k = 1; k <= 9; k++){
                location.put(k,i);
                createSpace(i,k,mainframe,pin,space);
            }
        }

        // add number selection buttons
        for(int i = 1; i <= 9; i++){
            nums.add(i);
            createNumButton(i,mainframe,n,nums);
        }
    }
}
