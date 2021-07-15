import java.util.*;
import java.util.zip.*;
import java.lang.*;
import java.io.*;

class Unzip { //解压缩的类
	byte doc[] = null; //存储解压缩的缓冲字节数组
	String fileName = null;
	String UnzipPath = null;
	public Unzip(String filename, String UnzipPath) { //构造函数
		this.fileName = filename;
		this.UnzipPath = UnzipPath;
		this.setUnzipPath(this.UnzipPath);
	}
	public Unzip(String filename) { //构造函数
		this.fileName = new String(filename);
		this.UnzipPath = null;
		this.setUnzipPath(this.UnzipPath);
	}
	private void setUnzipPath(String unZipPath) { //设定解压路径，最后一定要是\\
		if (unZipPath.endsWith("\\")) { //String类的函数ensWith
			this.UnzipPath = new String(unZipPath);
		}
		else {
			this.UnzipPath = new String(unZipPath + "\\");
		}
	}
	public void doUnzip() { //解压函数
		try {
			ZipInputStream zipis = new ZipInputStream(new FileInputStream(fileName));
			ZipEntry fEntry = null; //声明入口
			while((fEntry = zipis.getNextEntry()) != null) { //不断取下一个入口
				if(fEntry.isDirectory()) { //如果入口是目录，就创建目录
					checkFilePath(UnzipPath+fEntry.getName());
				}
				else {
					String fname = new String(UnzipPath + fEntry.getName()); //根据文件原本的文件名创建文件
					try {
						FileOutputStream out = new FileOutputStream(fname);
						doc = new byte[512];
						int n;
						while ((n = zipis.read(doc, 0, 512)) != -1) { //read出来再用out的write就可以了
							out.write(doc, 0, n);
						}
						out.close();
						out = null;
						doc = null;
					}
					catch (Exception ex) {
						
					}
				}
			}
			zipis.close();
		}
		catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
	private void checkFilePath(String dirName) throws IOException {
		File dir = new File(dirName); //创建文件类
		if(!dir.exists()) { //如果目录不存在
			dir.mkdirs(); //创建目录
		}
	}
}

public class UnzipTester {
	public static void main(String[] args) { //对命令行中的输入解压到指定路径
		String zipFile = args[0];
		String unZipPath = args[1] + "\\";
		Unzip myzip = new Unzip(zipFile, unZipPath);
		myzip.doUnzip();
	}
}
