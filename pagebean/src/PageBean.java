import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by clouway on 06.06.16.
 *
 * @author alexandervladimirov1902@gmail.com
 *         (Alexander Vladimirov)
 */
public class PageBean<T> {
 private final List<T> elements;
  private final int pageSize;
  private int cursor=0;

  public PageBean(List<T> elements, int pageSize){
    this.elements = elements;
    this.pageSize = pageSize;
  }

  public List<T> next(){
    int end = cursor+pageSize;
    if (end > elements.size()){
      end=elements.size();
    }
    return getElements(end);
  }

  public List<T> previous(){
    int end = cursor - pageSize;
    this.cursor = end -pageSize;
    return getElements(end);
  }
public List<T> firstPage(){
  this.cursor = 0;
  return getElements(cursor + pageSize);

}

  public List<T> lastPage(){
    this.cursor = elements.size() - (elements.size()/pageSize);
    return getElements(elements.size());
  }

  public boolean hasNext(){
    if(cursor < elements.size()){
      return true;
    }
    return false;
  }

  public boolean hasPrevious(){
    if(cursor%pageSize==0){
      return false;
    }
    return true;
  }

  private List<T> getElements(int end){
    List<T> result = Lists.newArrayList();
    for ( int i  = this.cursor; i < end ; i++){
      result.add(this.elements.get(i));
      this.cursor++;
    }
    return result;
  }
}
