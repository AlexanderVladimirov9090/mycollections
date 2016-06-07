
import com.google.common.collect.Lists;

import java.util.List;


/**
 * Created by clouway on 06.06.16.
 *
 * @author alexandervladimirov1902@gmail.com
 * (Alexander Vladimirov)
 */
public class Demo {
  public static void main(String[] args) {
    List<Object> list =  Lists.newArrayList(1,2,3,4,5,6,7,8,9,10,11,12);
    PageBean pageBean = new PageBean(list, 3);


    System.out.println("First Page: " +  pageBean.firstPage());
    System.out.println("Last Page: " + pageBean.lastPage());

    System.out.println(pageBean.next());

   }
}
