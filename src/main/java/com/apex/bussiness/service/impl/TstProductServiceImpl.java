package com.apex.bussiness.service.impl;

import com.apex.bussiness.entity.Product;
import com.apex.bussiness.service.interfaces.ITstProductService;
import com.apex.presistence.beans.IDGenerator;
import com.apex.presistence.beans.TstProduct;
import com.apex.presistence.mapper.IDGeneratorMapper;
import com.apex.presistence.mapper.TstProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TstProductServiceImpl implements ITstProductService {
    @Autowired
    private TstProductMapper tstProductMapper;
    @Autowired
    private IDGeneratorMapper idGeneratorMapper;

    @Override
    public Product insert(Product entity) {

         if(entity.getId()==null){
             Long id;
             IDGenerator cond=new IDGenerator();
             cond.setName("TST_PRODUCT");
             IDGenerator idGenerator=idGeneratorMapper.selectOne(cond);
             id=idGenerator.getId().longValue()+1;
             idGenerator.setId(id.intValue());
             idGeneratorMapper.updateByPrimaryKey(idGenerator);
             entity.setId(id);
         }
         tstProductMapper.insert(entity.getTstProduct());
        TstProduct tstProduct= tstProductMapper.selectByPrimaryKey(entity.getTstProduct().getId());
        return new Product(tstProduct);
    }

    @Override
    public void insertList(List<Product> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean updateSelective(Product entity) {
        return false;
    }

    @Override
    public Product getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public List<Product> listAll() {
        return null;
    }

    @Override
    public List<Product> listTstProduct() {
        List<TstProduct> tstProducts=  tstProductMapper.selectAll();
        if (CollectionUtils.isEmpty(tstProducts)) {
            return null;
        }
        List<Product> products = new ArrayList<>();
        for (TstProduct tstProduct : tstProducts) {
            products.add(new Product(tstProduct));
        }
        return products;
    }
}
