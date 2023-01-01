package com.example.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class SmartHomeControllerTest1 {


    @Test
    void shouldDisableWatering() {
        //tworzymy mocka:
        HumiditySensor humiditySensorMock = mock(HumiditySensor.class);
        WateringController wateringControllerMock = mock(WateringController.class);

        // metoda .getHimidity() nic nie zwraca, dlatego definiujemy, ¿e jeœli zostanie wywo³ana ta metoda,
        // to zwrócona powinna zostaæ wartoœæ 50
        when(humiditySensorMock.getHumidity()).thenReturn(50);
        SmartHomeController smartHomeController = new SmartHomeController(humiditySensorMock, wateringControllerMock);

        //when
        smartHomeController.enableWateringIfNeeded();

        //then
        // sprawdŸ, czy metoda .disableWatering() zosta³a wywo³ana:
        verify(wateringControllerMock).disableWatering();
    }
}