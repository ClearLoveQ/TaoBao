package cn.tedu.store.mapper;
/**
 * 用户权限管理持久层
 * @author soft01
 *
 */
public interface PowerMapper {
	/**
	 * 根据用户的id,查询他的权限
	 * @param id
	 * @return
	 */
	public int backPower(Integer id);
}