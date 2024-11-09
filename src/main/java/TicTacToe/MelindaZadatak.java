package TicTacToe;

public class MelindaZadatak {
    public static final String DELIMITER_LINE = " +---+---+---+";
    public static final String DELIMITER_SYMBOL = " | ";
    public static final char EMPTY_CHAR = ' ';
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';

    // Variables for coordinates
    public static char row1col1 = EMPTY_CHAR;
    public static char row1col2 = EMPTY_CHAR;
    public static char row1col3 = EMPTY_CHAR;
    public static char row2col1 = EMPTY_CHAR;
    public static char row2col2 = EMPTY_CHAR;
    public static char row2col3 = EMPTY_CHAR;
    public static char row3col1 = EMPTY_CHAR;
    public static char row3col2 = EMPTY_CHAR;
    public static char row3col3 = EMPTY_CHAR;

    public static char currentPlayer = PLAYER_X;

    public static void main(String[] args) {
        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + " : ");

            String input = System.console().readLine();
            int userCoordinates;

            try {
                userCoordinates = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a two-digit number (11 to 33).");
                continue;
            }

            if (isOutsideBoard(userCoordinates)) {
                System.out.println("Invalid move! (" + userCoordinates + "  is outside the board)");
                continue;
            }
            if (isOccupied(userCoordinates)) {
                System.out.println("Invalid move! (" + userCoordinates + "  is occupied)");
                continue;
            }

            makeMove(userCoordinates);
            if (getWinner() != EMPTY_CHAR) {
                printBoard();
                System.out.println("Congratulations, " + getWinner() + " won!");
                break;
            }
            if (boardIsFull()) {
                printBoard();
                System.out.println("It's a tie!");
                break;
            }
            switchPlayer();
        }
    }

    public static void makeMove(int userCoordinates) {
        switch (userCoordinates) {
            case 11 -> row1col1 = currentPlayer;
            case 12 -> row1col2 = currentPlayer;
            case 13 -> row1col3 = currentPlayer;
            case 21 -> row2col1 = currentPlayer;
            case 22 -> row2col2 = currentPlayer;
            case 23 -> row2col3 = currentPlayer;
            case 31 -> row3col1 = currentPlayer;
            case 32 -> row3col2 = currentPlayer;
            case 33 -> row3col3 = currentPlayer;
        }
    }

    public static boolean isOccupied(int userCoordinates) {
        return switch (userCoordinates) {
            case 11 -> row1col1 != EMPTY_CHAR;
            case 12 -> row1col2 != EMPTY_CHAR;
            case 13 -> row1col3 != EMPTY_CHAR;
            case 21 -> row2col1 != EMPTY_CHAR;
            case 22 -> row2col2 != EMPTY_CHAR;
            case 23 -> row2col3 != EMPTY_CHAR;
            case 31 -> row3col1 != EMPTY_CHAR;
            case 32 -> row3col2 != EMPTY_CHAR;
            case 33 -> row3col3 != EMPTY_CHAR;
            default -> true;
        };
    }

    public static boolean boardIsFull() {
        return row1col1 != EMPTY_CHAR && row1col2 != EMPTY_CHAR && row1col3 != EMPTY_CHAR &&
                row2col1 != EMPTY_CHAR && row2col2 != EMPTY_CHAR && row2col3 != EMPTY_CHAR &&
                row3col1 != EMPTY_CHAR && row3col2 != EMPTY_CHAR && row3col3 != EMPTY_CHAR;
    }

    public static char getWinner() {
        // Horizontal, vertical, and diagonal checks
        if (row1col1 == currentPlayer && row1col2 == currentPlayer && row1col3 == currentPlayer) return currentPlayer;
        if (row2col1 == currentPlayer && row2col2 == currentPlayer && row2col3 == currentPlayer) return currentPlayer;
        if (row3col1 == currentPlayer && row3col2 == currentPlayer && row3col3 == currentPlayer) return currentPlayer;

        if (row1col1 == currentPlayer && row2col1 == currentPlayer && row3col1 == currentPlayer) return currentPlayer;
        if (row1col2 == currentPlayer && row2col2 == currentPlayer && row3col2 == currentPlayer) return currentPlayer;
        if (row1col3 == currentPlayer && row2col3 == currentPlayer && row3col3 == currentPlayer) return currentPlayer;

        if (row1col1 == currentPlayer && row2col2 == currentPlayer && row3col3 == currentPlayer) return currentPlayer;
        if (row1col3 == currentPlayer && row2col2 == currentPlayer && row3col1 == currentPlayer) return currentPlayer;

        return EMPTY_CHAR;
    }

    public static boolean isOutsideBoard(int inputCoordinate) {
        return inputCoordinate < 11 || inputCoordinate > 33 || (inputCoordinate % 10 > 3) || (inputCoordinate / 10 > 3);
    }

    public static void printBoard() {
        System.out.println(DELIMITER_LINE);
        System.out.println(DELIMITER_SYMBOL + row1col1 + DELIMITER_SYMBOL + row1col2 + DELIMITER_SYMBOL + row1col3 + DELIMITER_SYMBOL);
        System.out.println(DELIMITER_LINE);
        System.out.println(DELIMITER_SYMBOL + row2col1 + DELIMITER_SYMBOL + row2col2 + DELIMITER_SYMBOL + row2col3 + DELIMITER_SYMBOL);
        System.out.println(DELIMITER_LINE);
        System.out.println(DELIMITER_SYMBOL + row3col1 + DELIMITER_SYMBOL + row3col2 + DELIMITER_SYMBOL + row3col3 + DELIMITER_SYMBOL);
        System.out.println(DELIMITER_LINE);
    }

    public static void switchPlayer() {
        if (currentPlayer == PLAYER_X) {
            currentPlayer = PLAYER_O;
        } else {
            currentPlayer = PLAYER_X;
        }
    }
}
