package zane49er.VolkiharEchoes.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import zane49er.VolkiharEchoes.main.References;

public class Util {

	public static Logger logger;

	public static Logger getLogger() {
		if (logger == null){
			logger = LogManager.getFormatterLogger(References.MODID);
		}
		return logger;
	}

}
