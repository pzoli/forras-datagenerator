package hu.infokristaly.forrasdatagenerator.repository

import hu.infokristaly.forrasdatagenerator.entity.Subject
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SubjectRepository : CrudRepository<Subject, Long> {
}