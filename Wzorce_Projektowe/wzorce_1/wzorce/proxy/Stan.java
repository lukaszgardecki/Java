package wzorce.proxy;

import java.io.Serializable;

public interface Stan extends Serializable {
    void włóżMonetę();
    void zwróćMonetę();
    void przekręćGałkę();
    void wydaj();
}
