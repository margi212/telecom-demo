package org.tlc.umsservice.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.tlc.umsservice.dto.BalanceDTO;

@FeignClient(name = "bss-service", path = "/api/v1/bss/balance")
public interface BssServiceFeignClient {

    @GetMapping("/sms/{id}")
    public Long getSMSBalance(@PathVariable Long id);

    @GetMapping("/voice/{id}")
    public Long getVoiceBalance(@PathVariable Long id);

    @GetMapping("/data/{id}")
    public Long getDataBalance(@PathVariable Long id);

    @PostMapping("/all/{id}")
    public BalanceDTO getAllBalance(@PathVariable Long id);

}