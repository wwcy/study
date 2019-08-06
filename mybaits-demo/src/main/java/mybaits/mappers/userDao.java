package mybaits.mappers;

import java.util.List;

import mybaits.entity.Orders;
import mybaits.entity.UacUser;
import org.apache.ibatis.annotations.Select;

import mybaits.entity.User;

public interface userDao {
	
	List<Orders> findOrdersByLazyLoad();

	UacUser findByLoginName(String loginName);
}
