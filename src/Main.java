import java.util.Scanner;
import roman.IntegerToRoman;

public class Main {
public static void main(String[] args) {
    String operation = null;
    String a,b;

    String input;

    Scanner scanner = new Scanner(System.in);
    input = scanner.nextLine();

    String[] splitStr = input.split(" ");

    if (splitStr.length != 3)
    {
        throw new RuntimeException("Ввод не соответсвует формату: a + b");
    }

    a = splitStr[0];
    operation = splitStr[1];
    b = splitStr[2];

    int value1 = 0;
    int value2 = 0;
    Boolean isRomanA = false;
    Boolean isRomanB = false;

    try
    {
        value1 = Integer.parseInt(a);

    } catch (NumberFormatException nfe) {
        isRomanA = true;
    }
    try
    {
        value2 = Integer.parseInt(b);

    } catch (NumberFormatException nfe) {
        isRomanB = true;
    }

    if (isRomanA != isRomanB)
    {
        throw new RuntimeException("Разные системы");
    }

    if (isRomanA)
    {
        value1 = IntegerToRoman.RomanToInt(a);
        value2 = IntegerToRoman.RomanToInt(b);
    }
    if ((value1 >= 0 && value1 <= 10) && (value2 > 0 && value2 <= 10))
    {
        int result;
        if (operation.equals("+")) {
            result = value1 + value2;
        } else if (operation.equals("-")) {
            result = value1 - value2;
        } else if (operation.equals("*")) {
            result = value1 * value2;
        } else if (operation.equals("/")) {
            result = value1 / value2;
        } else {
            throw new RuntimeException("Неверная операция");
        }
        if (isRomanA)
        {
            if(result < 1)
            {
                throw new RuntimeException("В римской системе нет отрицательных чисел");
            }

            String resultR = IntegerToRoman.intToRoman(result);
            System.out.println(resultR);
            return;
        }
        System.out.println(result);
    }
    else
    {
        throw new RuntimeException("Калькулятор принимает числа только от 0 до 10");
    }
}
}
