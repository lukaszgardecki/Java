package com.example.Spring_Boot_REST_API_1.controller;

import com.example.Spring_Boot_REST_API_1.model.Employee;
import com.example.Spring_Boot_REST_API_1.model.EmployeeDto;
import com.example.Spring_Boot_REST_API_1.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *  PRÓBA STWORZENIA REST API ZGODNIE Z MODELEM DOJRZAŁOŚCI RICHARDSONA
 *  PRÓBA STWORZENIA REST API POZIOMU 3
 *
 *  Im wyższy poziom zostanie zaimplementowany, tym bardziej
 *  nasze API jest zgodne z architekturą REST.
 *
 *  Na poziomie 0 API nie spełnia założeń sla stylu architektury REST
 */

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private static final Long EMPTY_ID = null;
    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public CollectionModel<EntityModel<Employee>> getEmployees() {

        // dodawanie linków w liście:
        //w liście POZA entityModel musimy skorzystać z collectionModel

        List<EntityModel<Employee>> employees = employeeService.getEmployees().stream()
                .map(EntityModel::of)
                .toList();

        return CollectionModel.of(employees,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).getEmployees()).withSelfRel()
        );
    }

    @GetMapping("/employees/{id}")
    public EntityModel<Employee> getEmployee(@PathVariable Long id) {


        //return employeeService.getEmployee(id);

        // JEŻELI CHCEMY DODAĆ LINKI :
        return EntityModel.of(employeeService.getEmployee(id),
                // Z klasy WebMvcLinkBuilder bierzemy metodę linkTo
                // jako parametr dodajemy metodę methodOn (w nawiasie klasa naszego kontrolera)
                // na tej metodzie wywołujemy meotdę zwracającą pracownika (po id)
                // następnie (dla całości) po kropce podajemy w jakiej relacji ten link jest do naszego zasobu
                // zwykle podając linki, pierwszy link odnosi się do "swojego" zasobu - dlatego
                // wywołana na końcu metoda to withSELFrel()
                // dla withRel() w nawiasie podajmey NAZWĘ relacji
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).getEmployee(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).getEmployees()).withRel("employees"),

                // drugi rodzaj implementacji. Do linkTo() dodajemy KLASĘ (bo metoda deactive jest VOID - nic nie zwraca)
                WebMvcLinkBuilder.linkTo(EmployeeController.class).slash("employees").slash(id).slash("deactivate")
                        .withRel("deactivate")
        );
    }



    // ZMIANA STATUSU NA 201: "CREATED"
    @PostMapping("/employees")
    public ResponseEntity<EntityModel<Employee>> createEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.createEmployee(new Employee(
                EMPTY_ID,
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.isActive(),
                employeeDto.getCreated()
        ));
//        UriComponents uriComponents = UriComponentsBuilder
//                .fromHttpUrl("http://localhost:8080/{id}")
//                .buildAndExpand(employee.getId());
//        return ResponseEntity.created(uriComponents.toUri())
//                .build();

        //W HEADERS ZWRACA NAGŁÓWEK "Location":
//        return ResponseEntity.created(uriComponents.toUri())
//                .body(employee);

        //W HEADERS NIE ZWRACA NAGŁÓWKA "Location":
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(employee);

        //JEŻELI CHCEMY ZACHOWAĆ NAGŁÓWKI I DODAĆ LINKI:
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(EntityModel.of(employee,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).createEmployee(employeeDto)).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).getEmployees()).withRel("employees"),
                        WebMvcLinkBuilder.linkTo(EmployeeController.class).slash("employees").slash(employee.getId()).slash("deactivate").withRel("deactivate")
                ));



    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        employeeService.updateEmployee(new Employee(
                id,
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.isActive(),
                employeeDto.getCreated()
        ));

        // JEŻELI NIE CHCEMY NIC ZWRACAĆ W ODPOWIEDZI
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/employee/{id}")
    //@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/employees/{id}/deactivate")
    public void deactivateEmployee(@PathVariable Long id) {
        employeeService.deactivateEmployee(id);
    }
}
