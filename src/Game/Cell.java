package Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cell extends JButton implements ActionListener{
    private boolean flagged, open;
    private String content;

    public Cell(){
        this.flagged = false;
        this.open = false;
        this.content = "0";
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
        if(this.open == false){
            this.flagged = !flagged;
            
            if(this.flagged == true)
                imageSetter("flagged");
            else
                imageSetter("closed");
        }
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
        return this.flagged;
    }

    
    public void cellOpen(){
        imageSetter(this.content);
        //  setEnabled(false);
        this.open = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("this.open" + this.open);
        if(this.open == false){
            cellOpen();
            Game.mineNum--;
            if(Game.lives > 0){
                System.out.println(Game.lives);
                Game.lives--;
            }
            else
                Game.gameOver();
        }
    }
}