package hu.infokristaly.forrasdatagenerator.repository

import hu.infokristaly.forrasdatagenerator.entity.Client
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : CrudRepository<Client, Long>