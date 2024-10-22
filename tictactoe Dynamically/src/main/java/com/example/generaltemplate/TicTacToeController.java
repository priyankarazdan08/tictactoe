package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TicTacToeController {

    @FXML
    public Label lblDisplay;

    @FXML
    public TextField txtInput;
    public GridPane gpane;
    private FileInputStream oo, xx, backk;
    private Image o, x, back;
    private ImageView[][] board;//= new ImageView[10][5];
    private int[][] boardData = new int[3][3];
    @FXML
    public void handleClick(ActionEvent actionEvent) {
        board= new ImageView[10][5];
//        gpane.setHgap(10);
//        gpane.setVgap(10);
//        gpane.setPadding(new Insets(10));
//
//        gpane.setAlignment(Pos.CENTER);
//        board[0][0] = new ImageView();
//        board[0][0].setImage(x);
//        board[0][0].setFitHeight(50);
//        board[0][0].setFitWidth(50);
//        gpane.add(board[0][0],0,0);
//        board[0][1] = new ImageView();
//        board[0][1].setImage(x);
//        gpane.add(board[0][1],1,0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new ImageView();
                board[i][j].setImage(back);
                board[i][j].setFitHeight(50);
                board[i][j].setFitWidth(50);
                gpane.add(board[i][j],j,i);
//                boardData[i][j]=2;
            }
        }
        gpane.setGridLinesVisible(true);
        EventHandler z =new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                System.out.println("test");
//                System.out.println(event.getSource());
//                ImageView temp =  (ImageView) event.getSource();
//                temp.setImage(x);
                row = GridPane.getRowIndex((ImageView) event.getSource());
                col = GridPane.getColumnIndex((ImageView) event.getSource());
                System.out.println(row + "," + col);
                board[row][col].setImage(x);
            }
        };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j].setOnMouseClicked(z);
            }
        }

    }
    private int row,col;
    public TicTacToeController(){
        try{
            oo = new FileInputStream("src/main/resources/Pictures/o.png");
            o =new Image(oo);
            xx = new FileInputStream("src/main/resources/Pictures/x.png");
            x = new Image(xx);
            backk = new FileInputStream("src/main/resources/Pictures/liteYellow.png");
            back = new Image(backk);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}