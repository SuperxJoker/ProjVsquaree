package com.example.bnrapp.controllers;

import com.example.bnrapp.entity.CurrencyConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class CurrencyController {

    @GetMapping("/currencies/{date}")
    public ResponseEntity<String> getCurrencies(@PathVariable String date) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://www.bnr.ro/nbrfxrates.xml?date=" + date;
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        try {
            XmlMapper xmlMapper = new XmlMapper();
            JsonNode node = xmlMapper.readTree(response.getBody().getBytes());
            ObjectMapper jsonMapper = new ObjectMapper();
            String json = jsonMapper.writeValueAsString(node);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}


