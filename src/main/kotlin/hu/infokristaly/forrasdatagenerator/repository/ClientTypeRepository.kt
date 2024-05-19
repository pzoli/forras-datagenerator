package hu.infokristaly.forrasdatagenerator.repository

import hu.infokristaly.forrasdatagenerator.entity.ClientType
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface  ClientTypeRepository: CrudRepository<ClientType, Long> {
}