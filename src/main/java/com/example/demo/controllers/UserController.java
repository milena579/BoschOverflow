package com.example.demo.controllers;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService service;

    @Autowired
    UserRepository userRep;

    @PostMapping
    public ResponseEntity<String> create(@ResquestBody UserData data) {

        if (service.validateEmail(data.email) && service.validateName(data.name) && service.validatePassword(data.password)) {

            service.Register(data);
            return new ResponseEntity("Usuário cadastrado", HttpStatus.OK);
        } else if (!service.validateEmail(data.email)) {
            return new ResponseEntity("Email inválido", HttpStatus.OK);
        } else if (!service.validateName(data.name)) {
            return new ResponseEntity("Nome inválido", HttpStatus.OK);
        } else if (!service.validatePassword(data.name)) {
            return new ResponseEntity("Senha deve ter no minímo 12 caracteres, letra maiuscula, letra minuscula e número", HttpStatus.OK);
        } 
    }

    @GetMapping
    public ResponseEntity<List<UserData>> getUser(int page, int size, String name) {
        UserQuery queryUser = new UserQuery(name, page, size);

        return service.searchUser(queryUser);
    }
}
