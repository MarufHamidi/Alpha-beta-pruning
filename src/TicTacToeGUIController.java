/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author maruf
 */
public class TicTacToeGUIController implements Initializable {

    public Main app;
    public State board;

    @FXML
    private Button button0, button1, button2,
            button3, button4, button5,
            button6, button7, button8;

    @FXML
    private Label statusLabel, winnerLabel;

    private ArrayList<Button> buttonList;

    @FXML
    public void onClickButton0(ActionEvent event) {
        board.setValue(0, -1);
        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );

        board = new State(null, board.getValues(), State.Player.MAX);
        try {
            board = board.result(board.alphaBetaSearch());
        } catch (State.NotTerminalStateException ex) {
            Logger.getLogger(TicTacToeGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );
    }

    @FXML
    public void onClickButton1(ActionEvent event) {
        board.setValue(1, -1);
        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );

        board = new State(null, board.getValues(), State.Player.MAX);
        try {
            board = board.result(board.alphaBetaSearch());
        } catch (State.NotTerminalStateException ex) {
            Logger.getLogger(TicTacToeGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );

    }

    @FXML
    public void onClickButton2(ActionEvent event) {
        board.setValue(2, -1);
        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );

        board = new State(null, board.getValues(), State.Player.MAX);
        try {
            board = board.result(board.alphaBetaSearch());
        } catch (State.NotTerminalStateException ex) {
            Logger.getLogger(TicTacToeGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );
    }

    @FXML
    public void onClickButton3(ActionEvent event) {
        board.setValue(3, -1);
        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );

        board = new State(null, board.getValues(), State.Player.MAX);
        try {
            board = board.result(board.alphaBetaSearch());
        } catch (State.NotTerminalStateException ex) {
            Logger.getLogger(TicTacToeGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );
    }

    @FXML
    public void onClickButton4(ActionEvent event) {
        board.setValue(4, -1);
        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );        
        
        board = new State(null, board.getValues(), State.Player.MAX);
        try {
            board = board.result(board.alphaBetaSearch());
        } catch (State.NotTerminalStateException ex) {
            Logger.getLogger(TicTacToeGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );
    }

    @FXML
    public void onClickButton5(ActionEvent event) {
        board.setValue(5, -1);
        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );        
        
        board = new State(null, board.getValues(), State.Player.MAX);
        try {
            board = board.result(board.alphaBetaSearch());
        } catch (State.NotTerminalStateException ex) {
            Logger.getLogger(TicTacToeGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );
    }

    @FXML
    public void onClickButton6(ActionEvent event) {
        board.setValue(6, -1);
        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );        
        
        board = new State(null, board.getValues(), State.Player.MAX);
        try {
            board = board.result(board.alphaBetaSearch());
        } catch (State.NotTerminalStateException ex) {
            Logger.getLogger(TicTacToeGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );
    }

    @FXML
    public void onClickButton7(ActionEvent event) {
        board.setValue(7, -1);
        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );        
        
        board = new State(null, board.getValues(), State.Player.MAX);
        try {
            board = board.result(board.alphaBetaSearch());
        } catch (State.NotTerminalStateException ex) {
            Logger.getLogger(TicTacToeGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );
    }

    @FXML
    public void onClickButton8(ActionEvent event) {
        board.setValue(8, -1);
        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );        
        
        board = new State(null, board.getValues(), State.Player.MAX);
        try {
            board = board.result(board.alphaBetaSearch());
        } catch (State.NotTerminalStateException ex) {
            Logger.getLogger(TicTacToeGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Platform.runLater(new Runnable() {
            public void run() {
                loadState(board);
            }
        }
        );
    }

    @FXML
    public void onClickRestartButton(ActionEvent event) throws State.NotTerminalStateException {
        board = new State(null, State.Player.MAX);
        board = board.result(board.alphaBetaSearch());

        Platform.runLater(new Runnable() {
            public void run() {
                statusLabel.setText("");
                winnerLabel.setText("");
                loadState(board);
            }
        });
    }

    public void disableButtons() {
        Platform.runLater(new Runnable() {
            public void run() {
                for (int i = 0; i < buttonList.size(); i++) {
                    buttonList.get(i).setDisable(true);
                }
            }
        }
        );
    }

    public void enableButtons() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < buttonList.size(); i++) {
                    buttonList.get(i).setDisable(false);
                }
            }
        }
        );
    }

    public void setApp(Main a) {
        app = a;
    }

    public void loadState(State b) {
        board = b;
        boolean isTerminal = board.terminalTest();
        String winner;
        if (isTerminal && board.winner == State.Player.MAX) {
            winner = "AI Agent";
        } else if (isTerminal && board.winner == State.Player.MIN) {
            winner = "You";
        } else {
            winner = "None (Draw)";
        }

        Platform.runLater(new Runnable() {
            public void run() {
                for (int i = 0; i < 9; i++) {
                    switch (board.getValue(i)) {
                        case 1:
                            buttonList.get(i).setText("X");
                            buttonList.get(i).setDisable(true);
                            break;
                        case -1:
                            buttonList.get(i).setText("O");
                            buttonList.get(i).setDisable(true);
                            break;
                        default:
                            buttonList.get(i).setText("");
                            buttonList.get(i).setDisable(false);
                            break;
                    }
                }

                if (isTerminal) {
                    statusLabel.setText("Winner is : ");
                    winnerLabel.setText(winner);
                    disableButtons();
                }
            }
        }
        );
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        buttonList = new ArrayList<Button>(9);

        buttonList.add(button0);
        buttonList.add(button1);
        buttonList.add(button2);
        buttonList.add(button3);
        buttonList.add(button4);
        buttonList.add(button5);
        buttonList.add(button6);
        buttonList.add(button7);
        buttonList.add(button8);
    }
}
