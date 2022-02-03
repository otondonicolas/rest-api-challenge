package com.example.api_store.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -4335373524136185226L;
    @JsonProperty("product_id")
    private Long productId;
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
