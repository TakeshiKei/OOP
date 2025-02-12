import java.util.*;

public class TicTacToe {
    static String[][] board = new String[3][3];
    static String turn = "X";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Inisialisasi papan dengan -
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = "-";

        System.out.println("Tic Tac Toe 3x3");
        printBoard();
        System.out.println("X mulai duluan. Masukkan koordinat (baris kolom):");

        String winner = null;
        while (winner == null) {
            int x, y;
            try {
                // Input koordinat
                System.out.print("Giliran " + turn + " : ");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
                
                // validitasi input
                if (x < 0 || x > 2 || y < 0 || y > 2 || !board[x][y].equals("-")) {
                    System.out.println("Koordinat tidak valid, coba lagi:");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid, coba lagi:");
                sc.next();
                continue;
            }

            board[x][y] = turn;
            printBoard();

            // Cek pemenang
            winner = checkWinner();
            if (winner == null) {
                turn = turn.equals("X") ? "O" : "X";
            }
        }

        System.out.println(winner.equals("draw") ? "Permainan Seri!" : "Selamat! " + winner + " menang!");
        sc.close();
    }

    static void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + (j < 2 ? " " : ""));
            }
            System.out.println();
        }
    }

    static String checkWinner() {
        String[][] winPatterns = {
            {board[0][0], board[0][1], board[0][2]}, {board[1][0], board[1][1], board[1][2]}, {board[2][0], board[2][1], board[2][2]},
            {board[0][0], board[1][0], board[2][0]}, {board[0][1], board[1][1], board[2][1]}, {board[0][2], board[1][2], board[2][2]},
            {board[0][0], board[1][1], board[2][2]}, {board[0][2], board[1][1], board[2][0]}
        };
        
        for (String[] line : winPatterns) {
            if (line[0].equals(line[1]) && line[1].equals(line[2]) && !line[0].equals("-")) {
                return line[0]; // menang
            }
        }

        for (String[] row : board)
            for (String cell : row)
                if (cell.equals("-")) return null;

        return "draw"; // tidak ad yg menang
    }
}
