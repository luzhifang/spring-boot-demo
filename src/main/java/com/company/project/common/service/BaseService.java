package com.company.project.common.service;

import com.company.project.common.dao.BaseDao;
import com.company.project.common.page.AbstractPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * service基类
 * @author jeffloo
 *
 * @param <M> MAPPER
 * @param <T> 实体
 */
@Transactional(readOnly = true)
public abstract class BaseService<M extends BaseDao<T>, T> {
	
	@Autowired
	private M mapper;

	/**
	 * 查询所有信息
	 * @return List<T> 记录集
	 */
	public List<T> findAll(){
		return mapper.findAll();
	}
	/**
	 * 查询部分信息
	 * @param t 过滤信息
	 * @return List<T> 记录集
	 */
	public List<T> findList(T t){
		List<T> list = list = mapper.findList(t);
		return list;
	}
	/**
	 * 主键获取记录
	 * @param id 主键
	 * @return T 记录
	 */
	public T getById(long id){
		return mapper.getById(id);
	}
	/**
	 * 获取单条记录
	 * @param t 过滤信息
	 * @return T 记录
	 */
	public T get(T t){
		return mapper.get(t);
	}
	/**
	 * 添加记录
	 * @param t 添加信息
	 * @return int 返回值
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public int insert(T t){
		return mapper.insert(t);
	}
	/**
	 * 修改记录
	 * @param t 需要修改信息
	 * @return int 返回值
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public int update(T t){
		return mapper.update(t);
	}
	/**
	 * 删除记录
	 * @param id 主键ID
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void delete(long id){
		mapper.delete(id);
	}
	/**
	 * 分页查询
	 * @param page 分页信息
	 * @return Page<T> 分页信息
	 */
	public PageInfo<T> findPage(AbstractPage page){
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<T> list  = mapper.findPage(page);
		return new PageInfo<>(list);
	}
}
