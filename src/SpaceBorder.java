import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SpaceBorder {
    public static MatteBorder getSpaceBorder(int z, int y, int x){
        List<Integer> parms = new ArrayList<Integer>();
        if(z == 0) {
            if (x == 0) {
                if (y == 0) {
                    Collections.addAll(parms,3,3,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,3,1,1);
                } else {
                    Collections.addAll(parms,2,3,2,1);
                }
            } else if (x == 1) {
                if (y == 0) {
                    Collections.addAll(parms,3,1,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,1);
                } else {
                    Collections.addAll(parms,1,1,2,1);
                }
            } else {
                if (y == 0) {
                    Collections.addAll(parms,3,1,1,2);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,2);
                } else {
                    Collections.addAll(parms,1,1,2,2);
                }
            }
        } else if(z == 1){
            if (x == 0) {
                if (y == 0) {
                    Collections.addAll(parms,3,2,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,2,1,1);
                } else {
                    Collections.addAll(parms,1,2,2,1);
                }
            } else if (x == 1) {
                if (y == 0) {
                    Collections.addAll(parms,3,1,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,1);
                } else {
                    Collections.addAll(parms,1,1,2,1);
                }
            } else {
                if (y == 0) {
                    Collections.addAll(parms,3,1,1,2);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,2);
                } else {
                    Collections.addAll(parms,1,1,2,2);
                }
            }
        } else if(z == 2){
            if (x == 0) {
                if (y == 0) {
                    Collections.addAll(parms,3,2,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,2,1,1);
                } else {
                    Collections.addAll(parms,1,2,2,1);
                }
            } else if (x == 1) {
                if (y == 0) {
                    Collections.addAll(parms,3,1,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,1);
                } else {
                    Collections.addAll(parms,1,1,2,1);
                }
            } else {
                if (y == 0) {
                    Collections.addAll(parms,3,1,1,3);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,3);
                } else {
                    Collections.addAll(parms,1,1,2,3);
                }
            }
        } else if(z == 3){
            if (x == 0) {
                if (y == 0) {
                    Collections.addAll(parms,2,3,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,3,1,1);
                } else {
                    Collections.addAll(parms,1,3,2,1);
                }
            } else if (x == 1) {
                if (y == 0) {
                    Collections.addAll(parms,2,1,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,1);
                } else {
                    Collections.addAll(parms,1,1,2,1);
                }
            } else {
                if (y == 0) {
                    Collections.addAll(parms,2,1,1,2);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,2);
                } else {
                    Collections.addAll(parms,1,1,2,2);
                }
            }
        } else if(z == 4){
            if (x == 0) {
                if (y == 0) {
                    Collections.addAll(parms,2,2,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,2,1,1);
                } else {
                    Collections.addAll(parms,1,2,2,1);
                }
            } else if (x == 1) {
                if (y == 0) {
                    Collections.addAll(parms,2,1,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,1);
                } else {
                    Collections.addAll(parms,1,1,2,1);
                }
            } else {
                if (y == 0) {
                    Collections.addAll(parms,2,1,1,2);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,2);
                } else {
                    Collections.addAll(parms,1,1,2,2);
                }
            }
        } else if(z == 5){
            if (x == 0) {
                if (y == 0) {
                    Collections.addAll(parms,2,2,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,2,1,1);
                } else {
                    Collections.addAll(parms,1,2,2,1);
                }
            } else if (x == 1) {
                if (y == 0) {
                    Collections.addAll(parms,2,1,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,1);
                } else {
                    Collections.addAll(parms,1,1,2,1);
                }
            } else {
                if (y == 0) {
                    Collections.addAll(parms,2,1,1,3);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,3);
                } else {
                    Collections.addAll(parms,1,1,2,3);
                }
            }
        } else if(z == 6){
            if (x == 0) {
                if (y == 0) {
                    Collections.addAll(parms,2,3,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,3,1,1);
                } else {
                    Collections.addAll(parms,1,3,3,1);
                }
            } else if (x == 1) {
                if (y == 0) {
                    Collections.addAll(parms,2,1,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,1);
                } else {
                    Collections.addAll(parms,1,1,3,1);
                }
            } else {
                if (y == 0) {
                    Collections.addAll(parms,2,1,1,2);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,2);
                } else {
                    Collections.addAll(parms,1,1,3,2);
                }
            }
        } else if(z == 7){
            if (x == 0) {
                if (y == 0) {
                    Collections.addAll(parms,2,2,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,2,1,1);
                } else {
                    Collections.addAll(parms,1,2,3,1);
                }
            } else if (x == 1) {
                if (y == 0) {
                    Collections.addAll(parms,2,1,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,1);
                } else {
                    Collections.addAll(parms,1,1,3,1);
                }
            } else {
                if (y == 0) {
                    Collections.addAll(parms,2,1,1,2);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,2);
                } else {
                    Collections.addAll(parms,1,1,3,2);
                }
            }
        } else{
            if (x == 0) {
                if (y == 0) {
                    Collections.addAll(parms,2,2,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,2,1,1);
                } else {
                    Collections.addAll(parms,1,2,3,1);
                }
            } else if (x == 1) {
                if (y == 0) {
                    Collections.addAll(parms,1,2,1,1);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,1);
                } else {
                    Collections.addAll(parms,1,1,3,1);
                }
            } else {
                if (y == 0) {
                    Collections.addAll(parms,3,1,1,3);
                } else if (y == 1) {
                    Collections.addAll(parms,1,1,1,3);
                } else {
                    Collections.addAll(parms,1,1,3,3);
                }
            }
        }
        return new MatteBorder(parms.get(0), parms.get(1),parms.get(2),parms.get(3),Color.BLACK);
    }
}
