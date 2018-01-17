public class Language {
    public static int vowelCount(String s) {
        if (s == null || s == "") {
            return 0;
        }
        else {
            int count = 0;
            for (char c : s.toCharArray()) {
                if (isVowel(c)) {
                    count++;
                }
            }
            return count;
        }
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'u' || c == 'o' || c == 'e' || c == 'i';
    }
}
