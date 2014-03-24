package com.setsail.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.FastArrayList;

/**
 * 自动生成持久层接口
 * @author 亚杰
 *
 */
public class RFile {

	public static void main(String[] args) {
		//实体类所在文件夹
		String rURL = "E:/zyj/workspace/whatimeserver/whatimeServer/src/com/setsail/entity/business";
		//实体类包名
		String ePackageName = "com.setsail.entity.business";
		//持久层所在文件夹
		String wURL = "E:/zyj/workspace/whatimeserver/whatimeServer/src/com/setsail/repository/business";
		//持久层包名
		String packageName = "com.setsail.repository.business";
		//排除的实体类
		FastArrayList noIncludes = new FastArrayList(10);
		noIncludes.add("package-info");
		//noIncludes.add("User");
		
		//读取所有实体类
		List<String> entitys = readFile(rURL, noIncludes);
		
		for(String str : entitys){
			System.out.println(str);
			//类内容
			StringBuilder content = getFileContent(packageName, ePackageName, str);
			//生成持久层接口
			writeFile(wURL, str + "Repository", content);
		}
	}
	
	public static StringBuilder getFileContent(String packageName, String ePackageName, String className){
		
		StringBuilder content = new StringBuilder(1000);
		content.append("package ").append(packageName).append(";\n");
		content.append("\n");
		content.append("import org.springframework.data.repository.PagingAndSortingRepository;\n");
		content.append("\n");
		content.append("import ").append(ePackageName).append(".").append(className).append(";\n");
		content.append("\n");
		content.append("public interface ").append(className)
				.append("Repository extends PagingAndSortingRepository<")
				.append(className).append(", String> {");
		content.append("\n");
		content.append("}");
		return content;
	}
	
	public static List<String> readFile(String url, FastArrayList noIncludes){
		
		List<String> rfiles = new ArrayList<String>();
		File rfile = new File(url);
		if(rfile.isDirectory()){
			File[] files = rfile.listFiles();
			
			for(File f : files){
				
				String className = f.getName();
				if(SstringUtils.isNotBlank(className)){
					
					className = className.substring(0, className.indexOf("."));
//					System.out.println(className);
					if(!noIncludes.contains(className))
						rfiles.add(className);
				}
			}
		}
		return rfiles;
	}

	public static void writeFile(String url, String fileName,
			StringBuilder content) {

		FileOutputStream out = null;
		try {
			
			File file = new File(url);
			if(!file.exists()) file.mkdir();
			file = new File(url + "/" + fileName + ".java");
			
			if(file.exists()){
				
				System.out.println(url + "/" + fileName + ".java 已经存在");
				return;
			}
			out = new FileOutputStream(file);
			out.write(content.toString().getBytes());
			out.close();


		} 
		catch (Exception e) {

			e.printStackTrace();
		}
		finally {

			try {

				if(out != null)
					out.close();
			} 
			catch (Exception e) {

				e.printStackTrace();
			}

		}
	}

}