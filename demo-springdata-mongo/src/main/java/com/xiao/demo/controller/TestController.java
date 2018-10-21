package com.xiao.demo.controller;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiao.demo.entity.UserInfo;
import com.xiao.demo.service.UserService;
import com.xiao.demo.util.PageModel;

/** 
* @Description: G币服务接口客户端
* @Author: xiaolijun
* @Date: 2018年8月17日
*/
@RestController
public class TestController{
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private UserService service;

    /*@RequestMapping(value = "/payment/{user_id}/exchange/{order_id}", method = RequestMethod.GET)
    public ResponsePacket<JSONObject> consumeGCoin(@PathVariable("order_id") String orderId, @PathVariable("user_id") String userId){
    	logger.debug("打印消费G币兑换星光服务接口-入参信息：" + orderId);
    	JSONObject respJsonObject = gCoinService.consumeGCoin(orderId);
    	logger.debug("打印消费G币兑换星光服务接口-出参信息：" + respJsonObject);
    	return ResponsePacket.onSuccess(respJsonObject);
    }*/

    @RequestMapping(value = "/mongoDBTest", method = RequestMethod.GET)
    public String mongoDBtestTest(){
        logger.debug("打印接口-入参信息：" );
        this.find("5b853bfaaf6dcf16006987de");
        //this.save();
        return "执行完成";
    }
    
	public void save() {
		UserInfo user = new UserInfo();
		user.setName("王五1");
		user.setAge(30);
		user.setBirth(new Timestamp(System.currentTimeMillis()));
		service.save(user);
		System.out.println("已生成ID:" + user.getId());
	}

	public void find(String id) {
		UserInfo user = service.find(id);
		System.out.println(user.getName());
	}

	public void update(String id) {
		UserInfo user = service.find(id);
		user.setAge(18);
		service.update(user);
	}

	public void delete(String id) {
		service.delete(id);
	}

	public void findAll() {
		List<UserInfo> list = service.findAll("age desc");
		for (UserInfo u : list) {
			System.out.println(u.getName());
		}
	}

	public void findByProp() {
		List<UserInfo> list = service.findByProp("name", "张三");
		for (UserInfo u : list) {
			System.out.println(u.getName());
		}
	}

	public void findByProps() {
		List<UserInfo> list = service.findByProps(new String[] { "name", "age" }, new Object[] { "张三", 18 });
		for (UserInfo u : list) {
			System.out.println(u.getName());
		}
	}

	public void pageAll() {
		PageModel<UserInfo> page = service.pageAll(1, 10);
		System.out.println("总记录：" + page.getTotalCount() + "，总页数：" + page.getTotalPage());
		for (UserInfo u : page.getList()) {
			System.out.println(u.getName());
		}
	}

	public void pageByProp() {
		PageModel<UserInfo> page = service.pageByProp(1, 10, "name", "张三");
		System.out.println("总记录：" + page.getTotalCount() + "，总页数：" + page.getTotalPage());
		for (UserInfo u : page.getList()) {
			System.out.println(u.getName());
		}
	}

 

}
