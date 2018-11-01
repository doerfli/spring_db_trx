package li.doerf.isolationtest

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Person(
        @Id @GeneratedValue var id: Long,
        var name: String
)