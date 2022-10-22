import java.util.List;

public class Main {
    public static void main(String[] args) {
        Text text = new Text("Я читаю книгу в библиотеке", "абвжикосуя");

        int[][] arr = {
                {1, 2, 3, 5},
                {2, 7, 25, 66},
                {1, 5}
        };

        Matrix matrix = new Matrix(arr);
        Matrix newMatrix = matrix.convertToSymbols();

        System.out.println("1 задание: " + text.getCountSingleLetterWords().length);
        System.out.println("2 задание: " + text.getTextWithoutSingleLetterWords());
        System.out.println("3 задание: " + text.getLongestWord());

        System.out.println("4 задание:\nСам массив:");
        matrix.print();
        System.out.println("\nИзменённый массив");
        newMatrix.printSymbols();
    }
}