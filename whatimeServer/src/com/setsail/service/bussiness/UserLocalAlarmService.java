package com.setsail.service.bussiness;

import com.setsail.entity.business.UserLocalAlarm;
import com.setsail.entity.response.SystemState;

/**
 * 用户分享的service
 * @author snow
 *
 */
public interface UserLocalAlarmService {

	/**
	 * 添加活修改用户提醒
	 * @param userLocal
	 */
	public SystemState alarmLocalAddOrUpdate(UserLocalAlarm userLocal);

	/**
	 * 删除用户提醒
	 * @param alarm_uuid
	 */
	public SystemState alarmLocalDelete(String alarm_uuid);

	/**
	 * 获取最后一次同步时间
	 * @param userUuid
	 * @return
	 */
	public SystemState alarmLocalGetLastSyncTime(String userUuid);
	/**
	 * 获取同步信息
	 * @param userUuid
	 * @param sync_time
	 * @return
	 */
	public SystemState alrmLocalSync(String userUuid, long syncTime);

}
