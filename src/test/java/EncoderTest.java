import org.junit.Test;

public class EncoderTest {
    private final String ORIGINAL = "HELLO WORLD!";
    private final String ENCODED = "C/GGJ RJMG.!";

    @Test
    public void encodeTest() {
        Encoder encoder = new Encoder();
        String encoded = encoder.encodeString(ORIGINAL);
        assert encoded.equals(ENCODED);
    }

    @Test
    public void decodeTest() {
        Encoder encoder = new Encoder();
        String decoded = encoder.decodeString(ENCODED);
        assert decoded.equals(ORIGINAL);
    }

    @Test
    public void encodeDecodeTest() {
        Encoder encoder = new Encoder();
        String encoded = encoder.encodeString(ORIGINAL);
        String decoded = encoder.decodeString(encoded);
        assert decoded.equals(ORIGINAL);
    }
}
