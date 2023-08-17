package wzorce.bridge.processor;

public class UHD4KProcessor implements VideoProcessor{
    @Override
    public void process(String videoFile) {
        System.out.println("Odtwarzam plik " + videoFile);
    }
}
