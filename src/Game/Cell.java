package Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cell extends JButton implements ActionListener{
    private boolean flagged;
    private String content = "0";

    public Cell(){
        this.flagged = false;
        imageSetter("closed");
        addActionListener(this);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
                    rightMouse();
                }
            }
        });
    }

    private void rightMouse(){
        this.flagged = !flagged;
        
        if(this.flagged == true)
            imageSetter("flagged");
        else
            imageSetter("closed");
    }

    public void imageSetter(String img){
        setIcon(new ImageIcon(getClass().getResource("img/" + img + ".png")));
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getFlagged() {
        return flagged;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cellOpen();
    }

    public void cellOpen(){
        imageSetter(this.content);
//        setEnabled(false);
    }
}