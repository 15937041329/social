package com.cn.dao.mapper;

import com.cn.Utils.Token;
import org.mapstruct.Mapper;

/**
 * 〈
 * 〈〉
 *
 * @author
 * @create 2019/8/20
 */
@Mapper
public interface  TokenMapper {


    Token findByUserId(int userid);

}

