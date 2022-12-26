package devicrent.app;

import devicrent.component.category.CategoryController;
import devicrent.component.customer.CustomerController;
import devicrent.component.device.DeviceController;
import devicrent.component.rent.RentController;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.Scanner;

@Controller
public class ApplicationController {
    private Scanner scanner;
    private DeviceController deviceController;
    private CategoryController categoryController;
    private CustomerController customerController;
    private RentController rentController;

    public ApplicationController(Scanner scanner, DeviceController deviceController, CategoryController categoryController, CustomerController customerController, RentController rentController) {
        this.scanner = scanner;
        this.deviceController = deviceController;
        this.categoryController = categoryController;
        this.customerController = customerController;
        this.rentController = rentController;
    }

    public void mainLoop() {
        Options option;
        do {
            printOptions();
            option = readOption();
            executeOption(option);
        } while (option != Options.EXIT);
    }

    private void printOptions() {
        System.out.println("Opcje:");
        Arrays.stream(Options.values()).forEach(System.out::println);
    }

    private Options readOption() {
        boolean correctOptionSelected = false;
        Options option = null;
        while (!correctOptionSelected) {
            System.out.println("Podaj ID opcji:");
            int optionId = scanner.nextInt();
            scanner.nextLine();
            try {
                option = Options.numberToCategory(optionId);
                correctOptionSelected = true;
            } catch (InvalidOptionException e) {
                System.err.println(e.getMessage());
            }
        }
        return option;
    }

    private void executeOption(Options option) {
        switch (option) {
            case ADD_DEVICE -> deviceController.createDevice();
            case ADD_CATEGORY -> categoryController.createCategory();
            case ADD_CUSTOMER -> customerController.createCustomer();
            case RENT -> rentController.rentDeviceToCustomer();
            case REMOVE_DEVICE -> deviceController.removeDevice();
            case REMOVE_CATEGORY -> categoryController.removeCategory();
            case REMOVE_CUSTOMER -> customerController.removeCustomer();
            case SEARCH_DEVICE -> deviceController.searchDevice();
            case EXIT -> closeApp();
        }
    }

    private void closeApp() {
        scanner.close();
        System.out.println("Bye bye!");
    }
}
