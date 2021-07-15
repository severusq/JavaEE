import java.io.*;

public class FileTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "D:/data1.dat"; //������/��\\����ʾ·��
		DataOutputStream out; //�ֽ��������
		int sum = 0;
		int value0 = 255, value1 = -1;
		try {
			out = new DataOutputStream(new FileOutputStream(fileName)); //�򿪶������ļ����о���ɾ��
			out.writeInt(value0); //DataOutputStream��FileOuptStream��Ͽ���д��������ݣ���ͬ
			out.writeInt(value1); //д��int���ݣ�4���ֽ�
			out.close(); //�ر��ļ�
		}
		catch (IOException iox) {
			System.out.println("Problem writing " + fileName);
		}
		try {
			DataInputStream instr = new DataInputStream( //��ֻ����ʽ��һ���ļ�
									new BufferedInputStream(new FileInputStream(fileName)));
			try {
				while (true) {
					sum += instr.readInt(); //��ȡ4���ֽڲ�������int��
				}
			}
			catch (EOFException eof) { //����ĩβ��Ҫ��ȡ�Ͳ���EOF�쳣
				System.out.println("The sum is: " + sum);
				instr.close(); //�ر��ļ�����c++��ͬ����������ļ�
			}
		}
		catch (IOException iox) { //Ƕ��try�����Բ�׽�ϸ�catch��close�쳣
			System.out.println("IO problem with " + fileName);
		}
		try {
			out = new DataOutputStream(new FileOutputStream(fileName)); //���´��ļ������
			out.writeByte(-1); //д��һ���ֽ�
			out.close();
			DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			int a = in.readByte(); //��ȡһ���ֽڣ���24λ���Ჹ1
			System.out.println(Integer.toHexString(a)); //������ffffffff
			System.out.println(a); //�������-1
			in.skip(-1); //���һ��λ��
			a = in.readUnsignedByte(); //�����׳����쳣��֪��Ϊʲô
			System.out.println(Integer.toHexString(a)); //��������ff��ΪreadUnsignedByte����24λ��0
			System.out.println(a); //a=255
			in.close();
		}
		catch (IOException iox) {
			System.out.println("Problem3 with " + fileName);
		}
		File f = new File("D:" + File.separator + "Hello.txt"); //File�࣬�кܶ�API
		if(f.exists()) { //����ļ�����
			f.delete(); //ɾ������ļ�
			System.out.println("File exits, delete it");
		}
		else {
			System.out.println("File not exits, create it");
			try {
				f.createNewFile(); //����һ�����ļ�
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
