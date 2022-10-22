import java.util.ArrayList;
import java.util.List;

public class Text {
    public final String text;
    private final String alphabet;

    public Text(String text) {
            this(text,"абвжикосуя");
        }

    public Text(String text, String alphabet) {
        this.text = text;
        this.alphabet = alphabet.toUpperCase() + alphabet;
    }

    public String getText() {
        return text;
    }

    public String[] getCountSingleLetterWords() {
        if (text.isEmpty()) {
            return new String[]{""};
        }

        List<String> singleWords = new ArrayList<String>();
        for(int i = 0; i < alphabet.length(); i++) {
            if (text.charAt(0) == alphabet.charAt(i) && (text.charAt(1) == ' ' || text.charAt(1) == ',' ||
                    text.charAt(1) == '.')) {
                singleWords.add(text.charAt(0)+"");
            } else if (text.charAt(text.length() - 1) == alphabet.charAt(i) && (text.charAt(text.length() - 2) == ' ' ||
                    text.charAt(text.length() - 2) == ',' || text.charAt(text.length() - 2) == '.')) {
                singleWords.add(text.charAt(text.length() - 1)+"");
            }
        }

        for(int i = 1; i < text.length() - 1; i++) {
            for(int j = 0; j < alphabet.length(); j++) {
                if (text.charAt(i) == alphabet.charAt(j) &&
                        (text.charAt(i - 1) == ' ' || text.charAt(i - 1) == ',' || text.charAt(i - 1) == '.') &&
                        (text.charAt(i + 1) == ' ' || text.charAt(i + 1) == ',' || text.charAt(i + 1) == '.')) {
                    singleWords.add(text.charAt(i)+"");
                }
            }
        }

        return singleWords.toArray(new String[0]);
    }

    public String getTextWithoutSingleLetterWords() {
        if (text.isEmpty()) {
            return "(Ошибка! Введён пустой текст)";
        }

        String str = text;

        for (int i = 0; i < alphabet.length(); i++) {
            if (str.charAt(0) == alphabet.charAt(i) && str.charAt(1) == ' ') {
                str = str.replace(alphabet.charAt(i) + " ", "");
            } else if (str.charAt(str.length() - 1) == alphabet.charAt(i) && str.charAt(str.length() - 2) == ' ') {
                str = str.replace(" " + alphabet.charAt(i), "");
            }
        }

        for(int i = 1; i < str.length() - 1; i++) {
            for(int j = 0; j < alphabet.length(); j++) {
                if (str.charAt(i) == alphabet.charAt(j) &&
                        (str.charAt(i - 1) == ' ' || str.charAt(i - 1) == ',' || str.charAt(i - 1) == '.') &&
                        (str.charAt(i + 1) == ' ' || str.charAt(i + 1) == ',' || str.charAt(i + 1) == '.')) {
                    str = str.substring(0, i-1) + str.substring(i+1);
                }
            }
        }

        return str;
    }

    public String getLongestWord() {
        if (text.isEmpty()) {
            return "(Ошибка! Введён пустой текст)";
        }

        int count = 0;
        int maxCount = 0;
        int index = 0;
        int maxIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ' && text.charAt(i) != '.' && text.charAt(i) != ',') {
                count++;

                if (count == 1) {
                    index = i;
                }

                if (maxCount < count) {
                    maxIndex = index;
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }

        return text.substring(maxIndex, maxIndex + maxCount);
    }
}
