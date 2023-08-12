public class ConvertingCases
{
    public static void main(String[] args)
    {
        System.out.println(conversionCases("hello world"));
    }

    public static StringBuilder conversionCases(String sentence)
    {
        StringBuilder sb = new StringBuilder(sentence);
        for (int i = 0; i < sentence.length(); i++)
        {
            char charIndex = sentence.charAt(i);
            if(Character.isLowerCase(charIndex))
            {
                sb.setCharAt(i, Character.toUpperCase(charIndex));
            }
            else if(Character.isUpperCase(charIndex))
            {
                sb.setCharAt(i, Character.toLowerCase(charIndex));
            }
        }
        return sb;
    }
}
