package nl.cim.training.springboot.controllers;


import nl.cim.training.springboot.dto.EmployeeRequest;
import nl.cim.training.springboot.dto.EmployeeResponse;
import nl.cim.training.springboot.exception.EmployeeNotFoundException;
import nl.cim.training.springboot.services.EmployeesServices;
import nl.cim.training.springboot.validators.EmployeeValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(path =EmployeeController.employeeControlPath)
public class EmployeeController {

    static final String employeeControlPath = "/employees";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private HttpHeaders createHeader(String name, String value) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(name, value);
        return headers;
    }


    @GetMapping(
            path = "/{id}",
            produces = ("application/json")
    )
    public ResponseEntity<EmployeeResponse> getEmployee(
            @PathVariable Long id) throws EmployeeNotFoundException {

        return new ResponseEntity<>(
                employeeServices.getEmployee(id),
                createHeader("Employee", id.toString()),
                HttpStatus.OK
        );

    }


    @Autowired
    EmployeesServices employeeServices;

    @GetMapping(
            path = "/",
            produces = ("application/json"))
            public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){

                return new ResponseEntity<>(
                        employeeServices.getAllEmployees(),
            createHeader("Employees", "ALL"),
            HttpStatus.OK
            );

            }

    @GetMapping(
            path = "/func_group/{x}",
            produces = ("application/json"))
            public ResponseEntity<List<EmployeeResponse>> getAllEmployeesGreaterThanFuncGroup(@PathVariable(value = "x") Double x){

        return new ResponseEntity<>(
                employeeServices.getAllEmployeesGreaterThanX(x),
                createHeader("Employees", "Value of " + x),
                HttpStatus.OK
        );


    }

    @PostMapping(
            path = "/",
            consumes = "application/json",
            produces = ("application/json"))
            public ResponseEntity<EmployeeResponse> addEmployee(
                    @EmployeeValidation @RequestBody EmployeeRequest employeeRequest) {

                EmployeeResponse newEmployee = employeeServices.saveEmployee(employeeRequest);

        return new ResponseEntity<>(
                newEmployee,
                createHeader ("Employee", newEmployee.getId().toString()),
                HttpStatus.CREATED
        );
    }

    @PutMapping(
            path = "/{id}",
            consumes = "application/json",
            produces = ("application/json"))
            public ResponseEntity<EmployeeResponse> updateFuncGroupEmployee(
                    @PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) throws EmployeeNotFoundException{

                logger.info("Employee ID requested: {}", id);

                return new ResponseEntity<>(
                        employeeServices.updateEmployee (id, employeeRequest),
                        createHeader("Employee", id.toString()),
                        HttpStatus.ACCEPTED
                );


    }







}
