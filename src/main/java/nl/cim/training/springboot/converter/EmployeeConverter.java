package nl.cim.training.springboot.converter;

import nl.cim.training.springboot.dto.EmployeeRequest;
import nl.cim.training.springboot.dto.EmployeeResponse;
import nl.cim.training.springboot.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeConverter {

    public static EmployeeResponse convert(Employee e) {
        return new EmployeeResponse(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                e.getEmail(),
                e.getFuncGroup(),
                e.getDateOfBirth());


    }

    public static List<EmployeeResponse> convert(List<Employee> emps) {

        List<EmployeeResponse> empsResps = new ArrayList<>();
        emps.stream().forEach(
                e -> empsResps.add(convert(e))
        );

        return empsResps;
    }


    public static Employee convert(EmployeeRequest eReq) {

        return new Employee(
                eReq.getFirstName(),
                eReq.getMiddleName(),
                eReq.getLastName(),
                eReq.getEmail(),
                eReq.getFuncGroup(),
                eReq.getSalary(),
                eReq.getDateOfBirth()


        );
    }
}
