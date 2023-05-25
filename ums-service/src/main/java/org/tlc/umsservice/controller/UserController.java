package org.tlc.umsservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tlc.umsservice.dto.BalanceDTO;
import org.tlc.umsservice.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/ums")
@Slf4j
class UserController {

    @Autowired
    public UserService userService;

    //1-Check SMS Balance
    @GetMapping("/sms/{id}")
    public ResponseEntity<Long> getSMSBalance(@PathVariable("id") Long id) {

        return new ResponseEntity<Long>(userService.getSMSBalance(id), HttpStatus.OK);

    }

    //2-Check Voice Balance
    @GetMapping("/voice/{id}")
    public ResponseEntity<Long> getVoiceBalance(@PathVariable("id") Long id) {
        return new ResponseEntity<Long>(userService.getVoiceBalance(id), HttpStatus.OK);
    }

    //3-Check Data Balance
    @GetMapping("/data/{id}")
    public ResponseEntity<Long> getDataBalance(@PathVariable("id") Long id) {
        return new ResponseEntity<Long>(userService.getDataBalance(id), HttpStatus.OK);
    }

    //4-Check All Balance
    @PostMapping("/all/{id}")
    public ResponseEntity<BalanceDTO> getAllBalance(@PathVariable("id") Long id) {
        return new ResponseEntity<BalanceDTO>(userService.getAllBalance(id), HttpStatus.OK);
    }
}