package com.dao;

import com.pojo.Tatalfile;
import com.pojo.TatalfileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TatalfileMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TatalfileExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TatalfileExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TatalfileExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TatalfileExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param totalfileId [Integer](主键属性)文件总表编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("totalfileId") Integer totalfileId);

	/**
	 * 插入单条数据
	 *
	 * @param record [Tatalfile]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(Tatalfile record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [Tatalfile]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(Tatalfile record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TatalfileExample]自定义条件
	 * @return [List<Tatalfile>]符合自定义条件的数据
	 */
	List<Tatalfile> selectByExample(TatalfileExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param totalfileId [Integer](主键属性)文件总表编号
	 * @return [Tatalfile]查询结果
	 */
	Tatalfile selectByPrimaryKey(@Param("totalfileId") Integer totalfileId);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [Tatalfile]数据对象，用于指定修改属性
	 * @param example [TatalfileExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") Tatalfile record, @Param("example") TatalfileExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [Tatalfile]数据对象，用于指定修改属性
	 * @param example [TatalfileExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") Tatalfile record, @Param("example") TatalfileExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [Tatalfile]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(Tatalfile record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [Tatalfile]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(Tatalfile record);

}