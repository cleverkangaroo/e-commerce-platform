package com.kangaroo.microservices.provider.base.repository.master.impl;

import com.kangaroo.microservices.provider.base.dao.master.ProductMapper;
import com.kangaroo.microservices.provider.base.model.entity.Product;
import com.kangaroo.microservices.provider.base.repository.master.ProductRepository;
import com.kangaroo.microservices.provider.core.repository.impl.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public class ProductRepositoryImpl extends BaseRepositoryImpl<Product> implements ProductRepository {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Mapper<Product> getBaseMapper() {
        return productMapper;
    }
}