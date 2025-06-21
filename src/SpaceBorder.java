import javax.swing.border.MatteBorder;
import java.awt.*;

public class SpaceBorder {
    public MatteBorder SpaceBorder(int z, int y, int x){
        if(z == 0) {
            if (x == 0) {
                if (y == 0) {
                    MatteBorder border = new MatteBorder(3, 3, 0, 0, Color.BLACK);
                } else if (y == 1) {
                    MatteBorder border = new MatteBorder(0, 3, 0, 0, Color.BLACK) ;
                } else {
                    MatteBorder border = new MatteBorder(0, 3, 1, 0, Color.BLACK) ;
                }
            } else if (x == 1) {
                if (y == 0) {
                    MatteBorder border = new MatteBorder(3, 0, 0, 0, Color.BLACK) ;
                } else if (y == 1) {
                    MatteBorder border = new MatteBorder(0, 0, 0, 0, Color.BLACK) ;
                } else {
                    MatteBorder border = new MatteBorder(0, 0, 1, 0, Color.BLACK) ;
                }
            } else {
                if (y == 0) {
                    MatteBorder border = new MatteBorder(3, 0, 0, 1, Color.BLACK) ;
                } else if (y == 1) {
                    MatteBorder border = new MatteBorder(0, 0, 0, 1, Color.BLACK);
                } else {
                    MatteBorder border = new MatteBorder(0, 0, 1, 1, Color.BLACK);
                }
            }
        } else if(z == 1 || z == 4 || z == 7){
            if (x == 0) {
                if (y == 0) {
                    MatteBorder border = new MatteBorder(3, 1, 0, 0, Color.BLACK);
                } else if (y == 1) {
                    MatteBorder border = new MatteBorder(0, 1, 0, 0, Color.BLACK);
                } else {
                    MatteBorder border = new MatteBorder(0, 1, 1, 0, Color.BLACK);
                }
            } else if (x == 1) {
                if (y == 0) {
                    MatteBorder border = new MatteBorder(3, 0, 0, 0, Color.BLACK);
                } else if (y == 1) {
                    MatteBorder border = new MatteBorder(0, 0, 0, 0, Color.BLACK);
                } else {
                    MatteBorder border = new MatteBorder(0, 0, 1, 0, Color.BLACK);
                }
            } else {
                if (y == 0) {
                    MatteBorder border = new MatteBorder(3, 0, 0, 1, Color.BLACK);
                } else if (y == 1) {
                    MatteBorder border = new MatteBorder(0, 0, 0, 1, Color.BLACK);
                } else {
                    MatteBorder border = new MatteBorder(0, 0, 1, 1, Color.BLACK);
                }
            }
        } else{
            if (x == 0) {
                if (y == 0) {
                    MatteBorder border = new MatteBorder(3, 3, 0, 0, Color.BLACK);
                } else if (y == 1) {
                    MatteBorder border = new MatteBorder(0, 3, 0, 0, Color.BLACK);
                } else {
                    MatteBorder border = new MatteBorder(0, 3, 3, 0, Color.BLACK);
                }
            } else if (x == 1) {
                if (y == 0) {
                    MatteBorder border = new MatteBorder(3, 0, 0, 0, Color.BLACK);
                } else if (y == 1) {
                    MatteBorder border = new MatteBorder(0, 0, 0, 0, Color.BLACK);
                } else {
                    MatteBorder border = new MatteBorder(0, 0, 3, 0, Color.BLACK);
                }
            } else {
                if (y == 0) {
                    MatteBorder border = new MatteBorder(3, 0, 0, 3, Color.BLACK);
                } else if (y == 1) {
                    MatteBorder border = new MatteBorder(0, 0, 0, 3, Color.BLACK);
                } else {
                    MatteBorder border = new MatteBorder(0, 0, 3, 3, Color.BLACK);
                }
            }
        }
        return border;
    }
}
