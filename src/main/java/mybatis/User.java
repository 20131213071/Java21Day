package mybatis;

/**
 * Created by smx on 2017/8/31.
 * Param
 * user表对应的实体类
 */
public class User {
    private int id;
    private int age;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString(){
        return "User[id="+id+",age="+age+"]";
    }
}
