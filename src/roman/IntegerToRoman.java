package roman;

public class IntegerToRoman {
    public static String intToRoman(int number)
    {
        String[] hundreds = {"", "C"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return  hundreds[(number % 1000) / 100] + tens[(number % 100) / 10] + units[number % 10];
    }
    public static int RomanToInt(String roman)
    {
        int ans = 0, num = 0;
        for (int i = roman.length()-1; i >= 0; i--) {
            switch(roman.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }
}
