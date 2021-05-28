import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;
public class Bucket implements Serializable {
    HashMap<String, Vector<String>> list ;
    Hashtable<String,String> min;
    Hashtable<String,String> max;
    String BucketId;
    Vector<String> colNames;
    Vector<Object>x;

    public Bucket(String id){
        BucketId=id;
        list = new HashMap<String,Vector<String>>();
    }
    public Vector<String> search(String s){
        Vector<String> path = new Vector<String>();
        path  =list.get(s);
    return path;}
    static Vector<Object> a ;


/*public void insert(String tableName) {
    Table t = getTable(tableName);
    for (int i = 0; i < t.pagesPath.size(); i++) {
        Page p = DBApp.deserialize(t.pagesPath.get(i));
        for (int j = 0; j < p.list.size(); j++) {
            Vector <String> paths= new Vector();
            Set<String> columns = min.keySet();
            for (String k : columns) {
                if(p.list.get(j).get(k).toString().compareTo(min.get(k))>0 && p.list.get(j).get(k).toString().compareTo(max.get(k))<0){
                    paths.add(t.pagesPath.get(i));
                    list.put(p.list.get(j).get(t.clusteringKey).toString(),paths);
                }
            }

        }
    }
} */
public Table getTable(String tableName){
      Vector<String> tables = null;
      Vector<String > tableNames =DBApp.deserializeVector("src/main/resources/data/tableNames.bin");
      String tableFilePath="";
      Table t = null;
      tables = DBApp.deserializeVector("src/main/resources/data/tablesList.bin");
      for(int i =0 ;i<tables.size();i++){
          if (tableNames.get(i).compareTo(tableName) == 0) {
              tableFilePath = tables.get(i);
              t = DBApp.DeserializeTable(tableFilePath);
              break;
          }
      }
return t;}

}