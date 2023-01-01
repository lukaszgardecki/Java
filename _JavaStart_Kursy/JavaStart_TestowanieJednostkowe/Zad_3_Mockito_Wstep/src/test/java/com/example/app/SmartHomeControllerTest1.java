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

        // metoda .getHimidity() nic nie zwraca, dlatego definiujemy, �e je�li zostanie wywo�ana ta metoda,
        // to zwr�cona powinna zosta� warto�� 50
        when(humiditySensorMock.getHumidity()).thenReturn(50);
        SmartHomeController smartHomeController = new SmartHomeController(humiditySensorMock, wateringControllerMock);

        //when
        smartHomeController.enableWateringIfNeeded();

        //then
        // sprawd�, czy metoda .disableWatering() zosta�a wywo�ana:
        verify(wateringControllerMock).disableWatering();
    }
}