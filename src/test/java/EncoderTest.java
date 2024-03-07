import org.junit.Test;

public class EncoderTest {
    private final String ORIGINAL = "HELLO WORLD!";
    private final String ENCODED = "C/GGJ RJMG.!";
    private int SEED = 12345;
    private int SEED2 = 23456;

    @Test
    public void encodeTest() {
        Encoder encoder = new Encoder(SEED);
        String encoded = encoder.encodeString(ORIGINAL);
        assert encoded.equals(ENCODED);
    }

    @Test
    public void decodeTest() {
        Encoder encoder = new Encoder(SEED);
        String decoded = encoder.decodeString(ENCODED);
        assert decoded.equals(ORIGINAL);
    }

    @Test
    public void encodeDecodeTest() {
        Encoder encoder = new Encoder(SEED);
        String encoded = encoder.encodeString(ORIGINAL);
        String decoded = encoder.decodeString(encoded);
        assert decoded.equals(ORIGINAL);
    }

    @Test
    public void encodeDecodeTestAltSeed() {
        Encoder encoder = new Encoder(SEED2);
        String encoded = encoder.encodeString(ORIGINAL);
        String decoded = encoder.decodeString(encoded);
        assert decoded.equals(ORIGINAL);
    }
}
