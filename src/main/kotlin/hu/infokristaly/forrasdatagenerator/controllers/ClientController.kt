package hu.infokristaly.forrasdatagenerator.controllers


import hu.infokristaly.forrasdatagenerator.entity.Client
import hu.infokristaly.forrasdatagenerator.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/client")
class ClientController(@Autowired private val clientRepository: ClientRepository){

  //get all users
  @GetMapping("")
  fun getAllUsers(): List<Client> =
    clientRepository.findAll().toList()
  
  //create user
  @PostMapping("")
  fun createUser(@RequestBody client: Client): ResponseEntity<Client> {
    val savedUser = clientRepository.save(client)
    return ResponseEntity(savedUser, HttpStatus.CREATED)
  }

  //get user by id
  @GetMapping("/{id}")
  fun getUserById(@PathVariable("id") clientId: Long): ResponseEntity<Client> {
    val user = clientRepository.findById(clientId).orElse(null)
    return if (user != null) {
      ResponseEntity(user, HttpStatus.OK)
    } else {
      ResponseEntity(HttpStatus.NOT_FOUND)
    }
  }

  //update user
  @PutMapping("/{id}")
  fun updateUserById(@PathVariable("id") clientId: Long, @RequestBody client: Client): ResponseEntity<Client> {
    val existingClient = clientRepository.findById(clientId).orElse(null)

    if (existingClient == null){
      return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    val updatedClient = existingClient;
    clientRepository.save(updatedClient)
    return ResponseEntity(updatedClient, HttpStatus.OK)
  }

  //delete user
  @DeleteMapping("/{id}")
  fun deletedUSerById(@PathVariable("id") clientId: Long): ResponseEntity<Client> {
    if (!clientRepository.existsById(clientId)){
      return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    clientRepository.deleteById(clientId)
    return ResponseEntity(HttpStatus.NO_CONTENT)
  }
}
