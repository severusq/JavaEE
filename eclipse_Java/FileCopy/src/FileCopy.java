import java.io.*;

class CopyMaker { //�ļ�����
	String sourceName, destName;
	BufferedReader source; //���������ٶȸ���
	BufferedWriter dest;
	String line;
	private boolean openFiles() {
		try {
			source = new BufferedReader(new FileReader(sourceName)); //��һ���ı��ļ�,���Ѵ��ڻ���ɾ��
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
	private boolean copyFiles() { //�ļ�����
		try {
			line = source.readLine(); //��ȡ���ݣ�һ�ζ�ȡһ������
			while (line != null) { //���������ݾͷ���null��������read()��ĩβ����-1
				dest.write(line); //��Ŀ���ļ�д������
				dest.newLine(); //��'\n'�����׵Ļ��з�ʽ
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
			source.close(); //�ر��ļ�
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
		if (args.length == 2) { //��ȡargs�����������п��ԣ���java��������Ҳ������޷���������FileCopy��
			new CopyMaker().copy(args[0], args[1]);
		}
		else {
			System.out.println("Please enter two files");
		}
	}

}
