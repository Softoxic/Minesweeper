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

    
    public void cellAction(){
        this.open = !this.open;
        // setEnabled(false);
        imageSetter(this.content);

        if(this.content == "mined"){
            Game.getGame().setCurMineNum(Game.getGame().getCurMineNum() - 1);
            System.out.println("Number of available Mines ->" + Game.getGame().getCurMineNum());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!this.open){
            //  if it's closed set it as opened after click
            cellAction();
        }
    }
}