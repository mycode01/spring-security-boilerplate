package com.eduai.intodevice.mapper.member;

import com.eduai.intodevice.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper {
    Member getById(@Param("id") Long id);

    Member getByUserId(@Param("uId") String uId);
}
