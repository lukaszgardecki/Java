package pl.mojastrona.di.crypto;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class CaesarCipherService implements CipherService {

    private static final int SHIFT = 3;


    @Override
    public String encrypt(String plainText) {
        return plainText.chars()
                .map(CaesarCipherService::shift)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static int shift(int character) {
        return character + SHIFT;
    }

    @Override
    public String decrypt(String cipher) {
        return cipher.chars()
                .map(CaesarCipherService::shiftBack)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static int shiftBack(int character) {
        return character - SHIFT;
    }
}
