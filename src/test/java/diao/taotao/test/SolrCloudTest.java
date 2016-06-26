package diao.taotao.test;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrCloudTest {
	@Test
	public void testAddDocument() throws Exception {
		// ����һ����solr��Ⱥ������
		// ������zookeeper�ĵ�ַ�б�ʹ�ö��ŷָ�������ע��linux���iptables,Ҫ�����������˿ڣ�����ֱ��close iptables
		String zkHost = "192.168.1.193:2181,192.168.1.193:2182,192.168.1.193:2183";
		CloudSolrServer solrServer = new CloudSolrServer(zkHost);
		// ����Ĭ�ϵ�collection(��������)
		solrServer.setDefaultCollection("collection2");
		// ����һ���ĵ��������ڲ���
		SolrInputDocument document = new SolrInputDocument();
		// ���ĵ��������
		document.addField("id", "test0011");
		document.addField("item_title", "������Ʒ");
		// ���ĵ���ӵ�������
		solrServer.add(document);
		// �ύ
		solrServer.commit();
	}

	@Test
	public void deleteDocument() throws SolrServerException, IOException {
		// ����һ����solr��Ⱥ������
		// ��������zookeeper�ĵ�ַ�б�ʹ�ö��ŷָ�
		String zkHost = "192.168.1.193:2181,192.168.1.193:2182,192.168.1.193:2183";
		CloudSolrServer solrServer = new CloudSolrServer(zkHost);
		// ����Ĭ�ϵ�collection
		solrServer.setDefaultCollection("collection2");

		solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}
}
