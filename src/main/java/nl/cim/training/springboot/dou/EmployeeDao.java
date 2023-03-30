package nl.cim.training.springboot.dou;
import nl.cim.training.springboot.exception.EmployeeNotFoundException;
import nl.cim.training.springboot.models.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import nl.cim.training.springboot.repository.EmployeeRepository;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDao {

    @Autowired
    EmployeeRepository employeeRepository;


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Long id) throws EmployeeNotFoundException {

        Optional<Employee> emp = employeeRepository.findById(id);

        if(!emp.isPresent())
            throw new EmployeeNotFoundException("Employee Not Found " + id);


        return emp.get();
    }


    public List<Employee>getAllEmployeeByFuncGroup(Double x){

        return employeeRepository.findByFuncGroupGreaterThan(x);
    }

    public Employee addEmployee(Employee emp){
        return employeeRepository.save(emp);
    }

    public Employee updateEmployee(Long id, Employee updateEmpReq) {
        updateEmpReq.setId(id);
        return employeeRepository.save(updateEmpReq);

    }

    private static List<Employee> employees = new ArrayList<>();




}

