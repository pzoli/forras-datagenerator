package hu.infokristaly.forrasdatagenerator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan(basePackages = ["hu.infokristaly.forrasdatagenerator.entity"])
class ForrasDatageneratorApplication

fun main(args: Array<String>) {
	runApplication<ForrasDatageneratorApplication>(*args)
}
