package com.practice.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.practice.dto.BookDto;

@Mapper
public interface BookDao {
	@Select("select * from booktbl where id=#{id}")
	Optional<BookDto> findById(int id);

	@Insert("insert into booktbl (title,author,publishedDate,price) "
			+ "values(#{title},#{author},#{publishedDate},#{price})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	void save(BookDto book);

	void update(@Param("id") int id, @Param("requestBook") BookDto requestBook);

	@Delete("DELETE FROM booktbl WHERE id = #{id}")
	void delete(int id);
}
