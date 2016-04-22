package com.mkyong.service;

import java.util.List;

import com.mkyong.dao.NewsDao;

public class NewsService {
	private NewsDao newsDao;
	
	public NewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	public List<String> getNewsList() {
		return newsDao.getNewsList();
		
	}
}
