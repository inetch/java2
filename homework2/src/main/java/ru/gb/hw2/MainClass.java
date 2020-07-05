package ru.gb.hw2;

import ru.gb.hw2.exceptions.*;

import java.util.Scanner;

public class MainClass {
    private static String[][] parseString(String s, int lines, int columns) throws WrongMatrixSizeException {
        String[][] result = new String[lines][columns];

        Scanner scanner = new Scanner(s);
        int line = 0;
        try {
            while (scanner.hasNextLine()) {
                result[line] = scanner.nextLine().split("\\s");
                if(result[line].length != columns){
                    throw new WrongMatrixSizeException();
                }
                line++;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new WrongMatrixSizeException();
        }

        if(line != lines){
            throw new WrongMatrixSizeException();
        }

        return result;
    }

    private static int calcMatrix(String[][] matrix) throws NotDigitalMatrixElementException {
        int result = 0;
        String s = "sdf";
        try {
            for(String[] line: matrix){
                for(int i = 0; i < line.length; i++){
                    s = line[i];
                    result += Integer.parseInt(s);
                }
            }
        } catch (NumberFormatException e){
            throw new NotDigitalMatrixElementException(s, e);
        }

        return result / 2;
    }

    public static void main(String[] args) {
        //String inputString = "10 13 4 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        //String inputString = "10 13 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String inputString = "10 13 wer 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        int x;
        try {
            x = calcMatrix(parseString(inputString, 4, 4));
        } catch (WrongMatrixSizeException e){
            System.out.println("Wrong matrix size");
            System.out.println(e);
            throw new RuntimeException(e);
        } catch (NotDigitalMatrixElementException e){
            System.out.printf("Not digital element in the matrix: %s \n", e.getMessage());
            throw new RuntimeException(e);
        }

        System.out.printf("Result: %d \n", x);

    }
}
