import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class Difficulty {
    public Difficulty(JFrame frame){
        JLabel message = new JLabel("Choose a Difficulty");
        JButton easy = new JButton("Easy");
        JButton medium = new JButton("Medium");
        JButton hard = new JButton("Hard");

        frame.add(message);
        frame.add(easy);
        frame.add(medium);
        frame.add(hard);

        easy.addActionListener(e -> {
            //
        });
    }
}
