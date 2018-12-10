package indiesker.java110.ms.service;

import java.util.List;
import indiesker.java110.ms.domain.Avi;
import indiesker.java110.ms.domain.Paging;

public interface AviService {
  List<Avi> list();
  void add(Avi avi);
  Avi get(int no);
  List<Avi> recentList(int no);
  Avi getfeedavibyAbno(int no);
  List<Avi> getAll();
  List<Avi> getPop();
  List<Avi> getFolAvi(int no);
  void uploadAvi(int bno, String title, String content, String url);
  Avi getfeedavibyAbnoNoComt(int no);
  void insertComment(int abno, int no, String cont);
  void delete(int abno);
  void reviseAvi(String titl, String cont, String urlid, int no);
  int totList(int no);
  List<Avi> morelist(int no, Paging paging);
}
