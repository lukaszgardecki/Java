package devicrent.component.device;

import devicrent.component.category.Category;
import devicrent.component.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class DeviceController {
    private Scanner scanner;
    private DeviceRepository deviceRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public DeviceController(Scanner scanner, DeviceRepository deviceRepository, CategoryRepository categoryRepository) {
        this.scanner = scanner;
        this.deviceRepository = deviceRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void createDevice() {
        try {
            Device device = readDevice();
            deviceRepository.save(device);
            System.out.println("Dodano urządzenie.");
            System.out.println(device);
        } catch (CategoryNotFoundException e) {
            System.err.println("Urządzenia nie dodano. " + e.getMessage());
        }
    }

    private Device readDevice() {
        Device device = new Device();
        System.out.println("Nazwa urządzenia:");
        device.setName(scanner.nextLine());
        System.out.println("Opis urządzenia:");
        device.setDescription(scanner.nextLine());
        System.out.println("Cena urządzenia:");
        device.setPrice(scanner.nextDouble());
        System.out.println("Ilość(szt) urządzenia:");
        device.setQuantity(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Kategoria urządzenia:");
        String categoryName = scanner.nextLine();
        Optional<Category> category = categoryRepository.findByNameIgnoreCase(categoryName);

        category.ifPresentOrElse(device::setCategory,
                () -> {
            throw new CategoryNotFoundException("Kategoria o podanym ID nie istnieje.");
        }
        );
        return device;
    }

    public void removeDevice() {
        System.out.println("Podaj id urządzenia, które chcesz usunąć:");
        long deviceId = scanner.nextLong();
        Optional<Device> device = deviceRepository.findById(deviceId);
        device.ifPresentOrElse(deviceRepository::delete, () -> System.out.println("Brak urządzenia o wskazanym ID"));
    }

    public void searchDevice() {
        System.out.println("Podaj fragment nazwy:");
        String name = scanner.nextLine();
        List<Device> devices = deviceRepository.findAllByNameContainingIgnoreCase(name);
        if (devices.isEmpty()) {
            System.out.println("Brak urządzeń o wskazanej nazwie.");
        } else {
            System.out.println("Znalezione urządzenia:");
            devices.forEach(System.out::println);
        }
    }
}
