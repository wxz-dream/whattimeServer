package com.setsail.repository.business;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.setsail.entity.business.UserShareAlarm;

public interface UserShareAlarmRepository extends PagingAndSortingRepository<UserShareAlarm, String> {

	/**
	 * 查找更新时间最大的UserShareAlarm
	 * @param userUuid
	 * @return
	 */
	@Query(" select ua from UserShareAlarm ua where ua.uptTime = (select max(u.uptTime)  from UserShareAlarm u where u.userUuid = ?1 ) and ua.userUuid = ?1  ")
	UserShareAlarm findAlrmShareLastByUserUuid(String userUuid);

	/**
	 * 根据useruuid查找UserShareAlarm
	 * @param userUuid
	 * @return
	 */
	List<UserShareAlarm> findUserShareAlarmByUserUuid(String userUuid);
	
	
}