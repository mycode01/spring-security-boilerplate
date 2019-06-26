package com.example.mybatis.mapper;

import com.example.mybatis.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper {
    Member getById(@Param("id") Long id);

    Member getByUserId(@Param("uId") String uId);
}
