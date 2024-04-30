package sec01;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private Connection con;
    private Statement stmt;
    private String driver = "your_driver";
    private String url = "your_url";
    private String user = "your_username";
    private String pwd = "your_password";

    public MemberDAO() {
        connDB();
    }

    private void connDB() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pwd);
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MemberVO> listMember() {
        List<MemberVO> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM members";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                MemberVO vo = new MemberVO();
                vo.setId(rs.getString("id"));
                vo.setPassword(rs.getString("password"));
                vo.setName(rs.getString("name"));
                vo.setEmail(rs.getString("email"));
                vo.setJoinDate(rs.getString("join_date"));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
