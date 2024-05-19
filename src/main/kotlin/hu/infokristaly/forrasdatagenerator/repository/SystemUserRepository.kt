package hu.infokristaly.forrasdatagenerator.repository

import hu.infokristaly.forrasdatagenerator.entity.SystemUser
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SystemUserRepository : CrudRepository<SystemUser, Long>