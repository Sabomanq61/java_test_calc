package roman;

public class IntegerToRoman {
    public static String intToRoman(int num)
    {
        int[] values = {10,9,5,4,1};
        String[] romanLetters = {"X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++)
        {
            while(num >= values[i])
            {
                num = num - values[i];
                roman.append(romanLetters[i]);
            }
        }
        return roman.toString();
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
