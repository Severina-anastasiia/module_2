package ua.com.alevel.moduletwo;

import ua.com.alevel.moduletwo.encryption.EncryptionImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        EncryptionImpl en = new EncryptionImpl();
        en.run();
    }
}
