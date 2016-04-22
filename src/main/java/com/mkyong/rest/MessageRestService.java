package com.mkyong.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.dao.StringUtil;
import com.mkyong.service.NewsService;

@Path("/message")
public class MessageRestService {

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();

	}
	@GET
	@Path("/getNewsList")
	public Response getNewsList() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");

		NewsService newsService = (NewsService) context.getBean("newsService");
		List<String> list = newsService.getNewsList();
		System.out.println(StringUtil.print(list));
		String result = "Restful example : " + StringUtil.print(list);

		return Response.status(200).entity(result).build();

	}
}