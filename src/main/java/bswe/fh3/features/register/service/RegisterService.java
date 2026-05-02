package bswe.fh3.features.register.service;

import bswe.fh3.features.register.controller.dto.RegisterRequestDto;
import bswe.fh3.features.register.domain.Person;
import bswe.fh3.features.register.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

  private final PersonRepository personRepository;

  public RegisterService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public ResponseEntity<String> register(RegisterRequestDto registerRequestDto) {
    System.out.println("Registering new user with username: " + registerRequestDto.getUsername());
    System.out.println("Registering new user with email: " + registerRequestDto.getEmail());
    System.out.println("Registering new user with password: " + registerRequestDto.getPassword());
    Person person =
        new Person(
            registerRequestDto.getUsername(),
            registerRequestDto.getEmail(),
            registerRequestDto.getPassword());
    personRepository.save(person);
    return ResponseEntity.ok("new user registered");
  }
}
