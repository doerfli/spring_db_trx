package li.doerf.isolationtest

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController {

    private val logger = LoggerFactory.getLogger(this.javaClass.name)

    @Autowired
    lateinit var personRepo: PersonRepository

    @GetMapping("person/list")
    fun list(): List<Person> {
        return personRepo.findAll().toList()
    }

    @PostMapping("person")
    fun create(@RequestBody person: Person): Person {
        personRepo.save(person)
        return person
    }

    @PostMapping("persona")
    @Transactional
    fun createOrNot(@RequestBody person: Person): Person {
        personRepo.save(person)

        val found = personRepo.findByName(person.name)
        logger.debug("found person: $found")

        throw Error("something did not match")
    }
}