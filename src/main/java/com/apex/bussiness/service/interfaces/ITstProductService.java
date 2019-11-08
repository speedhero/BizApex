package com.apex.bussiness.service.interfaces;

import com.apex.bussiness.entity.Product;
import com.apex.bussiness.framework.object.AbstractService;

import java.util.List;


public interface ITstProductService  extends AbstractService<Product, Long> {

    public List<Product> listTstProduct();
}
