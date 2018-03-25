package com.company.project.common.dao;

import com.company.project.common.page.AbstractPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MAPPER基类
 * @author jeffloo
 *
 * @param <T> 实体
 */
public interface BaseDao<T> {
	/**
	 * 查询所有信息
	 * @return List<T> 记录集
	 */
	public List<T> findAll();
	/**
	 * 主键获取记录
	 * @param id 主键
	 * @return T 记录
	 */
	public T getById(@Param("id") long id);
	/**
	 * 获取单挑记录
	 * @param t 过滤信息
	 * @return T 记录
	 */
	public T get(T t);
	/**
	 * 添加记录
	 * @param t 添加信息
	 * @return int 返回值
	 */
	public int insert(T t);
	/**
	 * 批量添加
	 * @param list 添加信息
	 */
	void batchAdd(List<T> list);
	/**
	 * 修改记录
	 * @param t 需要修改信息
	 * @return int 返回值
	 */
	public int update(T t);
	/**
	 * 删除记录
	 * @param id 主键ID
	 */
	public void delete(@Param("id") long id);
	/**
	 * 分页查询
	 * @param page 分页信息
	 * @return List<T> 记录集
	 */
	public List<T> findPage(AbstractPage page);
	/**
	 * 条件查询
	 * @param t 过滤条件
	 * @return List<T> 记录集
	 */
	public List<T> findList(T t);
}
