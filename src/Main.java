public class Main {
    public static void main(String[] args) {
        System.out.println("ØVING 7 OPPGAVE 2");
        Proc text = new Proc("ab ab abbbb! bag b b. b b b.");
        System.out.println(text.getAmountOfWords());
        System.out.println(text.getAvgWordLength());
        System.out.println(text.getAvgAmountOfWordsPerPeriod());
        System.out.println(text.getText());
        text.replaceWordInText("bag", "æææ");
        System.out.println(text.getText());
        System.out.println(text.getTextUpper());
    }
}