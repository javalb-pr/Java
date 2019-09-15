import by.gsu.pms.Lexeme;
import by.gsu.pms.Sentence;
import by.gsu.pms.Text;
import by.gsu.pms.Word;

import java.io.File;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        final String FILE_PATH = "src/in.txt";
        Map<Lexeme, Integer> wordWithVowels = new HashMap<>();

        Text text = new Text(new File(FILE_PATH));
        System.out.println(text);

        for (Sentence sentence : text.getSentences()){
            for (Lexeme lexeme : sentence.getLexemes()){
                if (lexeme instanceof Word){
                    //System.out.println(lexeme);
                    wordWithVowels.put(lexeme, vowelsConuter(lexeme));
                }
            }
        }
        List<Map.Entry<Lexeme, Integer>> list = new ArrayList<>(wordWithVowels.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Map<Lexeme, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Lexeme, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    private static int vowelsConuter(Lexeme word){
        Set<String> vowels = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u", "y",
                "A", "E", "I", "O", "U", "Y"));
        int vowelsCounter = 0;

        for (String subString : word.getLexeme().split("")){
            if (vowels.contains(subString)){
                vowelsCounter++;
            }
        }

        return vowelsCounter;
    }
}
