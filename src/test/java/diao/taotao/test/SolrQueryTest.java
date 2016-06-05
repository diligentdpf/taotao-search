package diao.taotao.test;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

public class SolrQueryTest {
	private static String url = "http://192.168.1.193:8080/solr";

	@Test
	public void queryDocument() throws Exception {
		SolrServer solrServer = new HttpSolrServer(url);
		// 创建一个查询对象
		SolrQuery query = new SolrQuery();
		// 设置查询条件
		query.setQuery("*:*");
		query.setStart(20);
		query.setRows(50);
		// 执行查询
		QueryResponse response = solrServer.query(query);
		// 取查询结果
		SolrDocumentList solrDocumentList = response.getResults();
		System.out.println("共查询到记录：" + solrDocumentList.getNumFound());
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.print("\t"+solrDocument.get("id"));
			System.out.print("\t" + solrDocument.get("item_title"));
			System.out.print("\t" + solrDocument.get("item_price"));
			System.out.print("\t" + solrDocument.get("item_image"));
			System.out.println();
		}
	}
}
