package bswe.fh3.features.register.controller;

import bswe.fh3.features.register.controller.dto.RegisterRequestDto;
import bswe.fh3.features.register.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

  private final RegisterService registerService;

  public RegisterController(RegisterService registerService) {
    this.registerService = registerService;
  }

  @PostMapping
  public ResponseEntity<String> register(@RequestBody RegisterRequestDto registerRequestDto) {
    return registerService.register(registerRequestDto);
  }
}
