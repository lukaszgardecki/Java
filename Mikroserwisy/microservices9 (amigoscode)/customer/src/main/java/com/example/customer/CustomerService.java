package com.example.customer;

import com.example.amqp.RabbitMQMessageProducer;
import com.example.clients.fraud.FraudCheckResponse;
import com.example.clients.fraud.FraudClient;
import com.example.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public CustomerRegistrationResponse registerCustomer(CustomerRegistrationRequest request) {
        Customer customerToSave = CustomerMapper.map(request);
        // TODO: 09.08.2023 check if email valid
        // TODO: 09.08.2023 check if email not taken
        Customer savedCustomer = customerRepository.saveAndFlush(customerToSave);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(savedCustomer.getId());

        if (fraudCheckResponse.isFraudster()) throw new IllegalStateException("fraudster");
        sendNotification(savedCustomer);
        return CustomerMapper.map(savedCustomer);
    }

    private void sendNotification(Customer savedCustomer) {
        // Tworzenie odpowiedzi, tej wiadomości, która ma zostać upubliczniona:
        NotificationRequest notificationRequest = new NotificationRequest(
                savedCustomer.getId(),
                savedCustomer.getEmail(),
                String.format("Cześć %s, witamy w serwisie...", savedCustomer.getFirstName())
        );

        //Wykonanie na producencie metody publikującej (wysłanie wiaodmości):
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }

}
