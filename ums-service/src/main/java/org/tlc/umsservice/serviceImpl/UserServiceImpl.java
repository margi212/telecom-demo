package org.tlc.umsservice.serviceImpl;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tlc.umsservice.dto.BalanceDTO;
import org.tlc.umsservice.feignservice.BssServiceFeignClient;
import org.tlc.umsservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public BssServiceFeignClient bssServiceFeignClient;

    @Override
    @CircuitBreaker(name = "bss-service", fallbackMethod = "bssSMSFallback")
    public Long getSMSBalance(Long id) {

        return bssServiceFeignClient.getSMSBalance(id);

    }

    @Override
    @CircuitBreaker(name = "bss-service", fallbackMethod = "bssDataFallback")
    public Long getDataBalance(Long id) {

        return bssServiceFeignClient.getDataBalance(id);

    }

    @Override
    @CircuitBreaker(name = "bss-service", fallbackMethod = "bssVoiceFallback")
    public Long getVoiceBalance(Long id) {

        return bssServiceFeignClient.getVoiceBalance(id);

    }

    @Override
    @CircuitBreaker(name = "bss-service", fallbackMethod = "bssAllFallback")
    public BalanceDTO getAllBalance(Long id) {

        return bssServiceFeignClient.getAllBalance(id);

    }


    public Long bssSMSFallback(Exception e) {
        logger.info(e.toString());
        return -1L;
    }

    public Long bssDataFallback(Exception e) {
        logger.info(e.toString());
        return -1L;
    }

    public Long bssVoiceFallback(Exception e) {
        logger.info(e.toString());
        return -1L;
    }

    public BalanceDTO bssAllFallback(Exception e) {
        logger.info(e.toString());
        return new BalanceDTO(-1L, -1L, -1L, -1L);
    }
}
