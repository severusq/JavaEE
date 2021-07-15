import java.io.*;

class CopyMaker { //文件复制
	String sourceName, destName;
	BufferedReader source; //缓冲器流速度更快
	BufferedWriter dest;
	String line;
	private boolean openFiles() {
		try {
			source = new BufferedReader(new FileReader(sourceName)); //打开一个文本文件,若已存在会先删除
		}
		catch (IOException iox) {
			System.out.println("Problem opening "+sourceName);
			return false;
		}
		try {
			dest = new BufferedWriter(new FileWriter(destName));
		}
		catch (IOException iox) {
			System.out.println("Problem opening " + destName);
			return false;
		}
		return true;
	}
	private boolean copyFiles() { //文件复制
		try {
			line = source.readLine(); //读取数据，一次读取一行数据
			while (line != null) { //不再有数据就返回null，或者用read()，末尾返回-1
				dest.write(line); //向目标文件写入数据
				dest.newLine(); //比'\n'更靠谱的换行方式
				line = source.readLine();
			}
		}
		catch (IOException iox) {
			System.out.println("Problem reading or writing");
			return false;
		}
		return true;
	}
	private boolean closeFiles() {
		boolean retVal = true;
		try {
			source.close(); //关闭文件
		}
		catch (IOException iox) {
			System.out.println("Problem closing " + sourceName);
			retVal = false;
		}
		try {
			dest.close();
		}
		catch (IOException iox) {
			System.out.println("Problem closing " + destName);
			retVal = false;
		}
		return retVal;
	}
	public boolean copy(String src, String dst) {
		sourceName = src;
		destName = dst;
		return openFiles() && copyFiles() && closeFiles();
	}
}

public class FileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 2) { //读取args参数，命令行可以，但java编译出错（找不到或无法加载主类FileCopy）
			new CopyMaker().copy(args[0], args[1]);
		}
		else {
			System.out.println("Please enter two files");
		}
	}

}
