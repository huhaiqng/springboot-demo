package com.hhq.product.service.Impl;
/**
 * @title: UserServiceImpl
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1115:39
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhq.common.Product;
import com.hhq.product.dao.ProductDao;
import com.hhq.product.service.ProductService;

/**
 * @className    : UserServiceImpl
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/11 15:39]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/11 15:39]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product findByPid(Integer pid) {
        return productDao.findById(pid).get();
    }
}