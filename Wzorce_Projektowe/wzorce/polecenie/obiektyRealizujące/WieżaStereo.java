package wzorce.polecenie.obiektyRealizujące;

public class WieżaStereo {
    private int volume;
    private String pokój;

    public WieżaStereo(String pokój) {
        this.pokój = pokój;
    }

    public void włącz() {
        System.out.printf("%s wieża stereo włączona.%n", pokój);
    }

    public void wyłącz() {
        System.out.printf("%s wieża stereo wyłączona.%n", pokój);
    }

    public void ustawCD() {
        System.out.printf("%s wieża stereo wybrano odtwarzacz CD.%n", pokój);
    }

    public void ustawDVD() {
        System.out.printf("%s wieża stereo wybrano odtwarzacz DVD.%n", pokój);
    }

    public void ustawRadio() {
        System.out.printf("%s wieża stereo wybrano radio.%n", pokój);
    }

    public void ustawGłośność(int volume) {
        this.volume = volume;
        System.out.printf("%s wieża stereo głośność ustawiona na %s.%n", pokój, volume);
    }
}
