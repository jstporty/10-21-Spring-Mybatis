package kr.kwangan2.test;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kwangan2.domain.Author;
import kr.kwangan2.domain.Blog;
import kr.kwangan2.domain.Comm;
import kr.kwangan2.domain.CommSearcher;

public class BlogTest {
	public static void main(String[] args) {
		String resource = "kr/kwangan2/conf/sqlMapConfig.xml";
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMapper.openSession();

			List<Blog> blogs = session.selectList("selectBlog");

			for (Blog blog : blogs) {
				System.out.println("--------------------------------------");
				System.out.println("blog id : " + blog.getBlogId());
				Author author = blog.getAuthor();
				System.out.println("\t" + author);
				List<Comm> comms = blog.getComms();
				for (Comm comm : comms) {
					System.out.println("\t" + comm);
				}
				System.out.println("--------------------------------------");
			}

//			// insert
//			Author author = new Author();
//			author.setAuthorId(2);
//			author.setAuthorName("하...이름 인서트.....ㅋ ㅠㅠ");
//			int result = session.insert("insertAuthor", author);
//			session.commit();
//			if (result > 0) {
//				System.out.println(author + "author 인서트 성공");
//			}

//			// update
//			Author author = new Author();
//			author.setAuthorId(2);
//			author.setAuthorName("하.. 업데이트 성공...? 했니? ㅋ");
//			int result3 = session.update("updateAuthor", author);
//			session.commit();
//			if (result3 > 0) {
//				System.out.println("업데이트 성공 예~");
//			}
			
			//delete
			Author author = new Author();
			int result3 = session.delete("deleteAuthor", 3);
			session.commit();
			if (result3 > 0) {
				System.out.println("삭제 ㅋ 성공 예~");
			}

//			CommSearcher commSearcher = new CommSearcher();
//			commSearcher.setBlogId(2);
//			commSearcher.setSearchKey("content");
//			commSearcher.setSearchValue("comm");
//			List<Comm> comms = session.selectList("selectCommsByBlogId", commSearcher);
//			for (Comm comm : comms) {
//				System.out.println(comm);
//			}
//			Comm comm = new Comm();
//			comm.setCommId(3);
//			comm.setCommTitle("update title");
//			comm.setCommContent("update content");
//			comm.setFkBlogId(3);
//			int result = session.update("updateComm", comm);
//			if (result > 0) {
//				System.out.println("업데이트 성공");
//			}
//			ArrayList<Integer> commIdlist = new ArrayList<Integer>();
//			commIdlist.add(2);// blog_id
//			commIdlist.add(2);
//			commIdlist.add(3);
//			commIdlist.add(21);
//			List<Comm> commList = session.selectList("selectCommsByCommIds", commIdlist);
//			for (Comm comm2 : commList) {
//				System.out.println(comm2);
//			}
			session.commit();
		} catch (Exception e) {
			// session.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
}