import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Encoder {
    private final Map<Integer, Character> indexCharMap = new HashMap<>();
    private final Map<Character, Integer> charIndexMap = new HashMap<>();
    private int offset = 0;
    private final Random random;

    /**
     * Constructor for Encoder object.
     */
    public Encoder(int seed) {
        random = new Random(seed);
        setupIndexCharMap();
        setupValueIndexMap();
        chooseOffset();
    }

    /**
     * Encode a plainText string.
     *
     * @param plainText Original plainText string.
     * @return Encoded string.
     */
    public String encodeString(String plainText) {
        char[] characters = plainText.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char character : characters) {
            stringBuilder.append(getOffsetCharacter(character));
        }
        return stringBuilder.toString();
    }

    /**
     * Decode an encoded string into the original string.
     *
     * @param encodedText Encoded string.
     * @return Original string.
     */
    public String decodeString(String encodedText) {
        char[] characters = encodedText.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char character : characters) {
            stringBuilder.append(getPlainTextCharacter(character));
        }
        return stringBuilder.toString();
    }

    /**
     * Choose random offset amount from original character.
     */
    private void chooseOffset() {
        offset = random.nextInt(indexCharMap.size());
    }

    /**
     * Get offset character from offset character.
     *
     * @param plainTextCharacter Original character.
     * @return Offset character encoded from original character.
     */
    private char getOffsetCharacter(char plainTextCharacter) {
        if (!charIndexMap.containsKey(plainTextCharacter)) {
            return plainTextCharacter;
        }
        int offsetIndex = getOffsetIndex(charIndexMap.get(plainTextCharacter));
        return indexCharMap.get(offsetIndex);
    }

    /**
     * Get offset character index from original index.
     *
     * @param plainTextIndex Index of original character.
     * @return Index of offset character.
     */
    private int getOffsetIndex(int plainTextIndex) {
        int offsetIndex = plainTextIndex + offset;
        if (offsetIndex >= indexCharMap.size()) {
            offsetIndex -= indexCharMap.size();
        }
        return offsetIndex;
    }

    /**
     * Get original character from offset character.
     *
     * @param offsetCharacter Offset character encoded from original character.
     * @return Original character.
     */
    private char getPlainTextCharacter(char offsetCharacter) {
        if (!charIndexMap.containsKey(offsetCharacter)) {
            return offsetCharacter;
        }
        int plainTextIndex = getPlainTextIndex(charIndexMap.get(offsetCharacter));
        return indexCharMap.get(plainTextIndex);
    }

    /**
     * Get original index from offset character index.
     *
     * @param offsetIndex Index of offset character.
     * @return Index of original character.
     */
    private int getPlainTextIndex(int offsetIndex) {
        int plainTextIndex = offsetIndex - offset;
        if (plainTextIndex < 0) {
            plainTextIndex += indexCharMap.size();
        }
        return plainTextIndex;
    }

    /**
     * Simple setup method for populating reference table with indexes and corresponding characters.
     */
    private void setupIndexCharMap() {
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

    /**
     * Simple setup method for populating reference table with characters and corresponding indexes.
     */
    private void setupValueIndexMap() {
        for (int key : indexCharMap.keySet()) {
            charIndexMap.put(indexCharMap.get(key), key);
        }
    }
}
