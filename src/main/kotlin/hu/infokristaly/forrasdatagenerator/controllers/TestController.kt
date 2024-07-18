package hu.infokristaly.forrasdatagenerator.controllers

import hu.infokristaly.forrasdatagenerator.entity.Client
import hu.infokristaly.forrasdatagenerator.entity.EventHistory
import hu.infokristaly.forrasdatagenerator.entity.Subject
import hu.infokristaly.forrasdatagenerator.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.FileInputStream
import java.io.InputStreamReader
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.util.*


@RestController
@RequestMapping("/api/test")
class TestController(
    @Autowired private val clientRepository: ClientRepository,
    @Autowired private val systemUserRepository: SystemUserRepository,
    @Autowired private val doctorRepository: DoctorRepository,
    @Autowired private val eventHistoryRepositry: EventHistoryRepository,
    @Autowired private val subjectRepository: SubjectRepository,
    @Autowired private val clientTypeRepository: ClientTypeRepository,
) {
    private fun getRandomDate() : Date {
        return Date(Date().year - (0..100).random(), Date().month + (0..11).random(), Date().day + (0..31).random())
    }
    private fun getRandomTAJ() : String {
        return (100..999).random().toString() + "-" + (100..999).random().toString() + "-" + (100..999).random().toString()
    }
    private fun getRandomNYSzam() : String {
        var result = "2015/"
        result += (0..100).random()
        result += "/"
        val abc1 = ('A'..'Z').random()
        val abc2 = ('A'..'Z').random()
        return result + abc1 + abc2
    }
    private fun getRandomNames(): MutableList<String> {
        val result = mutableListOf<String>()
        try {

            val vnevekReader = InputStreamReader(FileInputStream("csaladnevek.txt"), "UTF8")
            val vezeteknevek = vnevekReader.readLines()
            vnevekReader.close()
            val knevekReader = InputStreamReader(FileInputStream("keresztnevek.txt"), "UTF8")
            val keresztnevek = knevekReader.readLines()
            knevekReader.close()

            for(i in 1..100) {
                val v1 = vezeteknevek.shuffled()
                val v2 = keresztnevek.shuffled()
                val nev = v1.first() + " " + v2.first()
                result.add(nev)
            }
        } catch (e:Exception) {

        }
        return result
    }
    @GetMapping("/upload")
    fun uploadClient(): ResponseEntity<List<Client>> {
        try {
            val user = systemUserRepository.findById(1)
            val doctor = doctorRepository.findById(1)
            val clients = mutableListOf<Client>()
            val clientTypes = clientTypeRepository.findAll()
            val felvetelDatuma = Date.from(LocalDate.of(2020, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant())
            getRandomNames().forEach { neve ->
                val client = Client()
                client.neve = neve
                client.nyilvantartasiSzam = getRandomNYSzam()
                client.active = true
                client.createDate = Date()
                client.created_by = user.get()
                client.currentManager = user.get()
                client.currentDoctor = doctor.get()
                client.felvetDatum = felvetelDatuma
                client.szuletesiHely = "Budapest"
                client.szuletesiIdo = getRandomDate()
                client.taj = getRandomTAJ()
                client.version = 0
                client.clientType = clientTypes.shuffled().first()
                val savedUser = clientRepository.save(client)
                clients.add(savedUser)
            }
            return ResponseEntity(clients, HttpStatus.OK)
        } catch (e:Exception) {
            println(e.localizedMessage)
            return ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/upload-events")
    fun uploadEvents(@RequestParam("start") start: String, @RequestParam("end") end: String): ResponseEntity<List<EventHistory>> {
        val clients: List<Client> = clientRepository.findAll().toList()
        val user = systemUserRepository.findById(1)
        val originSubjects = subjectRepository.findAll()
        var subjects: MutableList<Subject> = mutableListOf()
        subjects.addAll(originSubjects.toList())
        val cal = Calendar.getInstance()
        val formatter = DateTimeFormatterBuilder()
        val endDate = Date.from(LocalDate.parse(end, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay(ZoneId.systemDefault()).toInstant())
        cal.time = Date.from(LocalDate.parse(start, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay(ZoneId.systemDefault()).toInstant())
        cal.set(Calendar.HOUR_OF_DAY,8)
        val startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
        if (startDayOfWeek == 7 || startDayOfWeek == 1) {
            cal.add(Calendar.DATE, if (startDayOfWeek == 1) 1 else 2 )
        }
        while (cal.time.before(endDate)) {
            val eventHistory = EventHistory()
            if (cal.get(Calendar.HOUR_OF_DAY) > 17) {
                cal.set(Calendar.HOUR_OF_DAY, 8)
                cal.add(Calendar.DATE, 1)
            }
            if (cal.get(Calendar.DAY_OF_WEEK) == 7) {
                cal.add(Calendar.DATE, 2)
            }
            if (cal.time.before(endDate)) {
                eventHistory.startDate = cal.time
                cal.add(Calendar.HOUR_OF_DAY, 1) // adds one hour
                eventHistory.endDate = cal.time

                eventHistory.clients = clients.shuffled().subList(1, (1..20).random())
                eventHistory.createdBy = user.get()
                eventHistory.createdDate = Date()
                eventHistory.version = 0
                eventHistory.leaders = listOf(user.get())
                if (subjects.isEmpty()) {
                    subjects.addAll(originSubjects.toList())
                }
                subjects = subjects.shuffled().toMutableList()
                eventHistory.subject = subjects.removeFirst()
                eventHistory.title = eventHistory.subject.title
                eventHistoryRepositry.save(eventHistory)
            }
        }
        return ResponseEntity(HttpStatus.OK)
    }

}