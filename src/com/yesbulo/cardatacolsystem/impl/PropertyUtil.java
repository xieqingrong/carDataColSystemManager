package com.yesbulo.cardatacolsystem.impl;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.xwork.StringUtils;

/**
 * 读取配置文件
 */
/**
 * <p>@Title:PropertyUtil</P>
 * <p>@Description:carDataColSystem</P>
 * <p>@Company: RongleXie </P>
 * <p>@author xieqingrong</p>
 * <p>@date 2016-9-24 下午05:58:56</p>
 */
public class PropertyUtil {

	private static String url;

	private static Properties properties = new Properties();

	@SuppressWarnings("unused")
	private PropertyUtil() {
	}// 屏蔽无参构造

	public PropertyUtil(String url) {
		PropertyUtil.url = url;
		loadProperty();
	}

	public void loadProperty() {
		try {
			properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(url));
		} catch (IOException e) {
			System.out.println("读取配置文件" + url + "出错：" + e.getMessage());
		}
	}

	/**
	 * 获取值
	 * 
	 * @param key
	 *            配置文件的键
	 * @return 配置文件的值
	 */
	public String getPropertyValue(String key) {
		String value = (String) properties.get(key);
		if (StringUtils.isNotEmpty(value)) {
			return value;
		} else {
			return "";
		}

	}
}