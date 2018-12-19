import java.io.*;

public class FileUtil {
    public static String read(String filepath){
        StringBuffer stringBuffer=new StringBuffer();
        try{
            InputStreamReader reader=new InputStreamReader(new FileInputStream(filepath));
            BufferedReader bufferedReader=new BufferedReader(reader);
            String line="";
            line=bufferedReader.readLine();
            while(line!=null){
                stringBuffer.append(line+"\n");
                line=bufferedReader.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {

            return stringBuffer.toString();
        }
    }

    public static void write(String filepath,String content){
        try{
            File file = new File(filepath);
            file.createNewFile();
            BufferedWriter writer=new BufferedWriter(new FileWriter(file));
            writer.write(content);
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
