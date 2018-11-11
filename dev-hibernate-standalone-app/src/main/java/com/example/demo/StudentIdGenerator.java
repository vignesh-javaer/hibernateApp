package com.example.demo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;


public class StudentIdGenerator implements IdentifierGenerator {
	
	
	private static Integer sequNum;
	
	static {
		final Random rm = new Random();
		sequNum = rm.ints(0, 999).findFirst().getAsInt();
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

			final String dateFmt = getDateByYYYYMMDDHHMMSS();
			final String genSeq = dateFmt.concat(sequNum+"");
			return Long.valueOf(genSeq);
	}
	
	public static String getDateByYYYYMMDDHHMMSS() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		return sdf.format(date);
	}
}
