package diao.taotao.search.service;

import diao.taotao.search.pojo.SearchResult;

public interface SearchService {
	public SearchResult search(String queryString, int page, int rows) throws Exception;
}
