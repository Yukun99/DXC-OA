import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Encoder {
    private final Map<Integer, Character> indexCharMap = new HashMap<>();
    private final Map<Character, Integer> charIndexMap = new HashMap<>();
    private int offset = 0;
    private final Random random = new Random(12345);

    public Encoder() {
        setupIndexValueMap();
        setupValueIndexMap();
        chooseOffset();
    }

    public String encodeString(String plainText) {
        char[] characters = plainText.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char character : characters) {
            stringBuilder.append(getOffsetCharacter(character));
        }
        return stringBuilder.toString();
    }

    public String decodeString(String encodedText) {
        char[] characters = encodedText.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char character : characters) {
            stringBuilder.append(getPlainTextCharacter(character));
        }
        return stringBuilder.toString();
    }

    private void chooseOffset() {
        this.offset = random.nextInt(indexCharMap.size());
    }

    private char getOffsetCharacter(char plainTextCharacter) {
        if (!charIndexMap.containsKey(plainTextCharacter)) {
            return plainTextCharacter;
        }
        int offsetIndex = getOffsetIndex(charIndexMap.get(plainTextCharacter));
        return indexCharMap.get(offsetIndex);
    }

    private int getOffsetIndex(int plainTextIndex) {
        int offsetIndex = plainTextIndex + offset;
        if (offsetIndex >= indexCharMap.size()) {
            offsetIndex -= indexCharMap.size();
        }
        return offsetIndex;
    }

    private char getPlainTextCharacter(char offsetCharacter) {
        if (!charIndexMap.containsKey(offsetCharacter)) {
            return offsetCharacter;
        }
        int plainTextIndex = getPlainTextIndex(charIndexMap.get(offsetCharacter));
        return indexCharMap.get(plainTextIndex);
    }

    private int getPlainTextIndex(int offsetIndex) {
        int plainTextIndex = offsetIndex - offset;
        if (plainTextIndex < 0) {
            plainTextIndex += indexCharMap.size();
        }
        return plainTextIndex;
    }

    private void setupIndexValueMap() {
        indexCharMap.put(0, 'A');
        indexCharMap.put(1, 'B');
        indexCharMap.put(2, 'C');
        indexCharMap.put(3, 'D');
        indexCharMap.put(4, 'E');
        indexCharMap.put(5, 'F');
        indexCharMap.put(6, 'G');
        indexCharMap.put(7, 'H');
        indexCharMap.put(8, 'I');
        indexCharMap.put(9, 'J');
        indexCharMap.put(10, 'K');
        indexCharMap.put(11, 'L');
        indexCharMap.put(12, 'M');
        indexCharMap.put(13, 'N');
        indexCharMap.put(14, 'O');
        indexCharMap.put(15, 'P');
        indexCharMap.put(16, 'Q');
        indexCharMap.put(17, 'R');
        indexCharMap.put(18, 'S');
        indexCharMap.put(19, 'T');
        indexCharMap.put(20, 'U');
        indexCharMap.put(21, 'V');
        indexCharMap.put(22, 'W');
        indexCharMap.put(23, 'X');
        indexCharMap.put(24, 'Y');
        indexCharMap.put(25, 'Z');
        indexCharMap.put(26, '0');
        indexCharMap.put(27, '1');
        indexCharMap.put(28, '2');
        indexCharMap.put(29, '3');
        indexCharMap.put(30, '4');
        indexCharMap.put(31, '5');
        indexCharMap.put(32, '6');
        indexCharMap.put(33, '7');
        indexCharMap.put(34, '8');
        indexCharMap.put(35, '9');
        indexCharMap.put(36, '(');
        indexCharMap.put(37, ')');
        indexCharMap.put(38, '*');
        indexCharMap.put(39, '+');
        indexCharMap.put(40, ',');
        indexCharMap.put(41, '-');
        indexCharMap.put(42, '.');
        indexCharMap.put(43, '/');
    }

    private void setupValueIndexMap() {
        for (int key : indexCharMap.keySet()) {
            charIndexMap.put(indexCharMap.get(key), key);
        }
    }
}
