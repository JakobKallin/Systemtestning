public class Refactoring {
    public static String changeString(String before) {
        String after = removeSpaces(before);
        String after2 = removeDots(after);

        String after3 = "";
        for (char c : after2.toCharArray()) {
            after3 += c + ",";
        }

        return after3;
    }

    private static String removeSpaces(String before) {
        return removeChar(before, ' ');
    }

    private static String removeDots(String before) {
        return removeChar(before, '.');
    }

    private static String removeChar(String before, char remove) {
        String after = "";
        for (char c : before.toCharArray()) {
            if (c != remove) {
                after += c;
            }
        }
        return after;
    }
}
