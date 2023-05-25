package org.tlc.bssservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.tlc.bssservice.dto.BalanceDTO;
import org.tlc.bssservice.exception.BSSException;

import java.nio.charset.StandardCharsets;

@Service
public class BSSService {

    Logger logger = LoggerFactory.getLogger(BSSService.class);

    public final   ClassPathResource staticDataResource = new ClassPathResource("static-data.json");

    public Long getSMSBalance(Long userId) {
        try {
            String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);

            Long balance = Long.valueOf(new JSONObject(staticDataString).getJSONObject(userId.toString()).get("smsBalance").toString());
            logger.info("balance:" + balance + "for userId:" + userId);

            return balance;
        } catch (JSONException e) {
            logger.info("Exception Occurs in JSONException:" + e.toString());
            throw new JSONException(e.toString());
        } catch (Exception e) {
            logger.info("Exception Occurs in getSMSBalance:" + e.toString());
            throw new BSSException(e.toString());
        }
    }

    public Long getDataBalance(Long userId) {
        try {
            String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);

            Long balance = Long.valueOf(new JSONObject(staticDataString).getJSONObject(userId.toString()).get("dataBalance").toString());
            logger.info("balance:" + balance + "for userId:" + userId);

            return balance;
        } catch (JSONException e) {
            logger.info("Exception Occurs in JSONException:" + e.toString());
            throw new JSONException(e.toString());
        } catch (Exception e) {
            logger.info("Exception Occurs in getDataBalance:" + e.toString());
            throw new BSSException(e.toString());
        }

    }

    public Long getVoiceBalance(Long userId) {
        try {
            String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);

            Long balance = Long.valueOf(new JSONObject(staticDataString).getJSONObject(userId.toString()).get("voiceBalance").toString());
            logger.info("balance:" + balance + "for userId:" + userId);

            return balance;
        } catch (JSONException e) {
            logger.info("Exception Occurs in JSONException:" + e.toString());
            throw new JSONException(e.toString());
        } catch (Exception e) {
            logger.info("Exception Occurs in voiceBalance:" + e.toString());
            throw new BSSException(e.toString());
        }
    }

    public BalanceDTO getAllBalance(Long userId) {
        try {
            String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);

            JSONObject jsonData = new JSONObject(staticDataString).getJSONObject(userId.toString());
            logger.info("jsonData:" + jsonData.toString());

            BalanceDTO balanceDTO = new ObjectMapper().readValue(jsonData.toString(), BalanceDTO.class);
            logger.info("balanceDTO:" + balanceDTO.toString());

            return balanceDTO;
        } catch (Exception e) {
            logger.info("Exception Occurs in getAllBalance:" + e.toString());
            throw new BSSException(e.toString());
        }
    }
}
