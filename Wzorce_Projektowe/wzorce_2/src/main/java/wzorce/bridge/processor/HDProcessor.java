package wzorce.bridge.processor;

public class HDProcessor implements VideoProcessor{
    @Override
    public void process(String videoFile) {
        System.out.println("Odtwarzam plik " + videoFile);
    }
}
