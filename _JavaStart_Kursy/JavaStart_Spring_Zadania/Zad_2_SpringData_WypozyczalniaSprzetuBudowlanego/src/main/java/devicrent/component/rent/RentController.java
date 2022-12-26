package devicrent.component.rent;

import devicrent.component.customer.Customer;
import devicrent.component.customer.CustomerRopository;
import devicrent.component.device.Device;
import devicrent.component.device.DeviceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Scanner;

@Service
public class RentController {
    private Scanner scanner;
    private DeviceRepository deviceRepository;
    private CustomerRopository customerRopository;

    public RentController(Scanner scanner, DeviceRepository deviceRepository, CustomerRopository customerRopository) {
        this.scanner = scanner;
        this.deviceRepository = deviceRepository;
        this.customerRopository = customerRopository;
    }

    @Transactional
    public void rentDeviceToCustomer() {
        try {
            rent();
        } catch (RentException e) {
            System.err.println(e.getMessage());
        }
    }

    private void rent() {
        System.out.println("Podaj pesel klienta:");
        String pesel = scanner.nextLine();
        System.out.println("Podaj ID urządzenia:");
        long deviceId = scanner.nextLong();
        Optional<Customer> customer = customerRopository.findByPesel(pesel);
        Optional<Device> device = deviceRepository.findById(deviceId);
        if (customer.isPresent()) {
            device.ifPresentOrElse(
                    dev -> {
                        if (dev.getQuantity() > dev.getCustomers().size()) {
                            dev.addCustomer(customer.get());
                        } else {
                            throw new RentException("Brak wolnych urządzeń o wskazanym ID");
                        }
                    },
                    () -> {
                        throw new RentException("Brak urządzenia o wskazanym ID");
                    }
            );
        } else {
            throw new RentException("Brak klienta o wskazanym ID");
        }

    }
}
