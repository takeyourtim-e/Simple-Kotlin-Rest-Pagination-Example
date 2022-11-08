package example

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface EmployeeRepository : JpaRepository<Employee, Long>{

//    fun findAllByLastName(lastName: Long, pageable: Pageable?): List<Employee?>?


    fun findAllByLastName(lastName : String, pageable: Pageable): List<Employee>

}

