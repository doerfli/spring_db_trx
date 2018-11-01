package li.doerf.isolationtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IsolationtestApplication

fun main(args: Array<String>) {
    runApplication<IsolationtestApplication>(*args)
}
