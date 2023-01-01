package com.example.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SmartHomeControllerTest4 {
    @Mock
    private HumiditySensor humiditySensorMock;
    @Mock
    private WateringController wateringControllerMock;
    @InjectMocks
    private SmartHomeController smartHomeController;

    /**
     * adnotacja @IncjectMocks
     * Pozwala ona na automatyczne wstrzykniêcie mocków do konstruktora klasy.
     * Jeœli mock nie zostanie odnaleziony to w miejsce parametru konstruktora z jego typem zostanie podstawiony null.
     * Jest to wiêc rozwi¹zanie bardziej podatne na NullPointeryException.
     * W przypadku gdyby konstruktor SmartHomeController zosta³ zmieniony i przyk³adowo zostanie tam dodany
     * kolejny parametr to test nadal bêdzie siê kompilowa³ w przeciwieñstwie do poprzedniego rozwi¹zania gdzie
     * samemu wywo³ywaliœmy konstruktor.
     */


    @Test
    void shouldDisableWatering() {
        // given
        when(humiditySensorMock.getHumidity()).thenReturn(50);

        //when
        smartHomeController.enableWateringIfNeeded();

        //then
        verify(wateringControllerMock).disableWatering();
    }
}