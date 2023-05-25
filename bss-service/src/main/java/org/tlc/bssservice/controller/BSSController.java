package org.tlc.bssservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tlc.bssservice.dto.BalanceDTO;
import org.tlc.bssservice.service.BSSService;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/bss/balance")
@Slf4j
class BSSController {

    @Autowired
    BSSService bssService;

    //1-Check SMS Balance
    @GetMapping("/sms/{id}")
    public ResponseEntity<Long> getSMSBalance(@PathVariable("id") Long id) {

        return new ResponseEntity<Long>(bssService.getSMSBalance(id), HttpStatus.OK);
    }

    //2-Check Voice Balance
    @GetMapping("/voice/{id}")
    public ResponseEntity<Long> getVoiceBalance(@PathVariable("id") Long id) {
        return new ResponseEntity<Long>(bssService.getVoiceBalance(id), HttpStatus.OK);
    }

    //3-Check Data Balance
    @GetMapping("/data/{id}")
    public ResponseEntity<Long> getDataBalance(@PathVariable("id") Long id) {
        return new ResponseEntity<Long>(bssService.getDataBalance(id), HttpStatus.OK);
    }

    //4-Check All Balance
    @PostMapping("/all/{id}")
    public ResponseEntity<BalanceDTO> getAllBalance(@PathVariable("id") Long id) throws IOException {
        return new ResponseEntity<BalanceDTO>(bssService.getAllBalance(id), HttpStatus.OK);
    }
}