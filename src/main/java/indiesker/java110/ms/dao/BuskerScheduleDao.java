package indiesker.java110.ms.dao;

import java.util.List;
import java.util.Map;
import indiesker.java110.ms.domain.BuskerSchedule;

public interface BuskerScheduleDao {
  List<BuskerSchedule> findAll(Map<String,Object> params);

}