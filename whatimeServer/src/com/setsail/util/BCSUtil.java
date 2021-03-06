package com.setsail.util;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.Part;

import com.baidu.inf.iis.bcs.BaiduBCS;
import com.baidu.inf.iis.bcs.auth.BCSCredentials;
import com.baidu.inf.iis.bcs.http.HttpMethodName;
import com.baidu.inf.iis.bcs.model.ObjectMetadata;
import com.baidu.inf.iis.bcs.request.GenerateUrlRequest;
import com.baidu.inf.iis.bcs.request.PutObjectRequest;
import com.baidu.inf.iis.bcs.response.BaiduBCSResponse;

public final class BCSUtil {

	private static final String host = "bcs.duapp.com";
	private static final String accessKey = "W3ORf32x3RjCEDSgE0XAYin0";
	private static final String secretKey = "0rM4BVjVdPsRt9QHed4lBe3cLgcgf5sU";
	private static final String bucket = "wtfile";
	//static String object = "/first-object";
	//static File destFile = new File("E:" + File.separator +"test.txt");
	
	
	public static final String FILE_TYPE_IMG = "IMG";
	public static final String FILE_TYPE_APK = "APK";
	/*头像文件夹*/
	public static final String TITLE_IMG = "/title-image/";
	/*客户端安装文件*/
	public static final String APK = "/apk/";

	public static final BaiduBCS getBaiduBCS(){
		BCSCredentials credentials = new BCSCredentials(accessKey, secretKey);
		BaiduBCS baiduBCS = new BaiduBCS(credentials, host);
		baiduBCS.setDefaultEncoding("UTF-8"); // Default UTF-8
		return baiduBCS;
	}
	
	public static final ObjectMetadata getObjectMetadata(BaiduBCS baiduBCS, String object) {
		ObjectMetadata objectMetadata = baiduBCS.getObjectMetadata(bucket, object).getResult();
		return objectMetadata;
	}
	
	public static final String generateUrl(String object) {
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, bucket, object);
		//generateUrlRequest.setBcsSignCondition(new BCSSignCondition());
		//generateUrlRequest.getBcsSignCondition().setIp("1.1.1.1");
		//generateUrlRequest.getBcsSignCondition().setTime(123455L);
		//generateUrlRequest.getBcsSignCondition().setSize(123455L);
		//System.out.println(getBaiduBCS().generateUrl(generateUrlRequest));
		return getBaiduBCS().generateUrl(generateUrlRequest);
	}
	
	public static void deleteObject(String object) {
		getBaiduBCS().deleteObject(bucket, object).getResult();
	}
	
	public static void deleteObject(BaiduBCS bcs, String object) {
		bcs.deleteObject(bucket, object).getResult();
	}
	
	public static final String putObject(Part part, String ft, String OldObject) throws IOException {
		BaiduBCS baiduBCS = getBaiduBCS();
		String ObjectKey = null;
		ObjectMetadata metadata = new ObjectMetadata();
		if(FILE_TYPE_IMG.equalsIgnoreCase(ft)){
			ObjectKey = TITLE_IMG + UUID.randomUUID().toString();
			OldObject = TITLE_IMG + OldObject;
			metadata.setContentType(part.getContentType());
		}
		if(FILE_TYPE_APK.equalsIgnoreCase(ft)){
			ObjectKey = APK + getFileName(part);
			OldObject = APK + OldObject;
			metadata.setContentType("application/vnd.android.package-archive");
		}
		
		if(ObjectKey != null){
			metadata.setContentLength(part.getSize());
			
			PutObjectRequest request = new PutObjectRequest(bucket, ObjectKey, part.getInputStream(), metadata);
			BaiduBCSResponse<ObjectMetadata> response = baiduBCS.putObject(request);
			ObjectMetadata objectMetadata = response.getResult();
			if(objectMetadata != null && !objectMetadata.getVersionId().isEmpty()){
				
				try {
					if(OldObject != null)
						deleteObject(baiduBCS, OldObject);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return request.getObject();
			}
		}
		return null;
	}
	
	/** 
     * 从Part的Header信息中提取上传文件的文件名 
     * @param part 
     * @return  上传文件的文件名，如果如果没有则返回null 
     */  
    private static String getFileName(Part part){  
        //获取header信息中的content-disposition，如果为文件，则可以从其中提取出文件名  
    	String h = part.getHeader("content-disposition");
    	String filename = h.substring(h.lastIndexOf("\\") + 1, h.length() - 1);
    	return SstringUtils.isEmpty(filename) ? UUID.randomUUID().toString() : filename;
  
    } 
}
