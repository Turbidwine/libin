package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagMapper {
    @Select("SELECT ${tagName} FROM t_customer_campaigntag GROUP BY ${tagName}")
    public List<String> selectTagValueGroupBy(@Param("tagName")String tagName);

    @Select("SELECT Member_ID FROM t_customer_campaigntag WHERE ${tagName}=#{value}")
    public List<String> selectIdByTagValue(@Param("tagName")String tagName,@Param("value")String value);
}
