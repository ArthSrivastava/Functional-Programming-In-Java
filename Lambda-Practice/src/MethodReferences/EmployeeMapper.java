package MethodReferences;

public class EmployeeMapper {

    public static EmployeeDO convert(Employee employee) {
        EmployeeDO employeeDO = new EmployeeDO();
        employeeDO.setDept(employee.getDept());
        employeeDO.setId(employee.getId());
        employeeDO.setGrade(employee.getGrade());
        employeeDO.setName(employee.getName());
        employeeDO.setSalary(employee.getSalary());
        return employeeDO;
    }
}
