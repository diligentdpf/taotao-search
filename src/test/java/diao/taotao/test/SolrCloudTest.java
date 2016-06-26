package diao.taotao.test;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrCloudTest {
	@Test
	public void testAddDocument() throws Exception {
		// 创建一个和solr集群的连接
		// 参数是zookeeper的地址列表，使用逗号分隔，这里注意linux里的iptables,要开放这三个端口，或者直接close iptables
		String zkHost = "192.168.1.193:2181,192.168.1.193:2182,192.168.1.193:2183";
		CloudSolrServer solrServer = new CloudSolrServer(zkHost);
		// 设置默认的collection(索引集合)
		solrServer.setDefaultCollection("collection2");
		// 创建一个文档对象，用于插入
		SolrInputDocument document = new SolrInputDocument();
		// 向文档中添加域
		document.addField("id", "test0011");
		document.addField("item_title", "测试商品");
		// 把文档添加到索引库
		solrServer.add(document);
		// 提交
		solrServer.commit();
	}

	@Test
	public void deleteDocument() throws SolrServerException, IOException {
		// 创建一个和solr集群的连接
		// 参数就是zookeeper的地址列表，使用逗号分隔
		String zkHost = "192.168.1.193:2181,192.168.1.193:2182,192.168.1.193:2183";
		CloudSolrServer solrServer = new CloudSolrServer(zkHost);
		// 设置默认的collection
		solrServer.setDefaultCollection("collection2");

		solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}
}
