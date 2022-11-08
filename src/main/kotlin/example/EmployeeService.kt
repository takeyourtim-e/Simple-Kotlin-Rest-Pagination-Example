package example

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class EmployeeService(private val employeeRepository: EmployeeRepository) {

    fun getAllEmployees(): List<Employee> = employeeRepository.findAll()

    fun getAllEmployeesPageable(lastName: String, pageable: Pageable): List<Employee?> =
        employeeRepository.findAllByLastName( lastName = lastName, pageable = pageable)

    fun getEmployeesById(employeeId: Long): Employee = employeeRepository.findById(employeeId)
        .orElseThrow { NotFoundException() }

    fun createEmployee(employee: Employee): Employee = employeeRepository.save(employee)

    fun updateEmployeeById(employeeId: Long, employee: Employee): Employee {
        return if (employeeRepository.existsById(employeeId)) {
            employeeRepository.save(
                Employee(
                    id = employee.id,
                    userName = employee.userName,
                    firstName = employee.firstName,
                    middleName = employee.middleName,
                    lastName = employee.lastName,
                    emailId = employee.emailId,
                    dayOfBirth = employee.dayOfBirth
                )
            )
        } else throw NotFoundException()
    }

    fun deleteEmployeesById(employeeId: Long) {
        return if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId)
        } else throw NotFoundException()
    }
}