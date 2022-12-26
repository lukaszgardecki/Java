package devicrent.component.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CustomerController {
    private Scanner scanner;
    private CustomerRopository customerRopository;

    @Autowired
    public CustomerController(Scanner scanner, CustomerRopository customerRopository) {
        this.scanner = scanner;
        this.customerRopository = customerRopository;
    }

    public void createCustomer() {
        Customer customer = readCustomer();
        customerRopository.save(customer);
        System.out.println("Dodano klienta");
        System.out.println(customer);
    }

    private Customer readCustomer() {
        Customer customer = new Customer();
        System.out.println("Podaj imię:");
        customer.setFirstName(scanner.nextLine());
        System.out.println("Podaj nazwisko:");
        customer.setLastName(scanner.nextLine());
        System.out.println("Podaj pesel:");
        customer.setPesel(scanner.nextLine());
        System.out.println("Podaj numer dowodu:");
        customer.setIdNumber(scanner.nextLine());
        return customer;
    }

    public void removeCustomer() {
        System.out.println("Podaj id klienta, którego chcesz usunąć.");
        long customerId = scanner.nextLong();
        Optional<Customer> customer = customerRopository.findById(customerId);
        customer.ifPresentOrElse(customerRopository::delete, () -> System.out.println("Brak klienta o wskazanym ID"));
    }
}
