public interface Encryptor {

  String encryptFile();

  Encryptor aesEncryptor = () -> "Applying AES encryption";

  Encryptor rsaEncryptor = () -> "Applying RSA encryption";
}
