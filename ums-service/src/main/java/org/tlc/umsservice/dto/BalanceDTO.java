package org.tlc.umsservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BalanceDTO {
    Long userId;

    Long smsBalance;;

    Long voiceBalance;

    Long dataBalance;
}
