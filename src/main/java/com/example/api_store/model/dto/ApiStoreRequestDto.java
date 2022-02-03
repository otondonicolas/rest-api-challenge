package com.example.api_store.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiStoreRequestDto implements Serializable {
    private static final long serialVersionUID = -4517099985596260163L;
    @JsonProperty("product_item")
    private String productItem;
    @JsonProperty("product_price")
    private Integer productPrice;
    @JsonProperty("product_description")
    private String productDescription;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("is_in_stock")
    private Boolean isInStock;
}
