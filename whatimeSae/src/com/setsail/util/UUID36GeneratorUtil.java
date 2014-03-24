/**
 * 
 */
package com.setsail.util;

import java.io.Serializable;
import java.util.Properties;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;
import org.hibernate.util.PropertiesHelper;

public class UUID36GeneratorUtil implements IdentifierGenerator, Configurable {
	@SuppressWarnings("unused")
	private String sep = "";
	
	public Serializable generate(SessionImplementor session, Object obj) throws HibernateException {
		return UUID.randomUUID().toString().toUpperCase();
	}
	
	public void configure(Type type, Properties params, Dialect dialect) throws MappingException {
		sep = PropertiesHelper.getString("separator", params, "");
	}
	
	/*
	
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "com.setsail.util.UUID36GeneratorUtil")
	
	*/


}
