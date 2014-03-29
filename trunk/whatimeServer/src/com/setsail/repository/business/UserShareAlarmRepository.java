package com.setsail.repository.business;

import java.util.List;

import org.springframework.data.domain.Pageable;
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
	UserShareAlarm findAlarmShareLastByUserUuid(String userUuid);

	/**
	 * 根据useruuid查找UserShareAlarm
	 * @param userUuid
	 * @return
	 */
	List<UserShareAlarm> findUserShareAlarmByUserUuid(String userUuid);
	/**
	 * 根据同步时间获取集合
	 * @param userUuid
	 * @param sync_time
	 * @return
	 */
	@Query(" select ua from UserShareAlarm ua where ua.syncTime > ?2 and ua.userUuid = ?1  ")
	List<UserShareAlarm> findAlarmShareLastBySync(String userUuid, long syncTime);
	
	/**
	 * 根据分类，该提醒的开始时间，截止时间，第几页获取提醒。默认一页20个。按提醒时间（AlarmTime）排序。
	 * @param userUuid
	 * @param integer
	 * @param scope 
	 * @param startTime
	 * @param endTime
	 * @param pr
	 * @return
	 */
	List<UserShareAlarm> findUserShareAlarmByCateIdAndAlarmTimeAfterAndAlarmTimeBeforeOrderByAlarmTimeDesc(
				Integer cateId, Long startTime, Long endTime, Pageable pageable);

	/**
	 * 根据分类，城市，该提醒的开始时间，截止时间，第几页获取提醒。默认一页20个。按提醒时间（AlarmTime）排序。
	 * @param scope
	 * @param cateId
	 * @param startTime
	 * @param endTime
	 * @param pageRequest
	 * @return
	 */
	List<UserShareAlarm> findByScopeAndCateIdAndAlarmTimeAfterAndAlarmTimeBeforeOrderByAlarmTimeDesc(
			String scope, Integer cateId, Long startTime, Long endTime, Pageable pageable);
	
	/**
	 *　描述：根据该提醒的开始时间，截止时间，第几页获取某人的提醒列表。默认一页20个。按提醒时间（AlarmTime）排序。
	 */
	List<UserShareAlarm> findByManUuidAndAlarmTimeAfterAndAlarmTimeBeforeOrderByAlarmTimeDesc(
			String manUuid, Long startTime, Long endTime, Pageable pageable);
}