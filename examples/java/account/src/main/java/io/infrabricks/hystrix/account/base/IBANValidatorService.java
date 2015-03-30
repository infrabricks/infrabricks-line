package io.infrabricks.hystrix.account.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

// tag::classdef[]
public class IBANValidatorService {

    private static Logger LOG = LoggerFactory.getLogger(IBANValidatorService.class);

    public static boolean isValid(Account account) throws Exception {
      String baseURL = System.getenv("validator.url");
      if(baseURL == null || "".equals(baseURL)) {
          baseURL = "http://validator:8080/" ;
      }
      String url = baseURL + "iban?number=" + account.getIban();

      URL ibanUrl = new URL(url);
      HttpURLConnection con = (HttpURLConnection) ibanUrl.openConnection();
      if(con != null) {
        con.setRequestMethod("GET");
        if( con.getResponseCode() == 200 ) {
          BufferedReader in = null;
          try {
            in = new BufferedReader(
              new InputStreamReader(con.getInputStream()));
            String content;
            StringBuffer response = new StringBuffer();

            while ((content = in.readLine()) != null) {
              response.append(content);
            }
            if( response.length() > 0) {
              LOG.info(response.toString());
              ObjectMapper mapper = new ObjectMapper();
              JsonNode actualObj = mapper.readValue(response.toString(), JsonNode.class);
              if ( actualObj != null ) {
                JsonNode validObj =  actualObj.get("valid");
                if(null != validObj && validObj.isBoolean()) {
                  return validObj.booleanValue();
                }
              }
            }
          } catch ( Exception e) {
            LOG.error("problem with isValid", e);
          } finally {
             if( in != null) in.close();
          }
        }
      }
      return false;
    }
}
// end::classdef[]
