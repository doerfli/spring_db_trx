package li.doerf.isolationtest

import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Long> {
    fun findByName(name: String): List<Person>
}