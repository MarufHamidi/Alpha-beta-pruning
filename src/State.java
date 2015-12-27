
import java.util.Arrays;

/**
 * @author maruf
 */
public class State {

    public static enum Player {

        MAX, MIN, NONE
    }

    class NotTerminalStateException extends Exception {

        public NotTerminalStateException() {
            super();
        }
    }

    class Action {

        public int[] board;
        public int value;

        public Action(int[] b, int v) {
            board = new int[9];
            System.arraycopy(b, 0, this.board, 0, b.length);
            this.value = v;
        }
    }

    public static final int minusInf = -9;
    public static final int plusInf = 9;
    public static int count;

    // tracing the turns
    // even -- ai agent "X" 1 MAX
    // odd -- opponent "O" -1 MIN
    private Player turn;
    public Player winner;
    private boolean found;
    public int[] nextAction;
    public State parent;
    public State goal;

    // linear representation of 2-D array
    private int[] board;
    private int blankCount;

    public State(State p, Player t) {
        //initially no one is winner
        this.parent = p;
        found = false;
        winner = Player.NONE;
        this.turn = t;
        blankCount = 9;
        board = new int[9];
        // initially all blank n.e. 0
        for (int i = 0; i < 9; i++) {
            board[i] = 0;
        }

        nextAction = new int[9];
    }

    public State(State p, int[] v, Player t) {
        this.parent = p;
        found = false;
        winner = Player.NONE;
        this.turn = t;
        board = new int[9];
        blankCount = 0;
        for (int i = 0; i < 9; i++) {
            this.board[i] = v[i];
            if (this.board[i] == 0) {
                blankCount++;
            }
        }

        nextAction = new int[9];
    }

    public Player player() {
        return turn;
    }

    public void setValue(int index, int value) {
        if (value == 0) {
            this.blankCount++;
        }
        if (this.board[index] == 0) {
            this.blankCount--;
        }
        this.board[index] = value;
    }

    public int getValue(int index) {
        return this.board[index];
    }

    public int[] getValues() {
        return this.board;
    }

    public Action[] actions() {

        int n = 0;
        if (this.turn == Player.MAX) {
            n = 1;
        } else if (this.turn == Player.MIN) {
            n = -1;
        }

        Action[] moves;
        moves = new Action[blankCount];
        for (int i = 0, j = 0; i < 9; i++) {
            if (this.board[i] == 0) {
                moves[j] = new Action(this.board, 0);
                moves[j].board[i] = n;
                j++;
            }
        }
        return moves;
    }

    public State result(Action move) {
        if (this.player() == Player.MAX) {
            return new State(this, move.board, Player.MIN);
        } else {
            return new State(this, move.board, Player.MAX);
        }
    }

    private void checkVerticals() {
        found = false;
        // searching for ai agent "X" all 1
        for (int i = 0; i < 3; i++) {
            if (found) {
                break;
            }
            found = true;
            for (int j = i; j < 9; j = j + 3) {
                if (board[j] != 1) {
                    found = false;
                    break;
                }
            }
        }

        if (found) {
            winner = Player.MAX;
            return;
        }

        // searching for ai agent "X" all 1
        for (int i = 0; i < 3; i++) {
            if (found) {
                break;
            }
            found = true;
            for (int j = i; j < 9; j = j + 3) {
                if (board[j] != -1) {
                    found = false;
                    break;
                }
            }
        }

        if (found) {
            winner = Player.MIN;
            return;
        }
    }

    private void checkHorizontals() {
        found = false;
        for (int i = 0; i < 9; i = i + 3) {
            if (found) {
                break;
            }
            found = true;
            for (int j = i; j < (i + 3); j++) {
                if (board[j] != 1) {
                    found = false;
                    break;
                }
            }
        }
        if (found) {
            winner = Player.MAX;
            return;
        }

        /////////////////////////////////////
        for (int i = 0; i < 9; i = i + 3) {
            if (found) {
                break;
            }
            found = true;
            for (int j = i; j < (i + 3); j++) {
                if (board[j] != -1) {
                    found = false;
                    break;
                }
            }
        }
        if (found) {
            winner = Player.MIN;
            return;
        }
    }

    private void checkDiagonals() {
        found = true;
        for (int i = 0; i < 9; i = i + 4) {
            if (board[i] != 1) {
                found = false;
                break;
            }
        }

        if (found) {
            winner = Player.MAX;
            return;
        }

        found = true;
        for (int i = 2; i < 7; i = i + 2) {
            if (board[i] != 1) {
                found = false;
                break;
            }
        }
        if (found) {
            winner = Player.MAX;
            return;
        }

        found = true;
        for (int i = 0; i < 9; i = i + 4) {
            if (board[i] != -1) {
                found = false;
                break;
            }
        }

        if (found) {
            winner = Player.MIN;
            return;
        }

        found = true;
        for (int i = 2; i < 7; i = i + 2) {
            if (board[i] != -1) {
                found = false;
                break;
            }
        }
        if (found) {
            winner = Player.MIN;
            return;
        }
    }

