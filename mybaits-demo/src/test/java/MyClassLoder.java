import java.io.*;
/**
 * Created by wcy on 2019/3/14.
 */
public class MyClassLoder extends ClassLoader{

    private String classpath;

    public MyClassLoder(String path){
        this.classpath = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classDate = getDate(name);
        if(classDate != null){
            return  defineClass(name,classDate,0,classDate.length);
        }
        return super.findClass(name);
    }

    private byte[] getDate(String name){
        String path = classpath+ File.separatorChar +name.replace(".", String.valueOf(File.separatorChar)).concat(".class");
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(path);
            out = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer))!= -1){
                out.write(buffer,0,len);
            }
            return out.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
