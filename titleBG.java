package packman;

import javax.swing.*;

import java.awt.*;
import java.util.*;

public class titleBG extends Level  {
    Image title;
    
    public titleBG() { 
      Toolkit kit = Toolkit.getDefaultToolkit();
      title = kit.getImage("title.jpg");
      level=1;
      
    }

    public void paintLevel(Graphics2D g, JPanel p) {
      g.drawImage(title, 0, 0, p);
    }


    
}
