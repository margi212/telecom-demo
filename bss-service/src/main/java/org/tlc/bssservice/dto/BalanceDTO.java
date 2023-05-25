package org.tlc.bssservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.annotation.processing.Generated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "userId",
        "sMSBalance",
        "voiceBalance",
        "dataBalance"
})
@ToString
public class BalanceDTO {
    @JsonProperty("userId")
    Long userId;

    @JsonProperty("smsBalance")
    Long smsBalance;

    @JsonProperty("voiceBalance")
    Long voiceBalance;

    @JsonProperty("dataBalance")
    Long dataBalance;
}
