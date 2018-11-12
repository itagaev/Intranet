import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class CourseFile {
    String path, name;
    File f;
    public CourseFile() {}

    public CourseFile(String name, String path){
        this.name = name;
        this.path = path;
        f = new File(this.path);
    }

    public String toString(){
        return this.name;
    }
}
