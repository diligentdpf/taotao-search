package diao.taotao.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import diao.taotao.search.pojo.SearchResult;

public interface SearchDao {
	public SearchResult search(SolrQuery query) throws Exception;
}
