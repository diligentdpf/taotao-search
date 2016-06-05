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
		// ����һ����ѯ����
		SolrQuery query = new SolrQuery();
		// ���ò�ѯ����
		query.setQuery("*:*");
		query.setStart(20);
		query.setRows(50);
		// ִ�в�ѯ
		QueryResponse response = solrServer.query(query);
		// ȡ��ѯ���
		SolrDocumentList solrDocumentList = response.getResults();
		System.out.println("����ѯ����¼��" + solrDocumentList.getNumFound());
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.print("\t"+solrDocument.get("id"));
			System.out.print("\t" + solrDocument.get("item_title"));
			System.out.print("\t" + solrDocument.get("item_price"));
			System.out.print("\t" + solrDocument.get("item_image"));
			System.out.println();
		}
	}
}
