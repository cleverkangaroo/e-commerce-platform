package com.kangaroo.microservices.provider.base.repository.master.impl;

import com.kangaroo.microservices.provider.base.dao.master.StoreMapper;
import com.kangaroo.microservices.provider.base.model.entity.Store;
import com.kangaroo.microservices.provider.base.repository.master.StoreRepository;
import com.kangaroo.microservices.provider.core.repository.impl.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public class StoreRepositoryImpl extends BaseRepositoryImpl<Store> implements StoreRepository {
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public Mapper<Store> getBaseMapper() {
        return storeMapper;
    }
}