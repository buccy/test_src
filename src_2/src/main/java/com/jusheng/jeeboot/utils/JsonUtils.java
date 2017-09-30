package com.jusheng.jeeboot.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

/**
 * json转换工具类
 */
public class JsonUtils {
	private static JsonFactory jsonFactory = new JsonFactory();

	private static ObjectMapper mapper = new ObjectMapper(jsonFactory);

	static {
		jsonFactory.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		jsonFactory.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,
				true);
	}

	public static ObjectMapper getMapper() {
		return mapper;
	}

	public static JsonFactory getJsonFactory() {
		return jsonFactory;
	}

	@SuppressWarnings("unchecked")
	public static <T> T toBean(String json, TypeReference<T> refer) {
		Object entity = null;
		try {
			if (!StringUtils.isEmpty(json))
				entity = mapper.reader(refer).readValue(json);
		} catch (Exception ex) {
			LogUtils.logger.error("把json：{} 字符串转成java bean时发生异常。", json);
			throw new IllegalArgumentException("json字符串转成java bean异常", ex);
		}
		return (T) entity;
	}

	@SuppressWarnings("unchecked")
	public static <T> T toBean(String json, Class<T> clazz) {
		Object rtv = null;
		try {
			if (!StringUtils.isEmpty(json))
				rtv = mapper.readValue(json, clazz);
		} catch (Exception ex) {
			LogUtils.logger.error("把json：{} 字符串转成java bean时发生异常。", json);
			throw new IllegalArgumentException("json字符串转成java bean异常", ex);
		}
		return (T) rtv;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> List<T> toBeanList(String json, Class<T> clazz) {
		List result = null;
		try {
			if (!StringUtils.isEmpty(json)) {
				JsonNode jn = mapper.readTree(json);
				result = new ArrayList();
				if (jn.isArray()) {
					Iterator iter = jn.iterator();
					while (iter.hasNext())
						parseBeanAddToList((JsonNode) iter.next(), result,
								clazz);
				} else {
					parseBeanAddToList(jn, result, clazz);
				}
			}
			return result;
		} catch (Exception ex) {
			LogUtils.logger.error("把json：{} 字符串转成java bean时发生异常。", json);
			throw new IllegalArgumentException("json字符串转成java List<bean>异常", ex);
		}
	}

	private static <T> void parseBeanAddToList(JsonNode js, List<T> list,
			Class<T> clazz) throws JsonParseException, JsonMappingException,
			IOException {
		T rtv = mapper.readValue(js.toString(), clazz);
		list.add(rtv);
	}

	public static String toJson(Object bean) {
		String rtv = null;
		try {
			rtv = mapper.writeValueAsString(bean);
		} catch (Exception ex) {
			LogUtils.logger.error("把bean：{} 转成json时发生异常。", bean);
			throw new IllegalArgumentException("java bean转成json字符串异常", ex);
		}
		return rtv;
	}

}
