package taobao;

import java.util.ArrayList;
import java.util.List;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Test;

public class LuenceTest {
	/**
	 * 采集文件系统中的文档数据，放入Lucene中
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIndexCreate() throws Exception {
		List<Document> docList = new ArrayList<Document>();

		// //指定文件目录
		// File dir = new File("/home/soft01/桌面/lue");
		// //循环文件夹，取出文件
		// for(File file:dir.listFiles()) {
		// String fileName = file.getName();
		// String fileContext = FileUtils.readFileToString(file);
		// Long fileSize = FileUtils.sizeOf(file);
		// 文件系统中的一个文件就是一个document对象
		Document doc = new Document();
		// 第一个参数叫做域名，第二个参数叫做域值，第三个参数是否存储，yes/no
		TextField username = new TextField("fileName", "apache", Store.YES);
		TextField password = new TextField("fileContext", "内容", Store.YES);
		TextField email = new TextField("fileSize", "999".toString(), Store.YES);
		
		// 将所有的域都存入文档中
		doc.add(username);
		doc.add(password);
		doc.add(email);

		docList.add(doc);
		// 创建分词器,StandardAnalyzer是一个标准分词器，对英文效果好，对中文单字分词
		Analyzer analyzer = new StandardAnalyzer();

		// 指定索引和文档的目录
		// RAMDirectory:内存,FSDirectory:磁盘
		Directory directory = new RAMDirectory();

		// 创建写对象的初始化对象
		IndexWriterConfig config = new IndexWriterConfig(analyzer);

		// 创建索引写对象
		IndexWriter indexWriter = new IndexWriter(directory, config);
		for (Document doc1 : docList) {
			indexWriter.addDocument(doc1);
		}

		// 提交
		indexWriter.commit();
		indexWriter.close();

		// ************************************************************************
		// 搜索
		// 创建分词器：创建索引和搜索时用的分词器一致
		// Analyzer analyzer = new StandardAnalyzer();

		// 创建查询对象,第一个参数是默认搜索域，第二个参数是分词器
		// 默认搜索域的作用：如果搜索语法中指定域名从指定域中搜索，如果搜索时只写了查询关键字，则从默认搜索域中搜索
		QueryParser queryParser = new QueryParser("fileContext", analyzer);

		// 查询语法=域名：搜素的关键字
		Query query = queryParser.parse("fileName:apache");

		// 指定索引和文档的目录
		// Directory dir = FSDirectory.open(new File("D:\\luceneTest"));
		// 创建索引和文档读取对象
		IndexReader indexReader = DirectoryReader.open(directory);
		// 创建索引搜索对象
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		// 第一个参数为查询语句对象，第二为显示的条数
		TopDocs topDocs = indexSearcher.search(query, 10);

		// 从搜索结果对象中获取结果集
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			// 获取docID
			int docID = scoreDoc.doc;
			// 通过文档ID从硬盘读取出相应的文档
			Document document = indexReader.document(docID);
			// get域名可以取出值打印
			System.out.println("dasdsad"+document.get("fileSize"));
			// System.out.println("fileSize" + document.get("ema"));

			System.out.println("===============================");
		}
	}
}
