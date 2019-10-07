package utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.util.Base64;

public class KeysGenerator {

    private static final String PUBLIC_KEY_PATH = "KeyPair/publicKey.key";
    private static final String PRIVATE_KEY_PATH = "KeyPair/privateKey.key";

    private KeyPairGenerator keyPairGenerator;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public enum Algorithm {
        RSA,
        AES
    }

    public KeysGenerator(int keySize, Algorithm abbreviation) {
        try {
            this.keyPairGenerator = KeyPairGenerator.getInstance(abbreviation.name());
            this.keyPairGenerator.initialize(keySize, new SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createKeys() {
        KeyPair keyPair = this.keyPairGenerator.generateKeyPair();
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }

    public void writeKeysToFolder(String path, boolean useBase64) throws IOException {
        byte[] bytesPrivateKey = useBase64 ? Base64.getEncoder().encodeToString(this.privateKey.getEncoded()).getBytes()
                                           : this.privateKey.getEncoded();

        byte[] bytesPublicKey = useBase64 ? Base64.getEncoder().encodeToString(this.publicKey.getEncoded()).getBytes()
                                          : this.publicKey.getEncoded();

        writeKeyToFile(path + PRIVATE_KEY_PATH, bytesPrivateKey);
        writeKeyToFile(path + PUBLIC_KEY_PATH, bytesPublicKey);
    }

    private void writeKeyToFile(String path, byte[] key) throws IOException {
        File file = new File(path);
        file.getParentFile().mkdirs();

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {

            bufferedOutputStream.write(key);
            bufferedOutputStream.flush();
        }
    }
}
