package co.uk.netpod.application.model;

import lombok.Data;

import java.util.Map;

@Data
public class MarketDate {
    private Map<String, String> price;
    private long timestamp;
}
