import java.util.Objects;

public class Proc {
    private final char[] alphabet = "abcdefghijklmnopqrstuvwxyzæøå".toCharArray();
    private final char[] seperationSigns = ".!?:".toCharArray();
    private String text;
    private char[] textAsList;
    private int amountOfWords;
    private double avgWordLength;
    private double avgAmountOfWordsPerPeriod;

    public Proc(String input) {
        this.text = input;
        this.textAsList = text.toCharArray();
        this.setAmountOfWords();
        this.setAvgWordLength();
        this.setAvgAmountOfWordsPerPeriod();
    }
    private void setAmountOfWords() {
        this.amountOfWords = this.text.split(" ").length;
    }

    private void setAvgWordLength() {
        int charCount = 0;

        for (char sign : this.textAsList) {
            for (char letter : alphabet) {
                if (sign == letter) {
                    charCount++;
                }
            }
        }
        this.avgWordLength = (double) charCount / this.amountOfWords;
    }

    private void setAvgAmountOfWordsPerPeriod() {
        int periodCount = 0;
        for (char sign : textAsList) {
            for (char seperator : seperationSigns) {
                if (sign == seperator) {
                    periodCount++;
                }
            }
        }

        this.avgAmountOfWordsPerPeriod = (double) amountOfWords / periodCount;
    }
    public void replaceWordInText(String word, String replacement) {
        String[] textSeperated = new String[0];
        String insert = "";

        for (char sign : textAsList) {
            for (char letter : alphabet) {
                if (sign == letter) {
                    insert += sign;
                }
            }
            for (char seperator : seperationSigns) {
                if (sign == seperator) {
                    textSeperated = insertToArray(textSeperated, insert);
                    insert = "";
                    textSeperated = insertToArray(textSeperated, sign + "");

                }
            }
            if (sign == ' ') {
                textSeperated = insertToArray(textSeperated, insert);
                insert = "";
                textSeperated = insertToArray(textSeperated, sign + "");
            }

        }

        for (int i = 0; i < textSeperated.length; i++) {
            if (Objects.equals(textSeperated[i], word)) {
                textSeperated[i] = replacement;
            }
        }

        String updatedText = "";
        for (String item : textSeperated) {
            updatedText += item;
        }

        this.text = updatedText;
        this.textAsList = this.text.toCharArray();
    }

    private static String[] insertToArray(String[] origin, String insert) {
        String[] updated = new String[origin.length + 1];
        System.arraycopy(origin, 0, updated, 0, origin.length);
        updated[origin.length] = insert;

        return updated;
    }

    public double getAvgWordLength() {
        return avgWordLength;
    }

    public int getAmountOfWords() {
        return amountOfWords;
    }

    public double getAvgAmountOfWordsPerPeriod() {
        return avgAmountOfWordsPerPeriod;
    }

    public String getText() {
        return text;
    }

    public String getTextUpper() {
        return text.toUpperCase();
    }
}
