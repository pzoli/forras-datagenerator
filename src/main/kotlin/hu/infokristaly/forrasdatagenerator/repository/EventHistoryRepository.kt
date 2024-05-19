package hu.infokristaly.forrasdatagenerator.repository

import hu.infokristaly.forrasdatagenerator.entity.EventHistory
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EventHistoryRepository : CrudRepository<EventHistory, Long>