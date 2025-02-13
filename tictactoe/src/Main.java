import java.util.Scanner;

public class Main {
    static char[][] board = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
    static char turn = 'X'; // x mulai duluan

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tic Tac Toe 3x3");
        printBoard();

        while (true) {
            int x, y;
            System.out.print("Giliran " + turn + ": ");

            // Validasi angka
            if (!sc.hasNextInt()) {
                System.out.println("Input harus angka!");
                sc.next();
                continue;
            }
            x = sc.nextInt() - 1;
            if (!sc.hasNextInt()) {
                System.out.println("Input harus angka!");
                sc.next();
                continue;
            }
            y = sc.nextInt() - 1;

            if (x < 0 || x > 2 || y < 0 || y > 2 || board[x][y] != '-') {
                System.out.println("Koordinat tidak valid, coba lagi.");
                continue;
            }

            // Masukkan simbol ke papan
            board[x][y] = turn;
            printBoard();

            // Cek pemenang
            if (checkWin()) {
                System.out.println("Selamat! " + turn + " menang!");
                break;
            }
            if (isDraw()) {
                System.out.println("Permainan Seri!");
                break;
            }

            // switch
            turn = (turn == 'X') ? 'O' : 'X';
        }

        sc.close();
    }

    static void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean checkWin() {
        // Cek baris & kolom
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == turn && board[i][1] == turn && board[i][2] == turn)
                return true;
            if (board[0][i] == turn && board[1][i] == turn && board[2][i] == turn)
                return true;
        }
        // diagonal
        if (board[0][0] == turn && board[1][1] == turn && board[2][2] == turn)
            return true;
        else if (board[0][2] == turn && board[1][1] == turn && board[2][0] == turn)
            return true;

        return false;
    }

    static boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '-')
                    return false;
        return true;
    }
}