    public boolean terminalTest() {
        checkVerticals();
        if (found) {
            return found;
        }
        checkHorizontals();
        if (found) {
            return found;
        }
        checkDiagonals();
        if (found) {
            return found;
        }
        if (this.blankCount == 0) {
            return true;
        }
        return found;
    }

    public int utility() throws NotTerminalStateException {
        boolean t = this.terminalTest();
        if (!t) {
            throw new NotTerminalStateException();
        } else {
            if (this.winner == Player.MAX) {
                return 1;
            } else if (this.winner == Player.MIN) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public void printState() {
        for (int i = 0, k = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++, k++) {
                System.out.print("  " + board[k]);
            }
            System.out.println("");
        }
        System.out.println("---------------------");
    }
    
    private Action iMax(){
        State test;
        Action[] act = this.actions();        
        int critical = -9;
        boolean tt;
        for (int i = 0; i < act.length; i++) {
            test = new State(null, act[i].board, Player.MAX);
            tt = test.terminalTest();
            if (tt && test.winner == Player.MAX) {
                critical = i;
                break;
            }
        }

        for (int n = 0, c = -1; n < 9; n++) {
            if (this.board[n] == 0) {
                c++;
            }
            if (c == critical) {
                this.board[n] = 1;
                return new Action(this.board, 0);
            }
        }
        
        this.turn = Player.MAX;
        return null;
    }

    private Action resistMin() {
        this.turn = Player.MIN;
        State test;
        Action[] act = this.actions();        
        int critical = -9;
        boolean tt;
        for (int i = 0; i < act.length; i++) {
            test = new State(null, act[i].board, Player.MAX);
            tt = test.terminalTest();
            if (tt && test.winner == Player.MIN) {
                critical = i;
                break;
            }
        }

        for (int n = 0, c = -1; n < 9; n++) {
            if (this.board[n] == 0) {
                c++;
            }
            if (c == critical) {
                this.board[n] = 1;
                return new Action(this.board, 0);
            }
        }
        
        this.turn = Player.MAX;
        return null;
    }
    
    public Action alphaBetaSearch() throws NotTerminalStateException {
        
        Action imax = this.iMax();
        if (imax != null) {            
            return imax;
        }
        
        Action resistAction = this.resistMin();
        if (resistAction != null) {
            return resistAction;
        }
        
        goal = this;
        
        int v = maxValue(this, State.minusInf, State.plusInf);

        if (goal.parent == null) {
            return new Action(goal.board, v);
        }

        State temp = goal;
        while (temp.parent.parent != null) {
            temp = temp.parent;
        }
        return new Action(temp.board, 0);
    }

    public int maxValue(State s, int alpha, int beta) throws NotTerminalStateException {
        if (s.terminalTest()) {
            if (s.winner == Player.MAX) {
                goal = s;
            }else if(s.winner == Player.NONE){
                goal = s;
            }
            return s.utility();
        }

        int v = State.minusInf;
        for (Action action : s.actions()) {
            s.turn = Player.MIN;
            v = Math.max(v, minValue(s.result(action), alpha, beta));
            if (v >= beta) {
                return v;
            }
            alpha = Math.max(alpha, v);
        }
        return v;
    }

    public int minValue(State s, int alpha, int beta) throws NotTerminalStateException {
        if (s.terminalTest()) {
            if (s.winner == Player.MAX) {
                goal = s;
            }else if(s.winner == Player.NONE){
                goal = s;
            }
            return s.utility();
        }

        int v = State.plusInf;
        for (Action action : s.actions()) {
            s.turn = Player.MAX;
            v = Math.min(v, maxValue(s.result(action), alpha, beta));
            action.value = v;
            if (v <= alpha) {
                return v;
            }
            beta = Math.min(beta, v);
        }
        return v;
    }

    public static void main(String[] args) throws NotTerminalStateException {
        State s = new State(null, Player.MAX);

        for (int i = 0; i < 9; i++) {
            s.setValue(i, 0);
        }

        s.setValue(0, -1);
        s.setValue(1, 1);
        s.setValue(2, 0);
        s.setValue(3, 1);
        s.setValue(4, -1);
        s.setValue(5, -1);
        s.setValue(6, 1);
        s.setValue(7, -1);
        s.setValue(8, 1);
        s.printState();

//        Action act = s.resistMin();
        
        Action act = s.alphaBetaSearch();
        State n = new State(null, act.board, Player.MIN);
        n.printState();
    }
}
