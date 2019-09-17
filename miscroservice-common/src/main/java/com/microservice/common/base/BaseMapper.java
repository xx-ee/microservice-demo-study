package com.microservice.common.base;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;

/**
 * @ProjectName: student-demo
 * @Package: com.practice.common.base
 * @ClassName: BaseMapper
 * @Author: dong
 * @Description: ${description}
 * @Date: 2019/9/11 19:29
 * @Version: 1.0
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, RowBoundsMapper<T>, IdsMapper<T> {
}
