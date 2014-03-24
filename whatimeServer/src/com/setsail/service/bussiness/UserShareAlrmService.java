package com.setsail.service.bussiness;

import com.setsail.entity.business.UserShareAlarm;
import com.setsail.entity.response.SystemState;

/**
 * 用户分享的service
 * @author snow
 *
 */
public interface UserShareAlrmService {

	/**
	 * 添加活修改用户提醒
	 * @param userShare
	 */
	public SystemState alrmShareAddOrUpdate(UserShareAlarm userShare);

	/**
	 * 删除用户提醒
	 * @param alarm_uuid
	 */
	public SystemState alrmShareDelete(String alarm_uuid);

	/**
	 * 获取最后一次同步时间
	 * @param userUuid
	 * @return
	 */
	public SystemState alrmShareGetLastSyncTime(String userUuid);

}
