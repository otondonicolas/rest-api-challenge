package com.example.api_store.model.dto;

import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductDTOTest {

    @Test
    void productDtoPojoValidator() {

        final Validator pojoValidator =
                ValidatorBuilder.create()
                        .with(new GetterMustExistRule())
                        .with(new GetterTester())
                        .with(new SetterTester())
                        .build();

        pojoValidator.validate(PojoClassFactory.getPojoClass(ProductDTO.class));

        assertNotNull(pojoValidator);
    }

    @Test
    void productDtoTest() {
        ProductDTO productDTO = ProductDTO.builder().build();
        productDTO.toString();

        ProductDTO productDtoNoArgs = new ProductDTO();

        assertNotNull(productDTO);
        assertNotNull(productDtoNoArgs);
    }
}