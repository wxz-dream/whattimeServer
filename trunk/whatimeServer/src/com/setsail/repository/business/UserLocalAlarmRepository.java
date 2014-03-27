package com.setsail.repository.business;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.setsail.entity.business.UserLocalAlarm;

public interface UserLocalAlarmRepository extends PagingAndSortingRepository<UserLocalAlarm, String> {
	/**
	 * 查找更新时间最大的UserLocalAlarm
	 * @param userUuid
	 * @return
	 */
	@Query(" select ua from UserLocalAlarm ua where ua.uptTime = (select max(u.uptTime)  from UserLocalAlarm u where u.userUuid = ?1 ) and ua.userUuid = ?1  ")
	UserLocalAlarm findAlarmLocalLastByUserUuid(String userUuid);

	/**
	 * 根据useruuid查找UserLocalAlarm
	 * @param userUuid
	 * @return
	 */
	List<UserLocalAlarm> findUserLocalAlarmByUserUuid(String userUuid);
}