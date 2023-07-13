package com.bookshop.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Geolocation implements Serializable {
    BigDecimal longitude, latitude;
}
