package com.setsail.service.bussiness.impl;


/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/wtserver-servlet.xml","/repository.xml"})*/
public class UserShareAlrmServiceImplTest {
	/*
	
	@Resource
	private UserShareAlrmService userShareAlrmService;
	@Resource
	private UserShareAlarmRepository userShareAlarmRepository;

	@Test
	public void testAlrmShareAddOrUpdate() {
		System.out.println("=========");
		String alarm = "{\"alarmTime\":1395502800952,\"createTime\":1395502644604,\"des\":\"vuvuvubu\",\"endTime\":1396107420132,\"froms\":1,\"id\":2,\"isDel\":false,\"isEndJoin\":false,\"open\":true,\"maxJoinNum\":10000,\"share\":\"0\",\"taskId\":2,\"taskUuid\":\"d21e4012-df9e-496f-bf52-f198ff32adf9\",\"tasks\":[{\"address\":\"uguvuv&\",\"alarmId\":2,\"alarmTime\":1395502800952,\"alarmUuid\":\"3bfd19ca-5bc8-48d9-a737-d3095a101504\",\"delayMinute\":1,\"delayOrder\":1,\"delayType\":1,\"des\":\"fyfufuf7\",\"id\":2,\"isDel\":false,\"isOpen\":true,\"music\":\"content://settings/system/alarm_alert\",\"notice\":\"jvjvjvuv\",\"playType\":0,\"repeatType\":1,\"shake\":true,\"title\":\"yufyfyw\",\"uuid\":\"d21e4012-df9e-496f-bf52-f198ff32adf9\"}],\"title\":\"yvyvyv\",\"type\":0,\"uptTime\":1395502690938,\"uuid\":\"3bfd19ca-5bc8-48d9-a737-d3095a101504\"}";
		UserShareAlarm  userShare = JSONObject.parseObject(alarm, UserShareAlarm.class);
		System.out.println("===="+userShare.getAlarmTime());
		userShare.setUptTime((new Date()).getTime());
		userShare.setSyncTime((new Date()).getTime());
		userShare = userShareAlarmRepository.save(userShare);
		
	}

//	@Test
	public void testAlrmShareDelete() {
//		fail("Not yet implemented");
		userShareAlarmRepository.delete("3bfd19ca-5bc8-48d9-a737-d3095a101504");
	}

	public void testAlrmShareGetLastSyncTime() {
		fail("Not yet implemented");
	}
	
	public static void main(String[] args) {
		System.out.println("===");
	}*/

}
