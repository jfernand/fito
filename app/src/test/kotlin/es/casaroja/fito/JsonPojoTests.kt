package es.casaroja.fito

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Test
import java.io.File

class JsonPojoTests {
    @Test
    fun readPojo() {
        val mapper = jacksonObjectMapper()
        mapper.readValue<List<Product>>(File("src/main/resources/Productos-19_07_2022.json"))
    }
}
