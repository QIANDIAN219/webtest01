import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.Tree;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.impl.LoginDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        LoginDaoImpl loginDao = new LoginDaoImpl();
        User user = loginDao.login("lgl", "lgl1234");
        String[][] title = new String[10][10];
        int m = 0, n = 0;
        for(Role role : user.getRoleList()) {
            for(Tree tree : role.getTreeList()) {
                if (tree.getIsParent().equals("True")) {
                    m++;
                    n=0;
                    System.out.println("m=" + m + "n=" + n + tree.getTitle());
                } else {
                    n++;
                    System.out.println("m=" + m + "n=" + n + tree.getTitle());
                }
                title[m][n] = tree.getTitle();
            }
        }
/*        for(int i = 0; i < title.length; i++) {
            for( int j = 0; j < title[i].length; j++) {
                if(title[i][j] != null) {
                    System.out.print("  " + title[i][j]);
                }

            }
            System.out.println("");
        }*/
    }


}
