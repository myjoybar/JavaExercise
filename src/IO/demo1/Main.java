package IO.demo1;

import java.io.*;

public class Main {

    //http://blog.csdn.net/yczz/article/details/38761237
    static String pathName1 = "/Users/joybar/Documents/doc/testFile/create.txt";
    static String pathName2 = "/Users/joybar/Documents/doc/testFile/filelength.txt";
    static String pathName3 = "/Users/joybar/Documents/doc/testFile/student.txt";

    public static void main(String[] args) {

        System.out.println("Hello World!");
        createFile();
        getFileLength();
        copyFile();
        inputStudent();

    }


    /**
     * 文件处理示例
     */
    public static void createFile() {

        File f=new File(pathName1);
        try{
            f.createNewFile();  //当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。
            System.out.println("该分区大小"+f.getTotalSpace()/(1024*1024*1024)+"G"); //返回由此抽象路径名表示的文件或目录的名称。
            f.mkdirs();  //创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
//            f.delete(); //  删除此抽象路径名表示的文件或目录
            System.out.println("文件名  "+f.getName());  //  返回由此抽象路径名表示的文件或目录的名称。
            System.out.println("文件父目录字符串 "+f.getParent());// 返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    static private void getFileLength(){

        //TODO 自动生成的方法存根
        int count=0;  //统计文件字节长度
        InputStream streamReader = null;   //文件输入流
        try{
            streamReader=new FileInputStream(new File(pathName2));
          /*1.new File()里面的文件地址也可以写成D:\\David\\Java\\java 高级进阶\\files\\tiger.jpg,前一个\是用来对后一个
           * 进行转换的，FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。
          */
            while(streamReader.read()!=-1) {  //读取文件字节，并递增指针到下一个字节
                count++;
            }
            System.out.println("---长度是： "+count+" 字节");
        }catch (final IOException e) {
            //TODO 自动生成的 catch 块
            e.printStackTrace();
        }finally{
            try{
                streamReader.close();
            }catch (IOException e) {
                //TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    }


    static private void copyFile(){

        // TODO自动生成的方法存根
        byte[] buffer=new byte[512];   //一次取出的字节数大小,缓冲区大小
        int numberRead=0;
        FileInputStream input=null;
        FileOutputStream out =null;
        try {
            input=new FileInputStream(pathName2);
            out=new FileOutputStream(pathName1); //如果文件不存在会自动创建

            while ((numberRead=input.read(buffer))!=-1) {  //numberRead的目的在于防止最后一次读取的字节小于buffer长度，
                out.write(buffer, 0, numberRead);       //否则会自动被填充0
            }
            System.out.println("copy 成功");
        } catch (final IOException e) {
            // TODO自动生成的 catch 块
            e.printStackTrace();
        }finally{
            try {
                input.close();
                out.close();
            } catch (IOException e) {
                // TODO自动生成的 catch 块
                e.printStackTrace();
            }

        }
    }


    /**
     * 3.读写对象：ObjectInputStream 和ObjectOutputStream ，该流允许读取或写入用户自定义的类，但是要实现这种功能，被读取和写入的类必须实现Serializable接口，
     */
   static private void inputStudent(){
       // TODO自动生成的方法存根
       ObjectOutputStream objectwriter=null;
       ObjectInputStream objectreader=null;

       try {
           objectwriter=new ObjectOutputStream(new FileOutputStream(pathName3));
           objectwriter.writeObject(new Student("gg", 22));
           objectwriter.writeObject(new Student("tt", 18));
           objectwriter.writeObject(new Student("rr", 17));

           objectreader=new ObjectInputStream(new FileInputStream(pathName3));
           for (int i = 0; i < 3; i++) {
               System.out.println(objectreader.readObject());
           }
       } catch (IOException | ClassNotFoundException e) {
           // TODO自动生成的 catch 块
           e.printStackTrace();
       }finally{
           try {
               objectreader.close();
               objectwriter.close();
           } catch (IOException e) {
               // TODO自动生成的 catch 块
               e.printStackTrace();
           }

       }

   }


   static class Student implements Serializable{
        private String name;
        private int age;

        public Student(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student [name=" + name + ", age=" + age + "]";
        }





    }
}






