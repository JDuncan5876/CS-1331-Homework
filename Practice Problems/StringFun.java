import java.util.StringTokenizer;
public class StringFun {
    public void getWord(char character, String sentence) {
        StringTokenizer tokens = new StringTokenizer(sentence);
        while (tokens.hasMoreTokens()) {
            String word = tokens.nextToken();
            if (word.contains(character + "")) {
                System.out.println(word);
            }
        }
    }

	public static void main(String[] args) {
		StringFun sf = new StringFun();
        sf.getWord('a', "I have a large amount of work to do today.");
	}
}