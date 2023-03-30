package nl.cim.training.springboot.services;


import nl.cim.training.springboot.converter.EmployeeConverter;
import nl.cim.training.springboot.dou.EmployeeDao;
import nl.cim.training.springboot.dto.EmployeeRequest;
import nl.cim.training.springboot.dto.EmployeeResponse;
import nl.cim.training.springboot.exception.EmployeeNotFoundException;
import nl.cim.training.springboot.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServices {

    @Autowired
    EmployeeDao employeeDao;

    public EmployeeResponse getEmployee(Long id) throws EmployeeNotFoundException {
        return EmployeeConverter.convert(employeeDao.getEmployee(id));


    }

    public List<EmployeeResponse> getAllEmployees() {
        return EmployeeConverter.convert(employeeDao.getAllEmployees());
    }

    public List<EmployeeResponse> getAllEmployeesGreaterThanX(Double x) {
        return EmployeeConverter.convert(employeeDao.getAllEmployeeByFuncGroup(x));
    }

    public EmployeeResponse saveEmployee (EmployeeRequest eReq) {
        Employee e = EmployeeConverter.convert(eReq);
        return EmployeeConverter.convert(employeeDao.addEmployee(e));

    }

    public EmployeeResponse updateEmployee (Long id, EmployeeRequest eReq) throws EmployeeNotFoundException {
        Employee e = EmployeeConverter.convert(eReq);
        employeeDao.updateEmployee(id, e);
        return getEmployee(id);

    }












}
