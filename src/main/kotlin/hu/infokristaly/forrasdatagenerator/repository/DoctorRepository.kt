package hu.infokristaly.forrasdatagenerator.repository


import hu.infokristaly.forrasdatagenerator.entity.Doctor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DoctorRepository : CrudRepository<Doctor, Int>