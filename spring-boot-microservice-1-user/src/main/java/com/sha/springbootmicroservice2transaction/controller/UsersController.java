package com.sha.springbootmicroservice2transaction.controller;

import com.sha.springbootmicroservice2transaction.model.User;
import com.sha.springbootmicroservice2transaction.service.UserService;
import com.sha.springbootmicroservice2transaction.utilites.results.DataResult;
import com.sha.springbootmicroservice2transaction.utilites.results.ErrorDataResult;
import com.sha.springbootmicroservice2transaction.utilites.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

    @Autowired
    private UserService userService;



    // @Valid bunu validasyondan geçir demek!!!!!!!
    //bi iyileştirme yapıcaz public Result add(@RequestBody User user) böyle kullanırsak hep 200 döner

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user) {
        // ? ne döneceğim belli değil validation hatası da alabilirz ama her hata için ayrı try catch yazmicaz
        //global exception handler yazıcaz
        return ResponseEntity.ok(userService.saveUser(user)) ;


    }

    @GetMapping("/getall")
    public ResponseEntity<?> findAllUsers() {

        return ResponseEntity.ok(userService.findAllUsers());


    }

    @GetMapping("/findbyemail")
    public ResponseEntity<?> findByEmail(@RequestParam String email){

        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST	)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());

        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }
}
