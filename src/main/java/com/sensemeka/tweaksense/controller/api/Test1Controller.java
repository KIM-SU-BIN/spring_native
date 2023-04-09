package com.sensemeka .tweaksense.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import com.sensemeka .tweaksense.*;
import com.sensemeka .tweaksense.model.Test1Model;


@RestController
@RequestMapping("/api")
public class Test1Controller {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	DataSource dataSource;

	@RequestMapping(value = "/get_data.do", method = RequestMethod.POST)
	public Map<String, Object> getData(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestParam Map<String, String> body) {
		logger.info("req: /api/get_data.do");

		int nErrorCode = ErrorCode.NO_ERROR;
		Map<String, Object> map = new HashMap<String, Object>();

		String strId = body.get("id");

		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		Test1Model test1Model = new Test1Model(new DbManager(dataSource));
		nErrorCode = test1Model.getData(data, strId);

		map.put("errCode", nErrorCode);
		map.put("data", data);

		return map;
	}

	@RequestMapping(value = "/add_data.do", method = RequestMethod.POST)
	public Map<String, Object> addTest1(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestParam Map<String, String> body) {
		logger.info("req: /api/add_data.do" + body);

		int nErrorCode = ErrorCode.NO_ERROR;
		Map<String, Object> map = new HashMap<String, Object>();

		String strTestData = body.get("test_data");
		if (strTestData == null || strTestData.isEmpty()) {
			map.put("errCode", ErrorCode.INVALID_PARAMETER);
			return map;
		}
		
		Test1Model test1Model = new Test1Model(new DbManager(dataSource));
		nErrorCode = test1Model.addData(strTestData);

		map.put("errCode", nErrorCode);

		return map;
	}

	@RequestMapping(value = "/modify_data.do", method = RequestMethod.POST)
	public Map<String, Object> modifyData(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestParam Map<String, String> body) {
		logger.info("req: /api/modify_data.do" + body);

		int nErrorCode = ErrorCode.NO_ERROR;
		Map<String, Object> map = new HashMap<String, Object>();

		String strId = body.get("id");
		if (strId == null || strId.isEmpty()) {
			map.put("errCode", ErrorCode.INVALID_PARAMETER);
			return map;
		}

		String strTestData = body.get("test_data");
		if (strTestData == null || strTestData.isEmpty()) {
			map.put("errCode", -1);
			return map;
		}
		
		Test1Model test1Model = new Test1Model(new DbManager(dataSource));
		nErrorCode = test1Model.modifyData(strId, strTestData);
		
		map.put("errCode", nErrorCode);

		return map;
	}

	@RequestMapping(value = "/delete_data.do", method = RequestMethod.POST)
	public Map<String, Object> deleteData(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestParam Map<String, String> body) {
		logger.info("req: /api/delete_data.do" + body);

		int nErrorCode = ErrorCode.NO_ERROR;
		Map<String, Object> map = new HashMap<String, Object>();

		String strId = body.get("id");
		if (strId == null || strId.isEmpty()) {
			map.put("errCode", ErrorCode.INVALID_PARAMETER);
			return map;
		}
		
		Test1Model test1Model = new Test1Model(new DbManager(dataSource));
		nErrorCode = test1Model.deleteData(strId);
		
		map.put("errCode", nErrorCode);

		return map;
	}
}
