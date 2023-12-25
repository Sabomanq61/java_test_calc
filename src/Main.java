import java.util.Scanner;
import roman.IntegerToRoman;

public class Main {
public static void main(String[] args) {
    String operation = null;

    Scanner scanner = new Scanner(System.in);
    String a,b;

    a = scanner.next();
    operation = scanner.next();
    b = scanner.next();

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
            if(result < 0)
            {
                throw new RuntimeException("В римской системе нет отрицательных чисел");
            }
            String resultR = IntegerToRoman.intToRoman(result);
            System.out.println(resultR);
            return;
        }
        System.out.println(result);
    }
}
}
