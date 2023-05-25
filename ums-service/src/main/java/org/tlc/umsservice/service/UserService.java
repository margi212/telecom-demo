package org.tlc.umsservice.service;

import org.springframework.stereotype.Service;
import org.tlc.umsservice.dto.BalanceDTO;

@Service
public interface UserService {
    public Long getSMSBalance(Long userId);

    public Long getDataBalance(Long userId);

    public Long getVoiceBalance(Long userId);

    public BalanceDTO getAllBalance(Long userId);


}
