import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sudoku1Main extends JFrame {

    class Tile extends JButton {
        int r, c;

        Tile(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    JPanel textPanel = new JPanel();
    JLabel textLabel = new JLabel();
    JPanel buttonsPanel = new JPanel();
    JPanel gridPanel = new JPanel();
    JButton numSelected=new JButton();
    String[] puzzle = {
            "--74916-5",
            "2---6-3-9",
            "-----7-1-",
            "-586----4",
            "--3----9-",
            "--62--187",
            "9-4-7---2",
            "67-83----",
            "81--45---"
    };

    String[] solution = {
            "387491625",
            "241568379",
            "569327418",
            "758619234",
            "123784596",
            "496253187",
            "934176852",
            "675832941",
            "812945763"
    };
    int score=0;

    Sudoku1Main() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Sudoku Game");
        this.setLocationRelativeTo(null);
        this.setSize(600, 700);
        this.setLayout(new BorderLayout());

        textLabel.setText("Sudoku Puzzle");
        textLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel, BorderLayout.CENTER);
        this.add(textPanel, BorderLayout.NORTH);


        gridPanel.setLayout(new GridLayout(9, 9));
        this.add(gridPanel, BorderLayout.CENTER);


        buttonsPanel.setLayout(new GridLayout(1, 9));
        this.add(buttonsPanel, BorderLayout.SOUTH);

        setUpTiles();
        setUpButtons();

        this.setVisible(true);
    }

    void setUpTiles() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                Tile tile = new Tile(r, c);
                char ch = puzzle[r].charAt(c);
                tile.setFont(new Font("Arial", Font.BOLD, 20));
                if (ch != '-') {
                    tile.setText(String.valueOf(ch));
                    tile.setBackground(Color.LIGHT_GRAY);
                } else {
                    tile.setBackground(Color.WHITE);

                }
                gridPanel.add(tile);
                tile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Tile tile=(Tile) e.getSource();
                        int r=tile.r;
                        int c=tile.c;
                        String selected=numSelected.getText();
                        String tileSolution= String.valueOf(solution[r].charAt(c));
                        if(selected.equals(tileSolution)){
                            tile.setText(selected);
                        }
                        else{
                        score++;
                        textLabel.setText("Sudoku :-"+score);
                        }
                    }
                });

            }
        }
    }

    void setUpButtons() {
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setFocusable(false);
            buttonsPanel.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button=(JButton)  e.getSource();
                    if (numSelected != null) {
                        numSelected.setBackground(Color.white);
                    }
                    numSelected = button;
                    numSelected.setBackground(Color.lightGray);
                }
            });
        }
    }

    public static void main(String[] args) {
        new Sudoku1Main();
    }
}
