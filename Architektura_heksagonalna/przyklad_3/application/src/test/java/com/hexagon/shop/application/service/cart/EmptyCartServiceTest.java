package com.hexagon.shop.application.service.cart;

import com.hexagon.shop.application.port.out.persistance.CartRepository;
import com.hexagon.shop.model.customer.CustomerId;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class EmptyCartServiceTest {

    private static final CustomerId TEST_CUSTOMER_ID = new CustomerId(61157);

    private final CartRepository cartRepository = mock(CartRepository.class);
    private final EmptyCartService emptyCartService = new EmptyCartService(cartRepository);

    @Test
    void emptyCart_invokesDeleteOnThePersistencePort() {
        emptyCartService.emptyCart(TEST_CUSTOMER_ID);

        verify(cartRepository).deleteByCustomerId(TEST_CUSTOMER_ID);
    }
}
